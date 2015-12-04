package edu.ccsu.model;

import edu.ccsu.model.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-03T18:37:46")
@StaticMetamodel(Animals.class)
public class Animals_ { 

    public static volatile SingularAttribute<Animals, Integer> price;
    public static volatile SingularAttribute<Animals, String> animaltype;
    public static volatile SingularAttribute<Animals, Integer> id;
    public static volatile SingularAttribute<Animals, String> animalname;
    public static volatile SingularAttribute<Animals, Customer> customer;

}