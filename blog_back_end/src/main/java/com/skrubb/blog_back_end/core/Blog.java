/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

/**
 *
 * @author robin
 * @author ollesvensson
 */
public class Blog implements IBlog {
    
    private IPostArchive postArchive;
    private IAuthorRegistry authorRegistry;
    
    public Blog(String puName) {
        postArchive = new PostArchive(puName);
        authorRegistry = new AuthorRegistry(puName);
    }
    
    public IPostArchive getPostArchive() {
        return postArchive;
    }
    
    public IAuthorRegistry getAuthorRegistry() {
        return authorRegistry;
    }
}
