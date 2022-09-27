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
public class PropertyUnitPojo {

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public List<PropertyPojo> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<PropertyPojo> propertyList) {
        this.propertyList = propertyList;
    }

    private Integer unitId;
    private String unitName;
    private List<PropertyPojo> propertyList = new ArrayList<>();
}
