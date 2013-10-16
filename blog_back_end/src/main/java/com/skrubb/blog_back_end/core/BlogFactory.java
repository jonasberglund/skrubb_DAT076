/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

/**
 *
 * @author Anders
 */
public class BlogFactory {

    public BlogFactory() {
    
    }
    
    public static Blog getBlog(String puName)
    {
        Blog blog=new Blog(puName);
        return blog;
    }
    
    
}
