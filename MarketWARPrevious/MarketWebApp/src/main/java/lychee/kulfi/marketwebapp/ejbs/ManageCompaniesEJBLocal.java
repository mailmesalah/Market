/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lychee.kulfi.marketwebapp.ejbs;

import java.util.List;
import javax.ejb.Local;
import lychee.kulfi.marketwebapp.entitybeans.Companies;

/**
 *
 * @author Sely
 */
@Local
public interface ManageCompaniesEJBLocal {
    public List<Companies> getAllUnregisteredCompanies();
    public List<Companies> getAllActiveCompanies();
    public List<Companies> getAllDeactiveCompanies();
    public void activateCompany(int companyId);
    public void deactivateCompany(int companyId);
    public void removeCompany(int companyId);
    public Companies findCompany(int companyId);
 
}
