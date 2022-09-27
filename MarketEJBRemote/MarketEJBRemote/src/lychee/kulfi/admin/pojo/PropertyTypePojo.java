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
public class PropertyTypePojo {

    private Integer typeId;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<PropertyPojo> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<PropertyPojo> propertyList) {
        this.propertyList = propertyList;
    }
    private String typeName;
    private List<PropertyPojo> propertyList= new ArrayList<>();
}
