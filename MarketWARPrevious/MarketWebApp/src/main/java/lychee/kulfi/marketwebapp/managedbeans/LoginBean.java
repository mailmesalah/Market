/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lychee.kulfi.marketwebapp.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Sely 
 */
@ManagedBean
@SessionScoped
public class LoginBean {

    String username;
    String password;
    int noOfTimes;
    String errorMessage;
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public String login(){
        if(noOfTimes>5){
            noOfTimes++;
            errorMessage="Your Maximum number of attempts has been exceeded, Please try again after 15 mintes. !!!";
            return "";
        }else if("admin".equals(username) && "admin".equals(password)){
            noOfTimes=0;
            errorMessage="";
            return "admin";
        }else if("manager".equals(username) && "manager".equals(password)){
            noOfTimes=0;
            errorMessage="";
            return "manager";
        }else if("staff".equals(username) && "staff".equals(password)){
            noOfTimes=0;
            errorMessage="";
            return "staff";
        }else{   
            noOfTimes++;
            errorMessage="Username Or Password is Wrong !!!";
            return "";
        }
    }
}
