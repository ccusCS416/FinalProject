/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.controller;

import edu.ccsu.model.Customer;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author sabo
 */
@ManagedBean
public class CustomerControllerSoIn {
    @PersistenceUnit(unitName = "WebApplication1PU")
    private EntityManagerFactory entityManagerFactory;
    @Resource
    private UserTransaction userTransaction;
    @ManagedProperty(value = "#{customer}")
    private Customer customer;
    
    private List<Integer> selectedItems;

    public List<Integer> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(List<Integer> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public String saveCustomer() {
        String returnValue = "error";
        try {
            userTransaction.begin();
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.persist(getCustomer());
            userTransaction.commit();
            entityManager.close();
            returnValue = "customerSaved";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    public String deleteCustomer() {
        String returnValue = "error";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            userTransaction.begin();
            entityManager.remove(customer);
            userTransaction.commit();
            returnValue = "deleteSuccessful";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }
    
    public String addToCart(){
        String returnValue = "error";
        try{
            returnValue = "Cart";
        } catch (Exception e){
            e.printStackTrace();
        }
        return returnValue;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
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
