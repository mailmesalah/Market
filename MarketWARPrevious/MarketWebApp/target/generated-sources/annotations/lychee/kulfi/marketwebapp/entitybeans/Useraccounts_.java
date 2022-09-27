package lychee.kulfi.marketwebapp.entitybeans;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lychee.kulfi.marketwebapp.entitybeans.Profiles;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-07-23T19:38:59")
@StaticMetamodel(Useraccounts.class)
public class Useraccounts_ { 

    public static volatile SingularAttribute<Useraccounts, String> username;
    public static volatile SingularAttribute<Useraccounts, Profiles> profileId;
    public static volatile SingularAttribute<Useraccounts, Integer> userId;
    public static volatile SingularAttribute<Useraccounts, String> userRole;
    public static volatile SingularAttribute<Useraccounts, String> password;

}