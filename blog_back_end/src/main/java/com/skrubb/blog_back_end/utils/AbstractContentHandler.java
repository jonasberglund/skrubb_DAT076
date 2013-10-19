/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ollesvensson
 * @author robintornquist
 */
public abstract class AbstractContentHandler<K, T> implements IContentHandler<K, T>{
    
    private EntityManagerFactory emf;
    private final Class<T> classType;
    
    protected AbstractContentHandler(Class<T> classType, String puName){
        this.classType = classType;
        emf = Persistence.createEntityManagerFactory(puName);
    }
    
    protected EntityManager getEntityManager() {
        EntityManager em = emf.createEntityManager();
        Logger.getAnonymousLogger().log(Level.INFO, "Createing EntityManager {0}", em);
        return em;
    }

    @Override
    public void add(T t) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "{0}", ex.toString());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void remove(K k) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            T t = em.getReference(classType, k);
            em.remove(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "{0}", ex.toString());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public T update(T t) {
        EntityManager em = null;
        T updated = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            updated = em.merge(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "{0}", ex.toString());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return updated;
    }

    @Override
    public T find(K k) {
        EntityManager em = getEntityManager();
        T t = em.find(classType, k);
        return t;
    }

    @Override
    public int size() {
        EntityManager em = null;
        int count = -1;
        
        try {
            em = getEntityManager();
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<T> rt = cq.from(classType);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            count = ((Long)q.getSingleResult()).intValue();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "{0}", ex.toString());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        return count;
    }

    @Override
    public List<T> getRange(int firstItem, int numOfItems) {
        
        EntityManager em = null;
        List<T> found = new ArrayList<T>();
        
        try {
            em = getEntityManager();
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(classType));
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
