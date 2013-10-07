package com.skrubb.blog_front_end;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonasberglund
 */

@ManagedBean
@SessionScoped 
public class PasswordBean implements Serializable {  
  
    private static final long serialVersionUID = 8728917348917382189L;
    
    private static final String[] users = {"jonas:qwerty","anders:123456"};
            
    
    private String username;
    private String password; 
    
    private boolean loggedIn;
    
     @ManagedProperty(value="#{navigationBean}")
    private NavigationBean navigationBean;
    
     /**
     * Login operation.
     * @return
     */
    public String doLogin() {
        // Get every user from our sample database :)
        for (String user: users) {
            String dbUsername = user.split(":")[0];
            String dbPassword = user.split(":")[1];
             
            // Successful login
            if (dbUsername.equals(username) && dbPassword.equals(password)) {
                loggedIn = true;
                return navigationBean.redirectToIndex();
            }
        }
         
        // Set login ERROR
        FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
         
        // To to login page
        return navigationBean.toLogin();
         
    }
     
    /**
     * Logout operation.
     * @return
     */
    public String doLogout() {
        // Set the paremeter indicating that user is logged in to false
        loggedIn = false;
         
        // Set logout message
        FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
         
        return navigationBean.toLogin();
    }
 
    // ------------------------------
    // Getters & Setters
     
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
 
    public boolean isLoggedIn() {
        return loggedIn;
    }
 
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
 
    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }
     
}