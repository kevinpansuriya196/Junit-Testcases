package com.junit.services;

import com.junit.models.EmpModel;
import com.junit.repository.EmpRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class EmpServiceTest {

    @InjectMocks
    private EmpService empService;

    @Mock
    private EmpRepository empRepository;

    @Test
    void getAllEmp() {
        List<EmpModel> expected = new ArrayList<>();
        Mockito.when(empRepository.findAll()).thenReturn(expected);
        List<EmpModel> response = empService.getAllEmps();
        Assertions.assertEquals(expected, response);
    }
    /* -  ----------------------getEmpById1---------------------  -  */

    @Test
    void getEmpById1() {
        int id = 1;
        EmpModel expected = new EmpModel();
        Mockito.when(empRepository.findById(id)).thenReturn(Optional.of(expected));
        EmpModel response = empService.getEmpById1(id);
        Assertions.assertEquals(expected, response);

    }
    /* -  -------------------getListEmpById------------------------  -  */


    @Test
    void getEmpById() {
        int id = 1;
        EmpModel expected = new EmpModel();
        Mockito.when(empRepository.findById(id)).thenReturn(Optional.of(expected));
        EmpModel response = empService.getEmpById1(id);
        Assertions.assertEquals(expected, response);

    }

    @Test
    void getListEmpByIdException() {

        List<EmpModel> model = new ArrayList<>();
        int id = 0;
        Mockito.when(empRepository.findEmpsById(id)).thenReturn(model);

//        List<EmpModel> response = empService.getListEmpById(1);
//        Assertions.assertEquals(0, response.size());
        Assertions.assertThrows(Exception.class, () -> {
            empService.getListEmpById(1);
        });
    }

    @Test
    void getListEmpById() throws Exception {
        int id = 1;
        List<EmpModel> expected = new ArrayList<>();
        Mockito.when(empRepository.findEmpsById(id)).thenReturn(expected);
        List<EmpModel> response = empService.getListEmpById(1);
        Assertions.assertEquals(expected, response);
    }

    /* -  ----------------getByName1---------------------------  -  */

    @Test
    void getByName() {
        String name = "abc";
        List<EmpModel> expected = new ArrayList<>();
        Mockito.when(empRepository.findByName(name)).thenReturn(expected);
        List<EmpModel> response = empService.getByName1(name);
        Assertions.assertEquals(expected, response);
    }


    @Test
    void WhenNameIsNull() {
        String name = null;
        List<EmpModel> expected = new ArrayList<>();
//        Mockito.when(empRepository.findByName(name)).thenReturn(expected);
        List<EmpModel> response = empService.getByName(name);
        Assertions.assertEquals(expected, response);
    }

    @Test
    void WhenNameIsEmpty() {
        String name = "";
        List<EmpModel> expected = new ArrayList<>();
//        Mockito.when(empRepository.findByName(name)).thenReturn(expected);
        List<EmpModel> response = empService.getByName(name);
        Assertions.assertEquals(expected, response);
    }

    @Test
    void ReturnsEmpModels() {
        String name = "abc";
        List<EmpModel> expected = new ArrayList<>();
        Mockito.when(empRepository.findByName(name)).thenReturn(expected);
        List<EmpModel> response = empService.getByName1(name);
        Assertions.assertEquals(expected, response);

    }


    /* -  --------------------createEmp-----------------------  -  */

    @Test
    void createEmp() {
        EmpModel expected = new EmpModel();
        EmpModel model = new EmpModel();
        Mockito.when(empRepository.save(any())).thenReturn(expected);
        EmpModel response = empService.createEmp(model);
        Assertions.assertEquals(expected, response);
    }
    /* -  --------------------updateEmp-----------------------  -  */

    @Test
    void updateEmp() {
        int id = 1;
//        EmpModel expected = new EmpModel(1,"pk","pk@gmail.com");
        EmpModel emp = new EmpModel();
        emp.setName("pk");
        EmpModel model = new EmpModel(1, "pk", "pk@gmail.com");
        Mockito.when(empRepository.findById(id)).thenReturn(Optional.of(model));
        Mockito.when(empRepository.save(any())).thenReturn(model);
        EmpModel response = empService.updateEmp(id, emp);
        Assertions.assertEquals("pk", response.getName());


    }
    /* -  -------------------updateEmp true false------------------------  -  */

    @Test
    void updateEmpTrue() {

        EmpModel emp = new EmpModel();

        Mockito.when(empRepository.findById(any())).thenReturn(Optional.of(emp));

        EmpModel empModelResp = empService.updateEmp(1, emp);
    }
    /* -  --------------------deleteEmp -----------------------  -  */

    @Test
    void deleteEmp() {
        int id = 1;
        String response = empService.deleteEmp(id);
        Assertions.assertEquals("", response);

    }


}