/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import com.skrubb.blog_back_end.utils.AbstractEntity;
import java.util.Date;

/**
 *
 * @author ollesvensson
 * @author robintornquist
 */
public class Comment extends AbstractEntity{
    
    private Date date;
    private String commenter;
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
