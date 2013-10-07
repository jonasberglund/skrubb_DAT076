/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author robin
 * @author ollesvensson
 */
public class TextPost extends Post {
    private String text;
    
    public TextPost(Author author, Date date, String title, Set<Tag> tags, String text){
        super(author, date, title, tags);
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
}
