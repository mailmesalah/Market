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
public class ProductPojo {
    private Integer productId; 
    private String productName;    

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<PropertyPojo> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<PropertyPojo> propertyList) {
        this.propertyList = propertyList;
    }
    private List<PropertyPojo> propertyList= new ArrayList<>();
}
