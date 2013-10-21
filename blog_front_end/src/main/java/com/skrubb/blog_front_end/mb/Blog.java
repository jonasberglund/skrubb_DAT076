/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end.mb;

import com.skrubb.blog_back_end.core.Author;
import com.skrubb.blog_back_end.core.BlogFactory;
import com.skrubb.blog_back_end.core.IAuthorRegistry;
import com.skrubb.blog_back_end.core.IPostArchive;
import java.io.Serializable;
import javax.inject.Singleton;

/**
 * Responsible for all connection to the back_end server
 * @author Anders Johansson, Jonas Berglund
 */
@Singleton
public class Blog implements Serializable{
    private static final long serialVersionUID = 10056297720136998L;
    
    private static String pu_name="blog";
    private final com.skrubb.blog_back_end.core.IBlog blog;
    
    public Blog(){ 
        blog= BlogFactory.getBlog(pu_name);
        
        if (blog.getAuthorRegistry().size() == 0) {
            createAdmin();
        }
    }
    
    public IPostArchive getPostArchive(){
        return blog.getPostArchive();
    }
    
    public IAuthorRegistry getAuthorRegistry(){
        return blog.getAuthorRegistry();
    }
    
    private void createAdmin(){
        Author admin = new Author("admin","password",Author.AccessLevel.ADMIN);
        getAuthorRegistry().add(admin);
    }
}