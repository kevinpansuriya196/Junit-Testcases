package com.junit.controllers;


import com.junit.models.EmpModel;
import com.junit.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;


    @GetMapping("/")
    public List<EmpModel> getAllEmps(){

        return this.empService.getAllEmps();
    }

    @GetMapping("/{id}")
    public EmpModel getEmpById(@PathVariable int id){
        return this.empService.getEmpById(id);
    }



    @GetMapping("/findName/{name}")
    public List<EmpModel> getByName(@PathVariable String name){
        return this.empService.getByName(name);
    }


    @PostMapping("/")
    public EmpModel createEmp(@RequestBody EmpModel emp){
        return this.empService.createEmp(emp);
    }

    @PutMapping("/{id}")
    public EmpModel updateEmp(@PathVariable int id, @RequestBody EmpModel emp){
      return this.empService.updateEmp(id,emp);
    }

    @DeleteMapping("/{id}")
    public String deleteEmp(@PathVariable int id){
        this.empService.deleteEmp(id);
        return "data deleted";
    }

}
