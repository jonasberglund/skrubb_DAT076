/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import com.skrubb.blog_back_end.utils.AbstractContentHandler;

/**
 *
 * @author 
 */
public class TagArchive extends AbstractContentHandler<String, Tag> {
    
    public TagArchive(String puName) {
        super(Tag.class, puName);
    }
    
    @Override
    public Tag find(String key) {
        return super.find(key.toUpperCase().trim());
    }
}
