/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.Author;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Anders
 */
@Named("authors")
@SessionScoped
public class AuthorsBB implements Serializable {
    private Blog blog;
    
    @Inject
    public void Blog(Blog blog)
    {
        this.blog=blog;
    }
    
    public List<Author> getRange(){
        return blog.getAuthorRegistry().getRange(0, blog.getAuthorRegistry().size());
    }
}
