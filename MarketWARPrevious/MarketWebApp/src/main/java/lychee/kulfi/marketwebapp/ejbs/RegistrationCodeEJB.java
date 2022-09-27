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
import lychee.kulfi.marketwebapp.entitybeans.Registrationcodes;

/**
 *
 * @author Sely
 */
@Stateless
public class RegistrationCodeEJB implements RegistrationCodeEJBLocal {

    @PersistenceContext(name = "Storage")
    EntityManager em;

    @Override
    public List<Registrationcodes> getAllRegistrationCodes() {
        TypedQuery<Registrationcodes> query = em.createNamedQuery("Registrationcodes.findAll", Registrationcodes.class);
        return query.getResultList();
    }

    @Override
    public void addRegistrationCode(String code) {
        if(code!=null){
            Registrationcodes rc = new Registrationcodes();
            rc.setRegistrationCode(code);
            em.persist(rc);
        }
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void removeRegistrationCode(int id) {
        Registrationcodes rc=em.find(Registrationcodes.class, id);
        if(rc!=null){
            em.remove(rc);
        }
    }

    @Override
    public List<Registrationcodes> searchCode(String code) {
        TypedQuery<Registrationcodes> query = em.createNamedQuery("Registrationcodes.findByRegistrationCode", Registrationcodes.class);
        query.setParameter("registrationCode",code);
        return query.getResultList();        
    }
}
