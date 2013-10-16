/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author robin
 */
@Entity
@Table(name="TAGS")
public class Tag implements Serializable {  

    @Id
    @Column(name = "TAG_VALUE")
    private String value;
    
    public Tag (String value) {
        this.value = formTag(value);
    }
    
    protected Tag() {
        
    }
    
    public String getId() {
        return getValue();
    }
    
    public String getValue() {
        return value;
    }
    
    private String formTag(String unformedTag) {
        return unformedTag.toUpperCase().trim();
    }
}