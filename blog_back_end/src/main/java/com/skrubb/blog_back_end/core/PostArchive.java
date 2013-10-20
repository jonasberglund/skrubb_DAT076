/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import com.skrubb.blog_back_end.utils.AbstractContentHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author robin
 * @author ollesvensson
 */
public class PostArchive extends AbstractContentHandler<Long, AbstractPost> {
    
    private CommentArchive commentArchive;
    private TagArchive tagArchive;
    
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
    
    public List<Tag> getAllTags() {
        return tagArchive.getRange(0, tagArchive.size());
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
    
    @Override
    public List<AbstractPost> getRange(int firstItem, int numOfItems) {
        
        EntityManager em = null;
        List<AbstractPost> found = new ArrayList<AbstractPost>();
        
        try {
            em = getEntityManager();
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            
            
            Root<AbstractPost> root = cq.from(AbstractPost.class);
            cq.select(root);
            cq.orderBy(em.getCriteriaBuilder().desc(root.get("id")));
            Query q = em.createQuery(cq);
            
            q.setMaxResults(numOfItems);
            q.setFirstResult(firstItem);
            
            found.addAll(q.getResultList());
            
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "{0}", ex.toString());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        return found;
    }
    
}
