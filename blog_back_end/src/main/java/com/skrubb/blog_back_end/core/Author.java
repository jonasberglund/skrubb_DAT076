/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import com.skrubb.blog_back_end.utils.AbstractEntity;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public Author(String name, String password, AccessLevel accessLevel){
        this.name = name;
        this.hashedPassword = generateHashedPassword(password);
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
    
    public static String generateHashedPassword(String password) {
        
        String salt = "Skrubb159Salt+=@$skrubb";
        
        return md5(password + salt);
    }
    
    private static String md5(String s) {
        
        String md5 = null;
        
        if (s == null) {
            return null;
        }
        
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            digest.update(s.getBytes(), 0, s.length());
            md5 = new BigInteger(1, digest.digest()).toString(16);
            
        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Hashing password failed");
        }
        
        return md5;
    }
    
    public enum AccessLevel {  
        ADMIN,
        AUTHOR
    }
    
}
