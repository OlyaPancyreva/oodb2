package ru.icmit.oodb.lab12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.icmit.oodb.lab12.domain.classes.Product;
import ru.icmit.oodb.lab12.repository.ProductRepository;
import ru.icmit.oodb.lab12.repository.WorkerRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DeleteObjectController {

    @Autowired
    private WorkerRepository repository;
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/worker/delete")
    public String deleteWorker(HttpServletRequest request,
                          @RequestParam("workerId") Long workerId,
                          @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);

        repository.removeWorker(workerId);
        return "/delobject";
    }
 @RequestMapping("/product/delete")
    public String deleteProduct(HttpServletRequest request,
                          @RequestParam("productId") Long workerId,
                          @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);

        productRepository.removeProduct(workerId);
        return "/delobject";
    }

    @RequestMapping("/delobject")
    public String delObject(HttpServletRequest request,
                            @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);


        return "/delobject";
    }
}
