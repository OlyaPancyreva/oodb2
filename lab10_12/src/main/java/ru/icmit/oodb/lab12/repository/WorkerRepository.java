package ru.icmit.oodb.lab12.repository;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.icmit.oodb.lab12.controller.rest.RestModel;
import ru.icmit.oodb.lab12.domain.classes.Worker;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class WorkerRepository {
    @PersistenceContext(name = "entityManagerFactory")
    protected EntityManager entityManager;

    // Запрос всех
    public List<Worker> findAll() {
        Query query = entityManager.createQuery(
                "select c from Worker c ", Worker.class);

        query.setMaxResults(100);

        List<Worker> workers = query.getResultList();

        return workers;

    }

    public Worker findById(Long id) {
        return entityManager.find(Worker.class, id);
    }

    public List<RestModel> findAccountByName(String name) {

        Query query = entityManager.createQuery(
                "select new ru.icmit.oodb.lab12.controller.rest.RestModel(a.id, a.name)" +
                        " from Worker a where a.name like :name ", RestModel.class);

        query.setParameter("name", "%" + name + "%");
        List<RestModel> workers = query.getResultList();

        return workers;
    }


    // Удалить
    @Transactional
    public boolean removeWorker(Long id) {
        Worker worker = entityManager.find(Worker.class, id);

        if (worker == null) return false;

        entityManager.remove(worker);

        return true;
    }

    // Сохранить/обновить данные
    @Transactional
    public Worker save(Worker worker) {

        if (worker == null ) return null;

        if (worker.getId() != null) {
            worker = entityManager.merge(worker);
        } else {
            entityManager.persist(worker);
        }

        return worker;
    }
}
