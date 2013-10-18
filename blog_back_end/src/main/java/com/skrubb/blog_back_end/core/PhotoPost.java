/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author robin
 * @author ollesvensson
 */
@Entity
@Table(name = "PHOTO_POST")
public class PhotoPost extends AbstractPost implements Serializable {
    
    @Column(name = "PHOTO_URL")
    private String photoUrl;
    
    protected PhotoPost() {
        
    }
    
    public PhotoPost(Author author, String title, String photoUrl){
        super(author,title);
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

    @Override
    public String getData() {
        return photoUrl;
    }
}
