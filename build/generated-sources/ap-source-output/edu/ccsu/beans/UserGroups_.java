package edu.ccsu.beans;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-03T18:04:24")
@StaticMetamodel(UserGroups.class)
public class UserGroups_ { 

    public static volatile SingularAttribute<UserGroups, Long> id;
    public static volatile SingularAttribute<UserGroups, String> groupname;
    public static volatile SingularAttribute<UserGroups, BigInteger> version;
    public static volatile SingularAttribute<UserGroups, String> username;

}