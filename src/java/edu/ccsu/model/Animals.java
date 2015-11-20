/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cameron
 */
@Entity
@ManagedBean
@Table(name = "ANIMALS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Animals.findAll", query = "SELECT a FROM Animals a"),
    @NamedQuery(name = "Animals.findById", query = "SELECT a FROM Animals a WHERE a.id = :id"),
    @NamedQuery(name = "Animals.findByAnimaltype", query = "SELECT a FROM Animals a WHERE a.animaltype = :animaltype"),
    @NamedQuery(name = "Animals.findByAnimalname", query = "SELECT a FROM Animals a WHERE a.animalname = :animalname"),
    @NamedQuery(name = "Animals.findByPrice", query = "SELECT a FROM Animals a WHERE a.price = :price")})
public class Animals implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "ANIMALTYPE")
    private String animaltype;
    @Size(max = 255)
    @Column(name = "ANIMALNAME")
    private String animalname;
    @Column(name = "PRICE")
    private Integer price;

    public Animals() {
    }

    public Animals(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnimaltype() {
        return animaltype;
    }

    public void setAnimaltype(String animaltype) {
        this.animaltype = animaltype;
    }

    public String getAnimalname() {
        return animalname;
    }

    public void setAnimalname(String animalname) {
        this.animalname = animalname;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animals)) {
            return false;
        }
        Animals other = (Animals) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ccsu.model.Animals[ id=" + id + " ]";
    }
    
}
