/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.AbstractPost;
import com.skrubb.blog_back_end.core.Author;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jonasberglund
 */
@Named("posts")
@SessionScoped
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
}
