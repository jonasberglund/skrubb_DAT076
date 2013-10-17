/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.AbstractPost;
import com.skrubb.blog_back_end.core.Author;
import com.skrubb.blog_back_end.core.Comment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;

/**
 *
 * @author Anders
 */
public abstract class ConversationalPost extends ConversationalBase implements Serializable{
    
    private Long id;
    
    private Author author;
    private Date date;
    private String title;
    private String value;
    private Map<Long,String> comments;
    private Integer numberOfcomments = 10;
    private String[] commenter;
    
    
    public ConversationalPost(){
        comments = new TreeMap<Long, String>();
 
        commenter = new String[10];
    
    }
    
    public void setSelected(Long id) {
        Logger.getAnonymousLogger().log(Level.INFO, "setSelected id={0}", id);
        if (conversation.isTransient()) {
            conversation.begin();
        }
        
        this.id=id;
        
    }

    @PreDestroy  // Must have for back button etc.
    public void destroy() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }

    public String actOnSelected() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
        execute();
        return "welcome";
    }


     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setTitle(String title)
    {
        this.title=title;
    }
    public String getTitle(){
        return title;
    }        
    public void setValue(String value)
    {
        this.value=value;
    }
    public String getValue(){
        return value;
    }
    
    public void setAuthor(Author author){
        this.author = author;
    }
    
    public Author getAuthor(){
        return author;
    }
    
     public void setComment(Map<Long, String> comments){
        this.comments = comments;
    }
    
    public Map<Long, String> getComment(){
            return comments;
    }
    
     public void setCommenter(String[] commenter){
        this.commenter = commenter;
    }
    
    public String[] getCommenter(){
            return commenter;
    }
    
    public AbstractPost showSinglePost(Long id){
        return blog.getPostArchive().find(id);
    }

}