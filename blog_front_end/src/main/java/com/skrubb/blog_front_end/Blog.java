/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.AbstractPost;
import com.skrubb.blog_back_end.core.Author;
import com.skrubb.blog_back_end.core.AuthorRegistry;
import com.skrubb.blog_back_end.core.BlogFactory;
import com.skrubb.blog_back_end.core.PostArchive;
import com.skrubb.blog_back_end.core.TextPost;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
    }
    
    public PostArchive getPostArchive(){
    
        return blog.getPostArchive();
    }
    
    public AuthorRegistry getAuthorRegistry(){
    
        return blog.getAuthorRegistry();
    }
    
    
    
    
    
    
    
    
    
    public static ArrayList<AbstractPost> listOfPost =new ArrayList<AbstractPost>();
    
    public ArrayList<AbstractPost> getArrayListOfPost(){
    
        return listOfPost;
    }
    
    
    
    
    
    
    
}