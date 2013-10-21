/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import com.skrubb.blog_back_end.utils.AbstractContentHandler;

/**
 * CommentArchive extends AbstractContentHandler and is responsible for
 * add, update and remove comments to the database.
 *
 * @author ollesvensson
 * @author robintornquist
 */
public class CommentArchive extends AbstractContentHandler<Long, Comment> {
    
    public CommentArchive(String puName){
        super(Comment.class, puName);
    }
    
}
