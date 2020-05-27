package ru.icmit.oodb.lab12.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.icmit.oodb.lab12.repository.WorkerRepository;

import java.util.List;

@RestController
public class AccountRestController {

    @Autowired
    private WorkerRepository workerRepository;

    @ResponseBody
    @RequestMapping(value = "/rest/account")
    public List<RestModel> getAccountList(@RequestParam(name = "name", required = false, defaultValue = "")String name) {

        return workerRepository.findAccountByName( name );
    }

}
