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
    
    
    public PostArchive(String puName){
        super(AbstractPost.class, puName);
    }
    
    public List<AbstractPost> getByAuthor(Author author) {
        EntityManager em = getEntityManager();
        
         return em.createQuery("select p from AbstractPost p where p.author = :author",
                AbstractPost.class).setParameter("author", author).getResultList();
    }
    
    public List<AbstractPost> getByTag(Tag tag) {
        EntityManager em = getEntityManager();
        
         return em.createQuery("select p from AbstractPost p where p.tags = :tag",
                AbstractPost.class).setParameter("tag", tag).getResultList();
    }
    
}
