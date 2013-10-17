/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.Author;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;
 
 
/**
 * Simple login bean.
 *
 * @author itcuties
 */
@SessionScoped
public class LoginBean implements Serializable {
 
    private static final long serialVersionUID = 7765876811740798583L;
 
    // Simple user database :)
    //private static final String[] users = {"jonas:qwe","anders:123"};
    
    private Blog blog;
    private Author author;
    
    private String username;
    private String password;
     
    private boolean loggedIn;
 
    @Inject
    private NavigationBean navigationBean;
    
    @Inject
    private void Blog(Blog blog)
    {
        this.blog=blog;
    }
     
    /**
     * Login operation.
     * @return
     */
    public String doLogin() {
          
        author = blog.getAuthorRegistry().getAuthorByLogin(username, Author.generateHashedPassword(password));
        
        if (author != null) {
                loggedIn = true;
                return navigationBean.redirectToWelcome();
            }
        
        // Set login ERROR
        //FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
        //msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        //FacesContext.getCurrentInstance().addMessage(null, msg);

        return navigationBean.toLogin();
        
        /*
        // Get every user from our sample database :)
        for (String user: users) {
            String dbUsername = user.split(":")[0];
            String dbPassword = user.split(":")[1];
             
            // Successful login
            if (dbUsername.equals(username) && dbPassword.equals(password)) {
                loggedIn = true;
                return navigationBean.redirectToWelcome();
            }
        }
         
        // Set login ERROR
        FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
         
        // To to login page
        return navigationBean.toLogin();*/
         
    }
     
    /**
     * Logout operation.
     * @return
     */
    public String doLogout() {
        // Set the paremeter indicating that user is logged in to false
        loggedIn = false;
         
        // Set logout message
        //FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
        //msg.setSeverity(FacesMessage.SEVERITY_INFO);
        //FacesContext.getCurrentInstance().addMessage(null, msg);
         
        return navigationBean.redirectToWelcome();
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
    
    public Author getAuthor(){
        return author;
    }
     
}