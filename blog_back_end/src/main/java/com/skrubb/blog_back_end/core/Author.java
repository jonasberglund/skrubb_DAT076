/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import com.skrubb.blog_back_end.utils.Entity;

/**
 *
 * @author ollesvensson
 * @author robintornquist
 */
public class Author extends Entity {
    
    private String name;
    private String hashedPassword;
    private AccessLevel accessLevel;
    
    protected Author(){
        
    }
    
    public Author(String name, String hashedPassword, AccessLevel accessLevel){
        this.name = name;
        this.hashedPassword = hashedPassword;
        this.accessLevel = accessLevel;
    }
    
    public Author(Long id, String name, String hashedPassword, AccessLevel accessLevel){
        super(id);
        
        this.name = name;
        this.hashedPassword = hashedPassword;
        this.accessLevel = accessLevel;
    }
    
    public String getName(){
        return name;
    }
    
    public String getHashedPassword(){
        return hashedPassword;
    }
    
    public AccessLevel getAccessLevel(){
        return accessLevel;
    }
    
    
    public enum AccessLevel {  
        ADMIN,
        AUTHOR
    }
    
}
