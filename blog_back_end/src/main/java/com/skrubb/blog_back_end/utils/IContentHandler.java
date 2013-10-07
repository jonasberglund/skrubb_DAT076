/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.utils;

import java.util.List;

/**
 *
 * @author ollesvensson
 * @author robintornquist
 */
public interface IContentHandler<K, T>{
    
    public void add(T t);
    
    public void remove(K k);
    
    public T update(T t);
    
    public T find(K k);
    
    public int size();
    
    public List<T> getRange(int firstItem, int numOfItems);
}
