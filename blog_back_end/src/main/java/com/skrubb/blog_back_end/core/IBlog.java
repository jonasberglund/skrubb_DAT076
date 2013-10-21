/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

/**
 * IBlog is an interface that makes sure that a blog has all methods that
 * are needed in a blog.
 *
 * @author ollesvensson
 */
public interface IBlog {
    
    public IPostArchive getPostArchive();
    
    public IAuthorRegistry getAuthorRegistry();
    
}
