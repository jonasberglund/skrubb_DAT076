/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.utils;

import java.util.Objects;

/**
 *
 * @author ollesvensson
 * @author robintornquist
 */
public abstract class Entity {
    
    //Initialized by database
    private Long id;
    
    protected Entity(){
    }
    
    
    protected Entity(Long id){
        this.id = id;
    }
    
    public Long getId(){
        return id;
    }
    
    @Override
    public int hashCode(){
        int hash = 11;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj){
        
        if (obj == null){
            return false;
        }
        
        if (this == obj){
            return true;
        }
        
        if (obj instanceof Entity && this.id.equals(((Entity)obj).id)){
            return true;
        }
        
        return false;
    }
}
