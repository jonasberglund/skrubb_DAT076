/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import com.skrubb.blog_back_end.utils.AbstractEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ollesvensson
 * @author robintornquist
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "POST_COMMON")
public abstract class AbstractPost extends AbstractEntity implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "AUTHOR")
    private Author author;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date = new Date();
    
    @Column(name = "TITLE")
    private String title;
    
    @ManyToMany
    @JoinColumn(name = "TAGS")
    private Set<Tag> tags;
    
    @OneToMany
    @JoinColumn(name = "COMMENTS")
    private List<Comment> comments;
    
    public AbstractPost(Author author, String title, Set<Tag> tags) {
        this.author = author;
        this.title = title;
        this.comments =  new ArrayList<Comment>();
        this.tags = tags;
    }

    public AbstractPost(Long id, Author author, String title, List<Comment> comments) {
        super(id);
        this.author = author;
        this.title = title;
        this.comments =  comments;
    }
    
    public AbstractPost(AbstractPost p) {
        super(p.getId());
        this.author = p.getAuthor();
        this.date = p.getDate();
        this.title = p.getTitle();
        this.comments = p.getComments();
    }
    
    protected AbstractPost() {    
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
    
    public Set<Tag> getTags() {
        return tags;
    }
    
    public List<Comment> getComments() {
        return comments;
    }
    
    public void addComment(Comment c) {
        comments.add(c);
    }
    
    public void addComment(String commenter, String text) {
        Comment c = new Comment(commenter, text);
        comments.add(c);
    }
    
}
