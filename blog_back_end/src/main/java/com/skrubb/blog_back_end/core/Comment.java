/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import com.skrubb.blog_back_end.utils.AbstractEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;

/**
 *
 * @author ollesvensson
 * @author robintornquist
 */
@Entity
public class Comment extends AbstractEntity implements Serializable{
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date = new Date();
    
    @Column(name = "COMMENTER")
    private String commenter;
    
    @Column(name = "COMMENT")
    private String text;
    
    protected Comment(){
        
    }
    
    public Comment(String commenter, String text){
        this.commenter = commenter;
        this.text = text;
    }
    
    public String getText(){
        return text;
    }
    
    public String getCommenter(){
        return commenter;
    }
    
    public Date getDate(){
        return date;
    }
    
}
