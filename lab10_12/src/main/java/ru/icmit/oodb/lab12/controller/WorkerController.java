package ru.icmit.oodb.lab12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.icmit.oodb.lab12.domain.classes.Worker;
import ru.icmit.oodb.lab12.repository.WorkerRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class WorkerController {

    @Autowired
    private WorkerRepository repository;


    @RequestMapping("/worker")
    public String workers(HttpServletRequest request, @ModelAttribute("model") ModelMap model) {
        String path = request.getContextPath();

        model.addAttribute("app_path", path);


        List<Worker> workers = repository.findAll();

        model.addAttribute("workers", workers);

        return "/workers";
    }

    @RequestMapping("/addworker")
    @Transactional
    public String addWorker(HttpServletRequest request,
                            @RequestParam(value = "id", required = false) Long id,
                            @RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "number", required = false) String number,
                            @RequestParam(value = "gender", required = false) String gender,
                            @RequestParam(value = "salary", required = false) Double salary,
                            @ModelAttribute("model") ModelMap model)
    {

        String path = request.getContextPath();
        model.addAttribute("app_path", path);

        Worker worker = null;
        if (id != null) {
            worker = repository.findById(id);
        }

        if (worker == null) {
            worker = new Worker();
        }

        if ( number != null || name != null) {
            // Используем параметры формы
            worker.setGender(gender);
            worker.setName(name);
            worker.setNumber(number);
            worker.setSalary(salary);

            worker = repository.save(worker);
        }

        model.addAttribute("worker", worker);

        return "/worker";
    }

    @RequestMapping("/deleteworker")
    @Transactional
    public String deleteAllWorker(HttpServletRequest request,
                                    @RequestParam("id") Long id,
                                    @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();

        model.addAttribute("app_path", path);

        Worker worker = repository.findById( id );

        repository.removeWorker( id );


        model.addAttribute("worker", worker);
        return "/worker";
    }


}
