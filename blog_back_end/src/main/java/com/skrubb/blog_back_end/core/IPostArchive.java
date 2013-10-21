/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import com.skrubb.blog_back_end.utils.IContentHandler;
import java.util.List;

/**
 * Interface for the Blog and Postarchive
 * @author ollesvensson
 */
public interface IPostArchive extends IContentHandler<Long, AbstractPost> {
    
    public void addTag(Long postId, Tag tag );
    
    public Tag findTag(String tag);
    
    public List<AbstractPost> getByTag(Tag tag);
    
    public List<Tag> getAllTags();
    
    public void addComment(Long postId, Comment comment);
    
    public void removeComment(Long postId, Long commentId);
    
    public List<AbstractPost> getByAuthor(Author author);
}
