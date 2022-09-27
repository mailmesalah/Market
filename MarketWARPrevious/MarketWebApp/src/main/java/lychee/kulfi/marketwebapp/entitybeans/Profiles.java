/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lychee.kulfi.marketwebapp.entitybeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sely
 */
@Entity
@Table(name = "profiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profiles.findAll", query = "SELECT p FROM Profiles p"),
    @NamedQuery(name = "Profiles.findByProfileId", query = "SELECT p FROM Profiles p WHERE p.profileId = :profileId"),
    @NamedQuery(name = "Profiles.findByProfileName", query = "SELECT p FROM Profiles p WHERE p.profileName = :profileName"),
    @NamedQuery(name = "Profiles.findByPhone", query = "SELECT p FROM Profiles p WHERE p.phone = :phone"),
    @NamedQuery(name = "Profiles.findByStatus", query = "SELECT p FROM Profiles p WHERE p.status = :status")})
public class Profiles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProfileId")
    private Integer profileId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ProfileName")
    private String profileName;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Address")
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "Phone")
    private String phone;
    @Size(max = 10)
    @Column(name = "Status")
    private String status;
    @OneToOne(mappedBy = "profileId",cascade= CascadeType.ALL)
    private Useraccounts useraccounts;
    @OneToOne(mappedBy = "managerProfileId")
    private Companies companies;
    @JoinColumn(name = "CompanyId", referencedColumnName = "CompanyId")
    @ManyToOne
    private Companies companyId;

    public Profiles() {
    }

    public Profiles(Integer profileId) {
        this.profileId = profileId;
    }

    public Profiles(Integer profileId, String profileName) {
        this.profileId = profileId;
        this.profileName = profileName;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Useraccounts getUseraccounts() {
        return useraccounts;
    }

    public void setUseraccounts(Useraccounts useraccounts) {
        this.useraccounts = useraccounts;
    }

    public Companies getCompanies() {
        return companies;
    }

    public void setCompanies(Companies companies) {
        this.companies = companies;
    }

    public Companies getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Companies companyId) {
        this.companyId = companyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profileId != null ? profileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profiles)) {
            return false;
        }
        Profiles other = (Profiles) object;
        if ((this.profileId == null && other.profileId != null) || (this.profileId != null && !this.profileId.equals(other.profileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lychee.kulfi.marketwebapp.entitybeans.Profiles[ profileId=" + profileId + " ]";
    }
    
}
