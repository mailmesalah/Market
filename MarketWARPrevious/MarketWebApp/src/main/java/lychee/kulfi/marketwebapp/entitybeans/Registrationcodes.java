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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sely
 */
@Entity
@Table(name = "registrationcodes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registrationcodes.findAll", query = "SELECT r FROM Registrationcodes r"),
    @NamedQuery(name = "Registrationcodes.findByRegistrationCodeId", query = "SELECT r FROM Registrationcodes r WHERE r.registrationCodeId = :registrationCodeId"),
    @NamedQuery(name = "Registrationcodes.findByRegistrationCode", query = "SELECT r FROM Registrationcodes r WHERE r.registrationCode = :registrationCode")})
public class Registrationcodes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RegistrationCodeId")
    private Integer registrationCodeId;   
    @Size(min = 1, max = 45)
    @Column(name = "RegistrationCode")
    private String registrationCode;

    public Registrationcodes() {
    }

    public Registrationcodes(Integer registrationCodeId) {
        this.registrationCodeId = registrationCodeId;
    }

    public Registrationcodes(Integer registrationCodeId, String registrationCode) {
        this.registrationCodeId = registrationCodeId;
        this.registrationCode = registrationCode;
    }

    public Integer getRegistrationCodeId() {
        return registrationCodeId;
    }

    public void setRegistrationCodeId(Integer registrationCodeId) {
        this.registrationCodeId = registrationCodeId;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registrationCodeId != null ? registrationCodeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registrationcodes)) {
            return false;
        }
        Registrationcodes other = (Registrationcodes) object;
        if ((this.registrationCodeId == null && other.registrationCodeId != null) || (this.registrationCodeId != null && !this.registrationCodeId.equals(other.registrationCodeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lychee.kulfi.marketwebapp.entitybeans.Registrationcodes[ registrationCodeId=" + registrationCodeId + " ]";
    }
    
}
