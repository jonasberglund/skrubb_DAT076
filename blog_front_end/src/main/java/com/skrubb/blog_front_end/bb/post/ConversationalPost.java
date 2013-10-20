/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end.bb.post;

import com.skrubb.blog_front_end.bb.ConversationalBase;
import com.skrubb.blog_back_end.core.AbstractPost;
import com.skrubb.blog_back_end.core.Author;
import com.skrubb.blog_front_end.mb.LoginBean;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

/**
 *
 * @author Anders
 */
public abstract class ConversationalPost extends ConversationalBase implements Serializable{
    
    private Long id;
    
    private Author author;
    private String title;
    private String value;
    private String tags;
    private String commenter;
    
    @Inject
    protected LoginBean loginbean;
    
    public ConversationalPost(){
    
    }
    
    public void setSelected(Long id) {
        Logger.getAnonymousLogger().log(Level.INFO, "setSelected id={0}", id);
        if (conversation.isTransient()) {
            conversation.begin();
        }
        
        AbstractPost p = blog.getPostArchive().find(id);
        this.id=id;
        this.title = p.getTitle();
        this.value = p.getData();
        this.author = p.getAuthor();
        
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
        return navigationBean.toWelcome();
    }

    public AbstractPost showSinglePost(Long id){
        return blog.getPostArchive().find(id);
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
    
    public void setTags(String tags)
    {
        this.tags=tags;
    }
    
    public String getTags(){
        return tags;
    }
    
    public void setAuthor(Author author){
        this.author = author;
    }
    
    public Author getAuthor(){
        return author;
    }
    
    public void setCommenter(String commenter){
        this.commenter = commenter;
    }
    
    public String getCommenter(){
            return commenter;
    }
}
