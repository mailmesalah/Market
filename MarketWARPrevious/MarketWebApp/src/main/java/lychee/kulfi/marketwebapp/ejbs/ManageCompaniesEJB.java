/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lychee.kulfi.marketwebapp.ejbs;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import lychee.kulfi.marketwebapp.entitybeans.Companies;

/**
 *
 * @author Sely
 */
@Stateless
public class ManageCompaniesEJB implements ManageCompaniesEJBLocal {

    @PersistenceContext(name = "Storage")
    EntityManager em;
    
    @Override
    public List<Companies> getAllUnregisteredCompanies() {
        TypedQuery<Companies> query = em.createNamedQuery("Companies.findByStatus", Companies.class);
        query.setParameter("status", "new");
        return query.getResultList();
    }

    @Override
    public List<Companies> getAllActiveCompanies() {
        TypedQuery<Companies> query = em.createNamedQuery("Companies.findByStatus", Companies.class);
        query.setParameter("status", "active");
        return query.getResultList();
    }

    @Override
    public List<Companies> getAllDeactiveCompanies() {
        TypedQuery<Companies> query = em.createNamedQuery("Companies.findByStatus", Companies.class);
        query.setParameter("status", "deactive");
        return query.getResultList();
    }

    
    @Override
    public void activateCompany(int companyId) {
        Companies c = em.find(Companies.class, companyId);
        c.setStatus("active");
        em.persist(c);
        
    }

    @Override
    public void deactivateCompany(int companyId) {
        Companies c = em.find(Companies.class, companyId);
        c.setStatus("deactive");
        em.persist(c);
    }

    @Override
    public void removeCompany(int companyId) {
        Companies c = em.find(Companies.class, companyId);
        em.remove(c);
    }

    @Override
    public Companies findCompany(int companyId) {
        return em.find(Companies.class, companyId);
    }
    
    
}
