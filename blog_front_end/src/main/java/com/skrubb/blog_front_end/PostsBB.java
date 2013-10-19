/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.AbstractPost;
import com.skrubb.blog_back_end.core.Author;
import com.skrubb.blog_back_end.core.Tag;
import com.skrubb.blog_front_end.utils.ContainerNavigator;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jonasberglund
 */
@Named("posts")
@SessionScoped
public class PostsBB implements Serializable {
    private Blog blog;
    private ContainerNavigator cn;
    
    @Inject
    public void Blog(Blog blog)
    {
        this.blog=blog;
    }
    
    @PostConstruct
    public void post() {
        cn = new ContainerNavigator(0, 5, blog.getPostArchive());
    }
    
    public List<AbstractPost> getRange(){
        return cn.getRange();    
    }
    
    public void next() {
        cn.next();
    }
    
    public void prev() {
        cn.previous();
    }
    
    public void deletePost(Long id){
        blog.getPostArchive().remove(id);
    }
    
    public AbstractPost showSinglePost(Long id){
        return blog.getPostArchive().find(id);
    }
        
    public List<AbstractPost> getPostsWithTag(Tag tag){
        return blog.getPostArchive().getByTag(tag);
    }
    
    public List<AbstractPost> getPostsFromAuthor(Author author){
        return blog.getPostArchive().getByAuthor(author);
    }
    public List<AbstractPost> getByTag(String tag){
    
        return blog.getPostArchive().getByTag(blog.getPostArchive().findTag(tag));
    }
    
}
