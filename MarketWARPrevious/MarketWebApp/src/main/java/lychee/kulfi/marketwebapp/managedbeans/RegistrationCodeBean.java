/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lychee.kulfi.marketwebapp.managedbeans;

import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import lychee.kulfi.marketwebapp.ejbs.RegistrationCodeEJBLocal;
import lychee.kulfi.marketwebapp.entitybeans.Registrationcodes;

/**
 *
 * @author Sely
 */
@ManagedBean
@RequestScoped
public class RegistrationCodeBean {

    /**
     * Creates a new instance of RegistrationCodeBean
     */
    @EJB
    private RegistrationCodeEJBLocal rcl;

    public RegistrationCodeBean() {
    }

    public List<Registrationcodes> getRegistrationCodes() {
        return rcl.getAllRegistrationCodes();
    }

    public void generateNewCode() {
        Random rn = new Random();        
        rcl.addRegistrationCode((rn.nextInt(10000)+1000)+"");
    }

    public void removeCode(int id) {
        rcl.removeRegistrationCode(id);
    }
}
