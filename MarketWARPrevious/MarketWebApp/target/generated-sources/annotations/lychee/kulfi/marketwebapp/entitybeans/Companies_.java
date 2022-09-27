package lychee.kulfi.marketwebapp.entitybeans;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lychee.kulfi.marketwebapp.entitybeans.Profiles;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-07-23T19:38:59")
@StaticMetamodel(Companies.class)
public class Companies_ { 

    public static volatile SingularAttribute<Companies, String> pinCode;
    public static volatile SingularAttribute<Companies, String> phone;
    public static volatile ListAttribute<Companies, Profiles> profilesList;
    public static volatile SingularAttribute<Companies, Profiles> managerProfileId;
    public static volatile SingularAttribute<Companies, String> address;
    public static volatile SingularAttribute<Companies, String> status;
    public static volatile SingularAttribute<Companies, String> about;
    public static volatile SingularAttribute<Companies, Integer> companyId;
    public static volatile SingularAttribute<Companies, String> companyName;
    public static volatile SingularAttribute<Companies, String> country;

}