/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import com.skrubb.blog_back_end.utils.AbstractContentHandler;

/**
 *
 * @author ollesvensson
 * @author robintornquist
 */
public class AuthorRegistry extends AbstractContentHandler<Long, Author> {
    
    public AuthorRegistry(String puName){
        super(Author.class, puName);
    }
    
}
