/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lychee.kulfi.marketwebapp.managedbeans;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import lychee.kulfi.marketwebapp.ejbs.ManageCompaniesEJBLocal;
import lychee.kulfi.marketwebapp.entitybeans.Companies;

/**
 *
 * @author Sely
 */
@ManagedBean
@SessionScoped
public class ManageCompaniesBean {

    /**
     * Creates a new instance of ManageCompaniesBean
     */
    
    @EJB
    ManageCompaniesEJBLocal mcel;
    
    int companyId;
    String companyName;
    String companyAbout;
    String companyAddress;
    String companyCountry;
    String companyPhone;
    String companyPin;
    String companyStatus;
    
    
    public ManageCompaniesBean() {
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAbout() {
        return companyAbout;
    }

    public void setCompanyAbout(String companyAbout) {
        this.companyAbout = companyAbout;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyCountry() {
        return companyCountry;
    }

    public void setCompanyCountry(String companyCountry) {
        this.companyCountry = companyCountry;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyPin() {
        return companyPin;
    }

    public void setCompanyPin(String companyPin) {
        this.companyPin = companyPin;
    }
    
    public String showCompany(int companyId){
        this.companyId = companyId;
        
        Companies c = mcel.findCompany(companyId);
        companyName=c.getCompanyName();
        companyAbout=c.getAbout();
        companyAddress=c.getAddress();
        companyCountry=c.getCountry();
        companyPhone=c.getPhone();
        companyPin=c.getPinCode();
        companyStatus=c.getStatus();
        
        return "companyhome";
    }
    
    public List<Companies> getAllUnregisteredCompanies(){
        return mcel.getAllUnregisteredCompanies();
    }
    
    public List<Companies> getAllActiveCompanies(){
        return mcel.getAllActiveCompanies();
    }
    
    public List<Companies> getAllDeactiveCompanies(){
        return mcel.getAllDeactiveCompanies();
    }
    
    public void activateCompany(int id){
        mcel.activateCompany(id);
    }
    
    public void deactivateCompany(int id){
        mcel.deactivateCompany(id);
    }
    
    public void removeCompany(int id){
        mcel.removeCompany(id);
    }
    
    
    
}
