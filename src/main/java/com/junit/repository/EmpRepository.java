package com.junit.repository;

import com.junit.models.EmpModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmpRepository extends JpaRepository<EmpModel,Integer> {


    List<EmpModel> findByName(String name);
    List<EmpModel> findEmpsById(int id);

}
