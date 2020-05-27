package ru.icmit.oodb.lab12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.icmit.oodb.lab12.domain.classes.Product;
import ru.icmit.oodb.lab12.repository.ProductRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository repository;


    @RequestMapping("/product")
    public String products(HttpServletRequest request, @ModelAttribute("model") ModelMap model) {
        String path = request.getContextPath();

        model.addAttribute("app_path", path);


        List<Product> products = repository.findAll();

        model.addAttribute("products", products);

        return "/products";
    }

    @RequestMapping("/addproduct")
    @Transactional
    public String addProduct(HttpServletRequest request,
                            @RequestParam(value = "id", required = false) Long id,
                            @RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "stock", required = false) Integer stock,
                            @RequestParam(value = "price", required = false) Double price,
                            @ModelAttribute("model") ModelMap model)
    {

        String path = request.getContextPath();
        model.addAttribute("app_path", path);

        Product product = null;
        if (id != null) {
            product = repository.findById(id);
        }

        if (product == null) {
            product = new Product();
        }

        if (name != null) {
            // Используем параметры формы
            product.setPrice(price);
            product.setName(name);
            product.setStock(stock);

            product = repository.save(product);
        }

        model.addAttribute("product", product);

        return "/product";
    }

    @RequestMapping("/deleteproduct")
    @Transactional
    public String deleteAllProduct(HttpServletRequest request,
                                  @RequestParam("id") Long id,
                                  @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);

        Product product = repository.findById( id );

        repository.removeProduct( id );


        model.addAttribute("product", product);
        return "/product";
    }


}
