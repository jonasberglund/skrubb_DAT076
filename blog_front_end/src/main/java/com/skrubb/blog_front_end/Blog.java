/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.Author;
import com.skrubb.blog_back_end.core.AuthorRegistry;
import com.skrubb.blog_back_end.core.BlogFactory;
import com.skrubb.blog_back_end.core.PostArchive;
import java.io.Serializable;
import javax.inject.Singleton;

/**
 *
 * @author Anders
 */


@Singleton
public class Blog implements Serializable{
     
    private static String pu_name="blog";
    private final com.skrubb.blog_back_end.core.Blog blog;
    
        
    public Blog(){
    
       blog= BlogFactory.getBlog(pu_name);
       createAdmin();
    }
    
    public PostArchive getPostArchive(){
    
        return blog.getPostArchive();
    }
    
    public AuthorRegistry getAuthorRegistry(){
    
        return blog.getAuthorRegistry();
    }
    
    private void createAdmin(){
        Author admin = new Author("admin","password",Author.AccessLevel.ADMIN);
        getAuthorRegistry().add(admin);
    }    
}