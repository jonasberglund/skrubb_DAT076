/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

/**
 *
 * @author robin
 */
public class Tag {
    private String value;
    
    public Tag (String value) {
        this.value = value;
    }
    
    protected Tag() {
        
    }
    
    public String getValue() {
        return value;
    }
}
