package com.capgemini.assessment1.IdManagementSystem;

import jakarta.persistence.*;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("myPersistence");

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Employee employee = new Employee("Rahil", "rahil@gmail.com");

            IDCard idCard = new IDCard("ID101", LocalDate.now());

            employee.setIdCard(idCard);

            em.persist(employee);

            em.getTransaction().commit();

            System.out.println("Employee Created Successfully");

            Employee foundEmployee = em.find(Employee.class, employee.getId());

            System.out.println("\nEmployee Details:");
            System.out.println("ID: " + foundEmployee.getId());
            System.out.println("Name: " + foundEmployee.getName());
            System.out.println("Email: " + foundEmployee.getEmail());

            System.out.println("\nID Card Details:");
            System.out.println("Card Number: " +
                    foundEmployee.getIdCard().getCardNumber());
            System.out.println("Issue Date: " +
                    foundEmployee.getIdCard().getIssueDate());


        } finally {
            em.close();
            emf.close();
        }
    }
}

