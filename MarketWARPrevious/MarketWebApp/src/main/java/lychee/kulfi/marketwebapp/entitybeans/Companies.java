/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lychee.kulfi.marketwebapp.entitybeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "companies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Companies.findAll", query = "SELECT c FROM Companies c"),
    @NamedQuery(name = "Companies.findByCompanyId", query = "SELECT c FROM Companies c WHERE c.companyId = :companyId"),
    @NamedQuery(name = "Companies.findByCompanyName", query = "SELECT c FROM Companies c WHERE c.companyName = :companyName"),
    @NamedQuery(name = "Companies.findByPinCode", query = "SELECT c FROM Companies c WHERE c.pinCode = :pinCode"),
    @NamedQuery(name = "Companies.findByPhone", query = "SELECT c FROM Companies c WHERE c.phone = :phone"),
    @NamedQuery(name = "Companies.findByCountry", query = "SELECT c FROM Companies c WHERE c.country = :country"),
    @NamedQuery(name = "Companies.findByStatus", query = "SELECT c FROM Companies c WHERE c.status = :status")})
public class Companies implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CompanyId")
    private Integer companyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CompanyName")
    private String companyName;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "About")
    private String about;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Address")
    private String address;
    @Size(max = 10)
    @Column(name = "PinCode")
    private String pinCode;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "Phone")
    private String phone;
    @Size(max = 100)
    @Column(name = "Country")
    private String country;
    @Size(max = 10)
    @Column(name = "Status")
    private String status;
    @JoinColumn(name = "ManagerProfileId", referencedColumnName = "ProfileId")
    @OneToOne
    private Profiles managerProfileId;
    @OneToMany(mappedBy = "companyId",cascade= CascadeType.ALL)
    private List<Profiles> profilesList = new ArrayList<Profiles>();

    public Companies() {
    }

    public Companies(Integer companyId) {
        this.companyId = companyId;
    }

    public Companies(Integer companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Profiles getManagerProfileId() {
        return managerProfileId;
    }

    public void setManagerProfileId(Profiles managerProfileId) {
        this.managerProfileId = managerProfileId;
    }

    @XmlTransient
    public List<Profiles> getProfilesList() {
        return profilesList;
    }

    public void setProfilesList(List<Profiles> profilesList) {
        this.profilesList = profilesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyId != null ? companyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Companies)) {
            return false;
        }
        Companies other = (Companies) object;
        if ((this.companyId == null && other.companyId != null) || (this.companyId != null && !this.companyId.equals(other.companyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lychee.kulfi.marketwebapp.entitybeans.Companies[ companyId=" + companyId + " ]";
    }
    
}
