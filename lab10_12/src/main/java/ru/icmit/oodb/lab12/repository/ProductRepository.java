package ru.icmit.oodb.lab12.repository;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.icmit.oodb.lab12.controller.rest.RestModel;
import ru.icmit.oodb.lab12.domain.classes.Product;
import ru.icmit.oodb.lab12.domain.classes.Worker;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class ProductRepository {
    @PersistenceContext(name = "entityManagerFactory")
    protected EntityManager entityManager;

    // Запрос всех
    public List<Product> findAll() {
        Query query = entityManager.createQuery(
                "select c from Product c ", Product.class);

        query.setMaxResults(100);

        List<Product> products = query.getResultList();

        return products;

    }
    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    public List<RestModel> findAccountByName(String name) {

        Query query = entityManager.createQuery(
                "select new ru.icmit.oodb.lab12.controller.rest.RestModel(a.id, a.name)" +
                        " from Product a where a.name like :name ", RestModel.class);

        query.setParameter("name", "%" + name + "%");
        List<RestModel> products = query.getResultList();

        return products;
    }

    // Удалить
    @Transactional
    public boolean removeProduct(Long id) {
        Product product = entityManager.find(Product.class, id);

        if (product == null) return false;

        entityManager.remove(product);

        return true;
    }

    // Сохранить/обновить данные
    @Transactional
    public Product save(Product product) {

        if (product == null ) return null;

        if (product.getId() != null) {
            product = entityManager.merge(product);
        } else {
            entityManager.persist(product);
        }

        return product;
    }
}
