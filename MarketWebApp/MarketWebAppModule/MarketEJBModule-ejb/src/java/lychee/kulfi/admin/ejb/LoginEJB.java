/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lychee.kulfi.admin.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import lychee.kulfi.entities.UserAccount;

/**
 *
 * @author Sely
 */
@Stateless
public class LoginEJB implements LoginEJBRemote {
    @PersistenceContext(unitName = "StorageUnit")
    private EntityManager em;

    @Override
    public boolean loginAsAdmin(String username, String password) {
        TypedQuery<UserAccount> query= em.createNamedQuery("UserAccount.findByUsernameAndPasswordOfAdmin", UserAccount.class);
        query.setParameter("username",username.trim());
        query.setParameter("password",password.trim());
        query.setParameter("userRole","admin");

        return !query.getResultList().isEmpty(); 
    }   

}
