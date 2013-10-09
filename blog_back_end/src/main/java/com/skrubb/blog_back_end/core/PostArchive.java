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
public class PostArchive extends AbstractContentHandler<Long, AbstractPost> {
    
    
    public PostArchive(String puName){
        super(AbstractPost.class, puName);
    }
    
    public List<AbstractPost> getByAuthor(Author author) {
        return null;
    }
    
    public List<AbstractPost> getByTag(Tag tag) {
        return null;
    }
    
}
