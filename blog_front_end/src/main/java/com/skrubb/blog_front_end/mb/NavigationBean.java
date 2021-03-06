/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end.mb;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

 

 
/**
 * Simple navigation bean
 * @author ollesvensson, robintornquist
 *
 */
@Named("navigation")
@RequestScoped
public class NavigationBean implements Serializable {
 
    private static final long serialVersionUID = 1520318172495977648L;
 
    /**
     * Go to login page.
     * @return Login page name.
     */
    public String toLogin() {
        return "login";
    }
    /**
     * Go to login page.
     * @return Login page name.
     */
    public String toLoginRedirect() {
        return "login-redirect";
    }
    
    /**
     * Go to chat page.
     * @return Chat page name.
     */
    public String toChat() {
        return "chat";
    }
    
    /**
     * Go to index page.
     * @return Index page name.
     */
    public String toIndex() {
        return "index";
    }
    /**
     * Go to index page.
     * @return Index page name.
     */
    public String toIndexRedirect() {
        return "index-redirect";
    }
    
    /**
     * Go to welcome page.
     * @return Welcome page name.
     */
    public String toWelcome() {
        return "welcome";
    }
    /**
     * Go to tag page.
     * @return Tag page name.
     */
    public String toTag() {
        return "posts-by-tag";
    }
    
    /**
     * Go to text post page.
     * @return Text post page name.
     */
    public String toTextPost() {
        return "text-post";
    }
    
    /**
     * Go to text post page.
     * @return Text post page name.
     */
    public String toPhotoPost() {
        return "photo-post";
    }
    
    /**
     * Go to edit post page.
     * @return Edit post page name.
     */
    public String toEditPost() {
        return "edit-post";
    }
    
    /**
     * Go to authors page.
     * @return Authors page name.
     */
    public String toAuthors() {
        return "authors";
    }
    
    /**
     * Go to add author page.
     * @return Add author page name.
     */
    public String toAddAuthor() {
        return "add-author";
    }
    
    /**
     * Go to edit author page.
     * @return Edit author page name.
     */
    public String toEditAuthor() {
        return "edit-author";
    }
    
    /**
     * Go to edit author page.
     * @return Edit author page name.
     */
    public String toEditAuthorRedirect() {
        return "edit-author-redirect";
    }
    
    /**
     * Go to delete author page.
     * @return Delete author page name.
     */
    public String toDeleteAuthor() {
        return "delete-author";
    }
     
}