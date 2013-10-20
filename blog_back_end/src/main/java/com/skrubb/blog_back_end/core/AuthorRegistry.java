/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import com.skrubb.blog_back_end.utils.AbstractContentHandler;
import javax.persistence.EntityManager;

/**
 *
 * @author ollesvensson
 * @author robintornquist
 */
public class AuthorRegistry extends AbstractContentHandler<Long, Author> implements IAuthorRegistry {
    
    public AuthorRegistry(String puName){
        super(Author.class, puName);
    }
    
    public Author getAuthorByLogin(String name, String hashedPassword){
        EntityManager em = getEntityManager();
        
        try{
            return em.createQuery("select a from Author a where a.name = :name AND a.hashedPassword = :hashedPassword",
                Author.class).setParameter("name", name).setParameter("hashedPassword", hashedPassword).getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    
}
