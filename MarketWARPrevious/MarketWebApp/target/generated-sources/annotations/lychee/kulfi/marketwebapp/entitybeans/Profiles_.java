package lychee.kulfi.marketwebapp.entitybeans;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lychee.kulfi.marketwebapp.entitybeans.Companies;
import lychee.kulfi.marketwebapp.entitybeans.Useraccounts;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-07-23T19:38:59")
@StaticMetamodel(Profiles.class)
public class Profiles_ { 

    public static volatile SingularAttribute<Profiles, String> phone;
    public static volatile SingularAttribute<Profiles, Useraccounts> useraccounts;
    public static volatile SingularAttribute<Profiles, String> address;
    public static volatile SingularAttribute<Profiles, String> status;
    public static volatile SingularAttribute<Profiles, Integer> profileId;
    public static volatile SingularAttribute<Profiles, Companies> companies;
    public static volatile SingularAttribute<Profiles, Companies> companyId;
    public static volatile SingularAttribute<Profiles, String> profileName;

}