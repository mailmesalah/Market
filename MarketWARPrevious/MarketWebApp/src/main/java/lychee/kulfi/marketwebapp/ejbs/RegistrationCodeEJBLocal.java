/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lychee.kulfi.marketwebapp.ejbs;

import java.util.List;
import javax.ejb.Local;
import lychee.kulfi.marketwebapp.entitybeans.Registrationcodes;

/**
 *
 * @author Sely
 */
@Local
public interface RegistrationCodeEJBLocal {
    public List<Registrationcodes> getAllRegistrationCodes();
    public void addRegistrationCode(String code);
    public void removeRegistrationCode(int id);
    public List<Registrationcodes> searchCode(String code);
}
