/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import com.skrubb.blog_back_end.utils.AbstractContentHandler;

/**
 *
 * @author root
 */
public class TagArchive extends AbstractContentHandler<Long, Tag> {
    
    public TagArchive(String puName) {
        super(Tag.class, puName);
    }
    
}
