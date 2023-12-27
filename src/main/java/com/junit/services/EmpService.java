package com.junit.services;

import com.junit.models.EmpModel;
import com.junit.repository.EmpRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {


    private static final Logger LOGGER = LoggerFactory.getLogger(EmpModel.class);

    private String TAG_NAME = "CpeServiceImpl";


    @Autowired
    private EmpRepository empRepository;

    public List<EmpModel> getAllEmps(){
        System.out.println("------------------before--------------------");
        LOGGER.info(TAG_NAME + " :: inside getAllEmps");
        System.out.println("------------------after--------------------");
        return this.empRepository.findAll();
    }

    public EmpModel getEmpById(int id){
        EmpModel emp=this.empRepository.findById(id).get();
        return emp;
    }


    public List<EmpModel> getByName(String name){
        return this.empRepository.findByName(name);
    }

    public EmpModel createEmp(EmpModel emp){
        EmpModel createdEmp=this.empRepository.save(emp);
        return createdEmp;
    }

    public EmpModel updateEmp(int id, EmpModel emp){
        EmpModel foundEmp=this.empRepository.findById(id).get();
        if (!foundEmp.equals("")){
            foundEmp.setName(emp.getName());
            foundEmp.setEmail(emp.getEmail());
            this.empRepository.save(foundEmp);
        }
        return foundEmp;
    }

    public String deleteEmp(int id){
        this.empRepository.deleteById(id);
        return "";
    }
}
