/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

/**
 * BlogFactory returns an IBlog. Takes a persistence unit name as parameter.
 *
 * @author Anders
 */
public class BlogFactory {

    public BlogFactory() {
    
    }
    
    public static IBlog getBlog(String puName)
    {
        IBlog blog = new Blog(puName);
        return blog;
    }
    
    
}
