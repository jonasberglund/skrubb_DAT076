/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author Anders
 */
public class DummyPost {
 
    private Date date;
    private String title;
    //private CommentArchive commentArchive;
    //private Set<Tag> tags;
    
    public DummyPost(Date date, String title) {
        //this.author = author;
        this.date = date;
        this.title = title;
        //this.commentArchive = new CommentArchive();
        //this.tags = tags;
    }
       
       
    protected DummyPost() {    
    }
    
   
    
    public Date getDate() {
        return date;
    }
    
    public String getTitle() {
        return title;
    }
    
    
   
}
