/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.AbstractPost;
import com.skrubb.blog_back_end.core.Author;
import com.skrubb.blog_back_end.core.Tag;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jonasberglund
 */
@Named("posts")
@RequestScoped
public class PostsBB {
    private Blog blog;
    
    @Inject
    public void Blog(Blog blog)
    {
        this.blog=blog;
    }
    
    public List<AbstractPost> getRange(){
        return blog.getPostArchive().getRange(0, blog.getPostArchive().size());
        
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
