/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author robin
 * @author ollesvensson
 */
public class PhotoPost extends Post {
    private String photoUrl;
    
    public PhotoPost(Author author, Date date, String title, Set<Tag> tags, String photoUrl){
        super(author, date, title, tags);
        this.photoUrl = photoUrl;
    }
    
    /**
     * Used when you want to edit a post
     * @param photoPost The PhotoPost object you want to change
     * @param photoUrl The new picture URL.
     */
    public PhotoPost(PhotoPost photoPost, String photoUrl){
        super(photoPost);
        this.photoUrl = photoUrl;
    }
    
    public String getPhotoUrl() {
        return photoUrl;
    }
}
