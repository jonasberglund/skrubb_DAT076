/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import com.skrubb.blog_back_end.utils.AbstractContentHandler;
import com.skrubb.blog_back_end.utils.TagComparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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
   
    public void addTag(AbstractPost post, Tag tag ) {
        tagArchive.add(tag);
        tag = tagArchive.find(tag.getId());
        
        post.addTag(tag);
        
        super.update(post);
    }
    
    public List<AbstractPost> getByTag(Tag tag) {
        EntityManager em = getEntityManager();
        
         return em.createQuery("select p from AbstractPost p where p.tags = :tag",
                AbstractPost.class).setParameter("tag", tag).getResultList();
    }
    
    public void addComment(AbstractPost post, Comment comment) {
        commentArchive.add(comment);
        comment = commentArchive.find(comment.getId());
        
        post.addComment(comment);
        
        super.update(post);
    }
    
}
