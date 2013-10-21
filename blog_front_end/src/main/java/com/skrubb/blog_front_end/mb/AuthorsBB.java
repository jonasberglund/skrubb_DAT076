/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end.mb;

import com.skrubb.blog_back_end.core.Author;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Resbonsible for accessing all authors
 * @author Anders Johansson, Jonas Berglund
 */
@Named("authors")
@RequestScoped
public class AuthorsBB implements Serializable {
    private static final long serialVersionUID = 15556297720999998L;
    
    @Inject
    private Blog blog;
    
    public List<Author> getRange(){
        if (blog != null) {
            return blog.getAuthorRegistry().getRange(0, blog.getAuthorRegistry().size());
        }
        return new ArrayList<Author>();
    }
}
