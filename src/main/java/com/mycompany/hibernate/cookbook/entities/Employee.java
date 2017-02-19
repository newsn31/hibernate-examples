/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate.cookbook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author quang
 */
@Entity
@Table(name="employee")
public class Employee {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name="firstname")
    private String firstName;
    
    @Column (name="lastname")
    private String lastName;
    
    @Column (name="salary")
    private double salary;
    
    @JoinColumn(name="department")
    @ManyToOne
    private Department department;
    
    public Employee(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
    
    public void printEmployee() {
        System.out.println("\nEmployee:");
        System.out.println(this.getFirstName());
        System.out.println(this.getLastName());
        System.out.println(this.getSalary());
        System.out.println(this.getDepartment());
    }
}
