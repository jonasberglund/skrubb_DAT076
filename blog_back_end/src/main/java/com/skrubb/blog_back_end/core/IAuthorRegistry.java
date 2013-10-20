/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import com.skrubb.blog_back_end.utils.IContentHandler;

/**
 *
 * @author ollesvensson
 */
public interface IAuthorRegistry extends IContentHandler<Long, Author> {
    
    public Author getAuthorByLogin(String name, String hashedPassword);
}
