/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import java.util.Date;

/**
 *
 * @author Anders
 */
public class DummyComment {

    private String commenter;
    private String text;
    
    protected DummyComment(){
        
    }
    
    public DummyComment(String commenter, String text){
        this.commenter = commenter;
        this.text = text;
    }
    
    public String getText(){
        return text;
    }
    
    public String getCommenter(){
        return commenter;
    }
    
}
