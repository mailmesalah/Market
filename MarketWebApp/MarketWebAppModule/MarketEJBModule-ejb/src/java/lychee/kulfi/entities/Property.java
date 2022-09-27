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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "property")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Property.findAll", query = "SELECT p FROM Property p"),
    @NamedQuery(name = "Property.findByPropertyId", query = "SELECT p FROM Property p WHERE p.propertyId = :propertyId"),
    @NamedQuery(name = "Property.findByPropertyName", query = "SELECT p FROM Property p WHERE p.propertyName = :propertyName")})
public class Property implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Property_Id")
    private Integer propertyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Property_Name")
    private String propertyName;
    @JoinTable(name = "product_property", joinColumns = {
        @JoinColumn(name = "Property_Id", referencedColumnName = "Property_Id")}, inverseJoinColumns = {
        @JoinColumn(name = "Product_Id", referencedColumnName = "Product_Id")})
    @ManyToMany
    private List<Product> productList= new ArrayList<>();
    @JoinColumn(name = "Property_Unit_Id", referencedColumnName = "Unit_Id")
    @ManyToOne
    private PropertyUnit propertyUnitId;
    @JoinColumn(name = "Property_Type_Id", referencedColumnName = "Type_Id")
    @ManyToOne
    private PropertyType propertyTypeId;

    public Property() {
    }

    public Property(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Property(Integer propertyId, String propertyName) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
    }

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

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public PropertyUnit getPropertyUnitId() {
        return propertyUnitId;
    }

    public void setPropertyUnitId(PropertyUnit propertyUnitId) {
        this.propertyUnitId = propertyUnitId;
    }

    public PropertyType getPropertyTypeId() {
        return propertyTypeId;
    }

    public void setPropertyTypeId(PropertyType propertyTypeId) {
        this.propertyTypeId = propertyTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propertyId != null ? propertyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Property)) {
            return false;
        }
        Property other = (Property) object;
        if ((this.propertyId == null && other.propertyId != null) || (this.propertyId != null && !this.propertyId.equals(other.propertyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lychee.kulfi.entities.Property[ propertyId=" + propertyId + " ]";
    }
    
}
