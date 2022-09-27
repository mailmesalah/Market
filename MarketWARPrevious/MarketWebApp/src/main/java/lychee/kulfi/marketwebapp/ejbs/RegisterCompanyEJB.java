/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lychee.kulfi.marketwebapp.ejbs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import lychee.kulfi.marketwebapp.entitybeans.Companies;
import lychee.kulfi.marketwebapp.entitybeans.Profiles;
import lychee.kulfi.marketwebapp.entitybeans.Useraccounts;
import lychee.kulfi.marketwebapp.pojos.RegisterPojo;

/**
 *
 * @author Sely
 */
@Stateless
public class RegisterCompanyEJB implements RegisterCompanyEJBLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @PersistenceContext(name = "Storage")
    EntityManager em;
    
    @Override
    public void registerNewCompany(RegisterPojo rp) {
        Companies company = new Companies();
        Profiles manager = new Profiles();
        Useraccounts user = new Useraccounts();
        
        company.setCompanyName(rp.companyName);
        company.setAbout(rp.about);
        company.setAddress(rp.companyAddress);
        company.setCountry(rp.country);
        company.setPhone(rp.companyPhone);
        company.setPinCode(rp.pinNo);
        company.setStatus("new");
        
        manager.setProfileName(rp.profileName);
        manager.setAddress(rp.profileAddress);
        manager.setPhone(rp.profilePhone);        
        
        user.setUsername(rp.username);
        user.setPassword(rp.password);
        user.setUserRole("manager");
        
        company.setManagerProfileId(manager);
        manager.setCompanyId(company);
        
        company.getProfilesList().add(manager);
        manager.setCompanyId(company);
        
        user.setProfileId(manager);
        manager.setUseraccounts(user);
        
        em.persist(company);
        em.persist(manager);
        em.persist(user);                
    }

    @Override
    public boolean isCompanyExist(String company) {
        TypedQuery<Companies> query= em.createNamedQuery("Companies.findByCompanyName", Companies.class);
        query.setParameter("companyName",company);
        return !query.getResultList().isEmpty();          
    }

    @Override
    public boolean isUserExist(String user) {
        TypedQuery<Useraccounts> query= em.createNamedQuery("Useraccounts.findByUsername", Useraccounts.class);
        query.setParameter("username",user);
        return !query.getResultList().isEmpty();
    }
    
        
}
