/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.Author;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.inject.Inject;
import javax.inject.Named;
 
 
/**
 * Simple login bean.
 *
 * @author itcuties
 */
@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    
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
            return navigationBean.toWelcome();
        }
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Wrong password or username!"));
        return navigationBean.toLogin(); 
    }
     
    /**
     * Logout operation.
     * @return
     */
    public String doLogout() {
        // Set the paremeter indicating that user is logged in to false
        loggedIn = false;
        author=null;
         
         
        return navigationBean.toWelcome();
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