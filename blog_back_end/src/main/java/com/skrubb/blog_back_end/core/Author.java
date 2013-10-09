/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import com.skrubb.blog_back_end.utils.AbstractEntity;
import java.io.Serializable;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author ollesvensson
 * @author robintornquist
 */
@Entity
@Table(name = "AUTHOR")
public class Author extends AbstractEntity implements Serializable {
    
    @Column(name = "NAME")
    private String name;
    @Column(name = "PASSWORD")
    private String hashedPassword;
    @Column(name = "ACCESS")
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
