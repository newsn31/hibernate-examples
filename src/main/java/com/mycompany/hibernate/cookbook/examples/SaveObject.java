package com.mycompany.hibernate.cookbook.examples;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.mycompany.hibernate.cookbook.entities.Department;
import com.mycompany.hibernate.cookbook.entities.Employee;
import com.mycompany.hibernate.cookbook.entities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author quang
 */
public class SaveObject {
    public static void main(String [] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        //begin a transaction
        session.getTransaction().begin();
        
        //creating a department object
        Department department = new Department();
        department.setDeptName("Optics");
        
        //save department object
        session.save(department);
        System.out.println("Department saved, id: " + department.getId());
        
        //create an employee object
        Employee employee = new Employee();
        employee.setFirstName("Scott");
        employee.setLastName("Summers");
        employee.setSalary(50000);
        employee.setDepartment(department);
        
        //save employee object
        session.save(employee);
        System.out.println("Employee saved, id: " + employee.getId());
        
        //commit transaction
        session.getTransaction().commit();
        session.close();
        
        HibernateUtil.shutdown();
    }
}
