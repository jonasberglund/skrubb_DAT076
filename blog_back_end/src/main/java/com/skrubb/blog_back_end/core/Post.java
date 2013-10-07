/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import com.skrubb.blog_back_end.utils.Entity;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author ollesvensson
 * @author robintornquist
 */
public abstract class Post extends Entity {
    
    private Author author; 
    private Date date;
    private String title;
    private CommentArchive commentArchive;
    private Set<Tag> tags;
    
    public Post(Author author, Date date, String title, Set<Tag> tags) {
        this.author = author;
        this.date = date;
        this.title = title;
        this.commentArchive = new CommentArchive();
        this.tags = tags;
    }
    
    public Post(Long id, Author author, Date date, String title, CommentArchive commentArchive) {
        super(id);
        this.author = author;
        this.date = date;
        this.title = title;
        this.commentArchive =  commentArchive;
    }
    
    public Post(Post p) {
        super(p.getId());
        this.author = p.getAuthor();
        this.date = p.getDate();
        this.title = p.getTitle();
        this.commentArchive =  p.getCommentArchive();
    }
    
    protected Post() {    
    }
    
    public Author getAuthor() {
        return author;
    }
    
    public Date getDate() {
        return date;
    }
    
    public String getTitle() {
        return title;
    }
    
    public CommentArchive getCommentArchive() {
        return commentArchive;
    }
    
    public Set<Tag> getTags() {
        return tags;
    }
    
}
