/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entityclass for storing text post in database
 * @author robin
 * @author ollesvensson
 */

@Entity
@Table(name = "TEXT_POST")
public class TextPost extends AbstractPost {
    private static final long serialVersionUID = 100560000028890438L;
    
    @Column(name = "TEXT")
    private String text;
    
    protected TextPost() {
        
    }
    
    public TextPost(Author author, String title, String text){
        super(author, title);
        this.text = text;
    }
    
    /**
     * Used when you want to edit a post
     * @param textPost The TextPost object you want to change
     * @param text The new text.
     */
    public TextPost(TextPost textPost, String text){
        super(textPost);
        this.text = text;
    }
    
    public String getText() {
        return text;
    }

    @Override
    public String getData() {
        return text;
    }
}
