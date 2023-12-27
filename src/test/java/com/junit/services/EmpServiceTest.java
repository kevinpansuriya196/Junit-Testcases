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

import java.util.ArrayList;
import java.util.List;
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
    void getAllEmps() {
        List<EmpModel> expected = new ArrayList<>();
        Mockito.when(empRepository.findAll()).thenReturn(expected);
        List<EmpModel> response = empService.getAllEmps();
        Assertions.assertEquals(expected, response);
    }

    @Test
    void getEmpById() {
        int id = 1;
        EmpModel expected = new EmpModel();
        Mockito.when(empRepository.findById(id)).thenReturn(Optional.of(expected));
        EmpModel response = empService.getEmpById(id);
        Assertions.assertEquals(expected, response);

    }

    @Test
    void getByName() {
        String name = "abc";
        List<EmpModel> expected = new ArrayList<>();
        Mockito.when(empRepository.findByName(name)).thenReturn(expected);
        List<EmpModel> response = empService.getByName(name);
        Assertions.assertEquals(expected, response);
    }

    @Test
    void createEmp() {
        EmpModel expected = new EmpModel();
        EmpModel model = new EmpModel();
        Mockito.when(empRepository.save(any())).thenReturn(expected);
        EmpModel response = empService.createEmp(model);
        Assertions.assertEquals(expected, response);
    }

    @Test
    void updateEmp() {
        int id = 1;
        EmpModel expected = new EmpModel(1,"pk","pk@gmail.com");
        EmpModel model = new EmpModel(1,"pk","pk@gmail.com");
        Mockito.when(empRepository.findById(id)).thenReturn(Optional.of(model));
        EmpModel response = empService.updateEmp(id, expected);
        Assertions.assertEquals(expected, response);


    }

    @Test
    void deleteEmp() {
        int id = 1;
        String response = empService.deleteEmp(id);
        Assertions.assertEquals("", response);

    }


}