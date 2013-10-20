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
    
    public static IBlog getBlog(String puName)
    {
        return new Blog(puName);
    }
    
    
}
