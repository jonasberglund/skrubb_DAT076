/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import java.util.Set;

/**
 *
 * @author robin
 * @author ollesvensson
 */
public class Blog {
    
    private PostArchive postArchive;
    private String title;
    private String headerUrl;
    private Set<Author> authors;
    
    public Blog(PostArchive postArchive, String title, String headerUrl, Set<Author> authors) {
        this.authors = authors;
        this.headerUrl = headerUrl;
        this.title = title;
        this.postArchive = postArchive;
    }
    
    public PostArchive getPostArchive() {
        return postArchive;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getHeaderUrl() {
        return headerUrl;
    }
    
    public Set<Author> getAuthors() {
        return authors;
    }
    
}
