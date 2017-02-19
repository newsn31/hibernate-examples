/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate.cookbook.examples;

import com.mycompany.hibernate.cookbook.entities.Employee;
import com.mycompany.hibernate.cookbook.entities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author quang
 */
public class UpdateAnObject {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Employee employee = (Employee) session.get(Employee.class, new Long(4));

        session.getTransaction().begin();
        employee.setFirstName("updated");
        session.update(employee);
        
        session.getTransaction().commit();
        System.out.println("\nEmployee after Update...");
	System.out.println(employee.getFirstName());
        
        session.close();
        HibernateUtil.shutdown();
        
    }
}
