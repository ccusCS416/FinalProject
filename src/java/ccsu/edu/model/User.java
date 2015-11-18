/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccsu.edu.model;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author sabo
 */
@ManagedBean
@Entity
public class User implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private String firstName = "";
    private String lastName = "";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
