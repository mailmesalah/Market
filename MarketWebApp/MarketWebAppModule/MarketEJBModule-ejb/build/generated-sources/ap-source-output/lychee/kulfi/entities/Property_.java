package lychee.kulfi.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lychee.kulfi.entities.Product;
import lychee.kulfi.entities.PropertyType;
import lychee.kulfi.entities.PropertyUnit;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-07-29T20:19:07")
@StaticMetamodel(Property.class)
public class Property_ { 

    public static volatile SingularAttribute<Property, String> propertyName;
    public static volatile SingularAttribute<Property, Integer> propertyId;
    public static volatile SingularAttribute<Property, PropertyType> propertyTypeId;
    public static volatile SingularAttribute<Property, PropertyUnit> propertyUnitId;
    public static volatile ListAttribute<Property, Product> productList;

}