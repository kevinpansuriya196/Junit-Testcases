package com.junit.controllers;

import com.junit.models.EmpModel;
import com.junit.services.EmpService;
import com.sun.source.tree.ModuleTree;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class EmpControllerTest {

    @InjectMocks
    private EmpController empController;

    @Mock
    private EmpService empService;


    @Test
    void testGetAllEmpMY() {
        List<EmpModel> list1 = new ArrayList<>();
        Mockito.when(empService.getAllEmps()).thenReturn(list1);
        List<EmpModel> response = empController.getAllEmps();
        Assertions.assertEquals(list1, response);

    }

    @Test
    void testGetAllEmp() {
        List<EmpModel> expectedList = new ArrayList<>();
        Mockito.when(empService.getAllEmps()).thenReturn(expectedList);
        List<EmpModel> actualList = empController.getAllEmps();
        Assertions.assertEquals(expectedList, actualList);
    }


    @Test
    void testGetEmpById() {
        EmpModel expectedList = new EmpModel();
        int id = 1;
        Mockito.when(empService.getEmpById(id)).thenReturn(expectedList);
        EmpModel result = empController.getEmpById(id);
        Assertions.assertEquals(result, expectedList);

    }

    @Test
    void testGetByName() {
        List<EmpModel> response = new ArrayList<>();
        String name = " ";
        Mockito.when(empService.getByName(name)).thenReturn(response);
        List<EmpModel> list1 = empController.getByName(name);
        Assertions.assertEquals(list1, response);
    }

    @Test
    void testCreateEmp() {

        EmpModel model = new EmpModel();
        EmpModel empModel = new EmpModel();
        Mockito.when(empService.createEmp(any())).thenReturn(empModel);
        EmpModel response = empController.createEmp(model);
        Assertions.assertEquals(empModel, response);
    }

    @Test
    void testUpdateEmp() {

        int id = 1;
        EmpModel Expected = new EmpModel();
        Mockito.when(empService.updateEmp(id, Expected)).thenReturn(Expected);
        EmpModel response = empController.updateEmp(id,Expected);
        Assertions.assertEquals(Expected, response);
    }

    @Test
    void testDeleteEmp() {

        int id = 1;
        String expected = "data deleted";
        Mockito.when(empService.deleteEmp(id)).thenReturn(expected);
        String response = empController.deleteEmp(id);
        Assertions.assertEquals(expected,response);
    }
}