/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lychee.kulfi.marketwebapp.entitybeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "useraccounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Useraccounts.findAll", query = "SELECT u FROM Useraccounts u"),
    @NamedQuery(name = "Useraccounts.findByUserId", query = "SELECT u FROM Useraccounts u WHERE u.userId = :userId"),
    @NamedQuery(name = "Useraccounts.findByUsername", query = "SELECT u FROM Useraccounts u WHERE u.username = :username"),
    @NamedQuery(name = "Useraccounts.findByPassword", query = "SELECT u FROM Useraccounts u WHERE u.password = :password"),
    @NamedQuery(name = "Useraccounts.findByUserRole", query = "SELECT u FROM Useraccounts u WHERE u.userRole = :userRole")})
public class Useraccounts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserId")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "UserRole")
    private String userRole;
    @JoinColumn(name = "ProfileId", referencedColumnName = "ProfileId")
    @OneToOne
    private Profiles profileId;

    public Useraccounts() {
    }

    public Useraccounts(Integer userId) {
        this.userId = userId;
    }

    public Useraccounts(Integer userId, String username, String password, String userRole) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Profiles getProfileId() {
        return profileId;
    }

    public void setProfileId(Profiles profileId) {
        this.profileId = profileId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Useraccounts)) {
            return false;
        }
        Useraccounts other = (Useraccounts) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lychee.kulfi.marketwebapp.entitybeans.Useraccounts[ userId=" + userId + " ]";
    }
    
}
