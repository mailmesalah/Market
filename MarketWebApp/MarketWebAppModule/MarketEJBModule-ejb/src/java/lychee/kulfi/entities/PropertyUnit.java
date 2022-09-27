/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lychee.kulfi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sely
 */
@Entity
@Table(name = "property_unit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PropertyUnit.findAll", query = "SELECT p FROM PropertyUnit p"),
    @NamedQuery(name = "PropertyUnit.findByUnitId", query = "SELECT p FROM PropertyUnit p WHERE p.unitId = :unitId"),
    @NamedQuery(name = "PropertyUnit.findByUnitName", query = "SELECT p FROM PropertyUnit p WHERE p.unitName = :unitName")})
public class PropertyUnit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Unit_Id")
    private Integer unitId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Unit_Name")
    private String unitName;
    @OneToMany(mappedBy = "propertyUnitId")
    private List<Property> propertyList = new ArrayList<>();

    public PropertyUnit() {
    }

    public PropertyUnit(Integer unitId) {
        this.unitId = unitId;
    }

    public PropertyUnit(Integer unitId, String unitName) {
        this.unitId = unitId;
        this.unitName = unitName;
    }

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

    @XmlTransient
    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unitId != null ? unitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PropertyUnit)) {
            return false;
        }
        PropertyUnit other = (PropertyUnit) object;
        if ((this.unitId == null && other.unitId != null) || (this.unitId != null && !this.unitId.equals(other.unitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lychee.kulfi.entities.PropertyUnit[ unitId=" + unitId + " ]";
    }
    
}
