/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import com.skrubb.blog_back_end.utils.AbstractContentHandler;
import java.util.List;

/**
 *
 * @author robin
 * @author ollesvensson
 */
public class PostArchive extends AbstractContentHandler<Long, Post> {
    
    public List<Post> getByAuthor(Author author) {
        return null;
    }
    
    public List<Post> getByTag(Tag tag) {
        return null;
    }
    
}
