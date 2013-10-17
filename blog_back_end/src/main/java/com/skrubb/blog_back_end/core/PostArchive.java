/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import com.skrubb.blog_back_end.utils.AbstractContentHandler;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author robin
 * @author ollesvensson
 */
public class PostArchive extends AbstractContentHandler<Long, AbstractPost> {
    
    CommentArchive commentArchive;
    TagArchive tagArchive;
    
    public PostArchive(String puName){
        super(AbstractPost.class, puName);
        commentArchive = new CommentArchive(puName);
        tagArchive = new TagArchive(puName);
    }
    
    public List<AbstractPost> getByAuthor(Author author) {
        EntityManager em = getEntityManager();
        
         return em.createQuery("select p from AbstractPost p where p.author = :author",
                AbstractPost.class).setParameter("author", author).getResultList();
    }
   
    public void addTag(Long postId, Tag tag ) {
        tagArchive.update(tag);
        tag = tagArchive.find(tag.getId());
        
        AbstractPost post = this.find(postId);
        
        post.addTag(tag);
        
        super.update(post);
    }
    
    public List<AbstractPost> getByTag(Tag tag) {
        EntityManager em = getEntityManager();
        
         return em.createQuery("select p from AbstractPost p where p.tags = :tag",
                AbstractPost.class).setParameter("tag", tag).getResultList();
    }
    
    public void addComment(Long postId, Comment comment) {
        commentArchive.add(comment);
        comment = commentArchive.find(comment.getId());
        
        AbstractPost post = this.find(postId);
        
        post.addComment(comment);
        
        super.update(post);
    }
    
    public void removeComment(Long postId, Long commentId) {
        AbstractPost post = find(postId);
        post.removeComment(commentArchive.find(commentId));
        commentArchive.remove(commentId);
        super.update(post);
    }
    
    public Tag findTag(String tag) {
        return tagArchive.find(tag);
    }
    
}
