/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lychee.kulfi.marketwebapp.managedbeans;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lychee.kulfi.marketwebapp.ejbs.RegisterCompanyEJBLocal;
import lychee.kulfi.marketwebapp.ejbs.RegistrationCodeEJBLocal;
import lychee.kulfi.marketwebapp.entitybeans.Registrationcodes;
import lychee.kulfi.marketwebapp.pojos.RegisterPojo;

/**
 *
 * @author Sely
 */
@ManagedBean
@SessionScoped
public class RegisterBean {

    @EJB
    RegistrationCodeEJBLocal rcl;
    
    @EJB
    RegisterCompanyEJBLocal regCompany;
    
    private String regCode;
    private boolean applied = false;
    private String successMessage;
    private String companyName;
    private String about;
    private String companyAddress;
    private String companyPhone;
    private String country;
    private String pinNo;
    private String username;
    private String password;
    private String confirmPassword;
    private String profileName;
    private String profileAddress;
    private String profilePhone;

    /**
     * Creates a new instance of RegisterBean
     */
    public RegisterBean() {
    }

    public boolean isApplied() {
        return applied;
    }

    public void setApplied(boolean applied) {
        this.applied = applied;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPinNo() {
        return pinNo;
    }

    public void setPinNo(String pinNo) {
        this.pinNo = pinNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileAddress() {
        return profileAddress;
    }

    public void setProfileAddress(String profileAddress) {
        this.profileAddress = profileAddress;
    }

    public String getProfilePhone() {
        return profilePhone;
    }

    public void setProfilePhone(String profilePhone) {
        this.profilePhone = profilePhone;
    }

    public String getRegCode() {
        return regCode;
    }

    public void setRegCode(String regCode) {
        this.regCode = regCode;
    }

    public void applyForRegistration() {
        if (password.equals(confirmPassword) && !companyName.trim().equals("") && !companyPhone.trim().equals("") && !username.trim().equals("") && !password.trim().equals("") && !profileName.trim().equals("") && !profilePhone.trim().equals("") && !regCode.trim().equals("")) {
            
            List<Registrationcodes> codeList = rcl.searchCode(regCode);
            if (!codeList.isEmpty() && !regCompany.isCompanyExist(companyName) && !regCompany.isUserExist(username)) {
                                
                RegisterPojo rp = new RegisterPojo();
                rp.companyName=companyName;
                rp.about=about;
                rp.companyAddress=companyAddress;
                rp.companyPhone=companyPhone;
                rp.country=country;
                rp.pinNo=pinNo;
                rp.username=username;
                rp.password=password;
                rp.profileName=profileName;
                rp.profileAddress=profileAddress;
                rp.profilePhone=profilePhone;
                
                regCompany.registerNewCompany(rp);
                
                successMessage="Successfully applied for registration. You will be informed about the confirmation.";
                applied = true;
                
                rcl.removeRegistrationCode(codeList.get(0).getRegistrationCodeId());
            }           
        }
    }

    public String showRegisterForm() {
        List<Registrationcodes> codeList = rcl.searchCode(regCode);
        
        if(!codeList.isEmpty()){
            return "register";
        }        
        return null;
    }
}
