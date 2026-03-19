package com.capgemini.training.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.training.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    @Query("SELECT e FROM Employee e WHERE e.empName LIKE %:keyword% OR e.empEmail LIKE %:keyword%")
    List<Employee> search(@Param("keyword") String keyword);
}