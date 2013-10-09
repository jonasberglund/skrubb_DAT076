/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.utils;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author ollesvensson
 * @author robintornquist
 */
@MappedSuperclass
public abstract class AbstractEntity {
    
    //Initialized by database
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    
    protected AbstractEntity(){
    }
    
    
    protected AbstractEntity(Long id){
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
        
        if (obj instanceof AbstractEntity && this.id.equals(((AbstractEntity)obj).id)){
            return true;
        }
        
        return false;
    }
}
