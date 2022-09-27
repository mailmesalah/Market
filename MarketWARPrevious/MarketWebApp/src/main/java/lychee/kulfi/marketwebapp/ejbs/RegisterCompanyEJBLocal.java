/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lychee.kulfi.marketwebapp.ejbs;

import javax.ejb.Local;
import lychee.kulfi.marketwebapp.pojos.RegisterPojo;

/**
 *
 * @author Sely
 */
@Local
public interface RegisterCompanyEJBLocal {
    public void registerNewCompany(RegisterPojo rp);
    public boolean isCompanyExist(String company);
    public boolean isUserExist(String user);        
}
