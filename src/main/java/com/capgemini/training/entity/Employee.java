package com.capgemini.training.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "emp_id")
    private String empId;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "emp_email")
    private String empEmail;

    @Column(name = "emp_contact_no")
    private Long empContactNo;

    @Column(name = "emp_city")
    private String empCity;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public Long getEmpContactNo() {
        return empContactNo;
    }

    public void setEmpContactNo(long contactNo) {
        this.empContactNo = contactNo;
    }

    public String getEmpCity() {
        return empCity;
    }

    public void setEmpCity(String empCity) {
        this.empCity = empCity;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee emp = (Employee) o;
        return id == emp.id;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }
}