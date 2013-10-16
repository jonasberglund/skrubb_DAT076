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
public class Blog {
    
    private PostArchive postArchive;
    private AuthorRegistry authorRegistry;
    
    public Blog(String puName) {
        postArchive = new PostArchive(puName);
        authorRegistry = new AuthorRegistry(puName);
    }
    
    public PostArchive getPostArchive() {
        return postArchive;
    }
    
    public AuthorRegistry getAuthorRegistry() {
        return authorRegistry;
    }
    
}
