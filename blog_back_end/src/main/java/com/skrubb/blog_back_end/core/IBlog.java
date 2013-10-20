/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

/**
 *
 * @author ollesvensson
 */
public interface IBlog {
    
    public IPostArchive getPostArchive();
    
    public IAuthorRegistry getAuthorRegistry();
    
}
