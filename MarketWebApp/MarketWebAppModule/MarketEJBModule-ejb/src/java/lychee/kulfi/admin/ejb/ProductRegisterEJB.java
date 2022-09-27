/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lychee.kulfi.admin.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import lychee.kulfi.admin.pojo.ProductPojo;
import lychee.kulfi.admin.pojo.PropertyPojo;
import lychee.kulfi.admin.pojo.PropertyTypePojo;
import lychee.kulfi.admin.pojo.PropertyUnitPojo;
import lychee.kulfi.entities.Product;
import lychee.kulfi.entities.Property;

/**
 *
 * @author Sely
 */
@Stateless
public class ProductRegisterEJB implements ProductRegisterEJBRemote {
    @PersistenceContext(unitName = "StorageUnit")
    private EntityManager em;

    @Override
    public List<ProductPojo> getAllProductsOrderByName() {
        TypedQuery<Product> query = em.createNamedQuery("Product.findAllOrderByName", Product.class);
        List<Product> productList=query.getResultList();
        
        List<ProductPojo> returnList = new ArrayList<>();
        for (Product product : productList) {
            ProductPojo p = new ProductPojo();           
            p.setProductId(product.getProductId());
            p.setProductName(product.getProductName());
            
            for (Property property : product.getPropertyList()) {
                PropertyPojo pr = new PropertyPojo();
                pr.setPropertyId(property.getPropertyId());
                pr.setPropertyName(property.getPropertyName());
                
                PropertyTypePojo pt = new PropertyTypePojo();
                pt.setTypeId(property.getPropertyTypeId().getTypeId());
                pt.setTypeName(property.getPropertyTypeId().getTypeName());
                
                PropertyUnitPojo pu = new PropertyUnitPojo();
                pu.setUnitId(property.getPropertyUnitId().getUnitId());
                pu.setUnitName(property.getPropertyUnitId().getUnitName());
                                
                pr.setPropertyTypeId(pt);
                pr.setPropertyUnitId(pu);
                p.getPropertyList().add(pr);
            }            
            returnList.add(p);
        }
        return returnList;
    }

    @Override
    public List<PropertyPojo> getAllPropertiesOrderByName() {
        TypedQuery<Property> query = em.createNamedQuery("Product.findAllOrderByName", Property.class);
        List<Property> propertyList=query.getResultList();
        
        List<PropertyPojo> returnList = new ArrayList<>();
        
        for (Property property : propertyList) {
            PropertyPojo pr = new PropertyPojo();
                pr.setPropertyId(property.getPropertyId());
                pr.setPropertyName(property.getPropertyName());
                
                PropertyTypePojo pt = new PropertyTypePojo();
                pt.setTypeId(property.getPropertyTypeId().getTypeId());
                pt.setTypeName(property.getPropertyTypeId().getTypeName());
                
                PropertyUnitPojo pu = new PropertyUnitPojo();
                pu.setUnitId(property.getPropertyUnitId().getUnitId());
                pu.setUnitName(property.getPropertyUnitId().getUnitName());
                                
                pr.setPropertyTypeId(pt);
                pr.setPropertyUnitId(pu);
                returnList.add(pr);
        }
        return returnList;
    }
     
}
