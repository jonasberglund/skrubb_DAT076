/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.core;

import com.skrubb.blog_back_end.utils.AbstractContentHandler;
import javax.persistence.EntityManager;

/**
 * AuthorRegistry extends AbstractContentHanlder and is responsible for
 * add, update and delete authors. AuthorRegistry is also used to find an
 * author when logging in.
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
        }catch(RuntimeException e){
            return null;
        }
    }
    
}
