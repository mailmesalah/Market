/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lychee.kulfi.admin.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sely
 */
public class PropertyPojo {
    private Integer propertyId;    

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public List<ProductPojo> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductPojo> productList) {
        this.productList = productList;
    }

    public PropertyUnitPojo getPropertyUnitId() {
        return propertyUnitId;
    }

    public void setPropertyUnitId(PropertyUnitPojo propertyUnitId) {
        this.propertyUnitId = propertyUnitId;
    }

    public PropertyTypePojo getPropertyTypeId() {
        return propertyTypeId;
    }

    public void setPropertyTypeId(PropertyTypePojo propertyTypeId) {
        this.propertyTypeId = propertyTypeId;
    }
    private String propertyName;   
    private List<ProductPojo> productList= new ArrayList<>();  
    private PropertyUnitPojo propertyUnitId;   
    private PropertyTypePojo propertyTypeId;
}
