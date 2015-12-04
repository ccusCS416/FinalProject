package edu.ccsu.model;

import edu.ccsu.model.Animals;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-03T18:37:46")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> firstname;
    public static volatile SingularAttribute<Customer, Integer> id;
    public static volatile SetAttribute<Customer, Animals> animals;
    public static volatile SingularAttribute<Customer, String> lastname;

}