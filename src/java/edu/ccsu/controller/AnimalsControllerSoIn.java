/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.controller;

import edu.ccsu.model.Animals;
import edu.ccsu.model.Customer;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

/**
 *
 * @author sabo
 */
@ManagedBean
public class AnimalsControllerSoIn {    @PersistenceUnit(unitName = "WebApplication1PU")
    private EntityManagerFactory entityManagerFactory;
    @Resource
    private UserTransaction userTransaction;
    @ManagedProperty(value = "#{animals}")
    private Animals animal;

    public String saveAnimal() {
        String returnValue = "error";
        try {
            userTransaction.begin();
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.persist(getAnimal());
            userTransaction.commit();
            entityManager.close();
            returnValue = "animalSaved";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    public String deleteAnimal() {
        String returnValue = "error";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            userTransaction.begin();
            entityManager.remove(animal);
            userTransaction.commit();
            returnValue = "deleteSuccessful";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    /**
     * @return the customer
     */
    public Animals getAnimal() {
        return animal;
    }

    /**
     * @param customer the customer to set
     */
    public void setAnimal(Animals animal) {
        this.animal = animal;
    }
    //this managed property will read value from request parameter rebate
    @ManagedProperty(value = "#{param.inital}")
    private String initial;

    public String getInitial() {
        return initial == null ? "" : initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }
}