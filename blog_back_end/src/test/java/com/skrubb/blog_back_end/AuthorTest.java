/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end;

import com.skrubb.blog_back_end.core.Author;
import com.skrubb.blog_back_end.core.Author.AccessLevel;
import com.skrubb.blog_back_end.core.AuthorRegistry;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ollesvensson
 */
public class AuthorTest {
    
    static final String TEST_PU = "blog_test";
    static final String TEST_PU_EMBEDDED = "blog_test_embedded";
    static AuthorRegistry ar;
    
    @Before
    public void before() {
        ar = new AuthorRegistry(TEST_PU_EMBEDDED);
    }
    
    //@Test
    public void testAddAndFindAndRemove() {
        
        //Create author
        Author a = new Author("name", "password", AccessLevel.AUTHOR);
        
        //Add to registry
        ar.add(a);
        
        //Get object a from registry
        Author b = ar.find(a.getId());
        
        //Check if b equals a
        assertTrue(b.equals(a));
        
        //Remove from registry
        ar.remove(b.getId());
        
        //Try to get removed object
        a = ar.find(b.getId());
        
        //a should be null because it should not exist in the database and
        //thus the find operation should return
        assertTrue(a == null);
    }
    
//    @Test
    public void testUpdate() {
        Author a = new Author("olle", "trobbe", AccessLevel.ADMIN);
        
        ar.add(a);
        
        assertTrue(ar.size() == 1);
        
        Author b = new Author(a.getId(), "updated", "updated_pass", AccessLevel.AUTHOR, true);
        
        a = ar.update(b);
        
        assertTrue(a.equals(b));
        
        ar.remove(a.getId());
        
        assertTrue(ar.size() == 0);
    }
    
//    @Test
    public void testGetRange() {
        
        for (int i = 0; i < 5; i++) {
            ar.add(new Author("name" + i, "pass" + i, AccessLevel.AUTHOR));
        }
        
        assertTrue(ar.size() == 5);
        
        List<Author> list = ar.getRange(1, 3);
        assertTrue(list.size() == 3);
        
        
        //assertTrue(list.get(0).getName().equals("name1"));
        
        list = ar.getRange(0, 5);
        
        for (Author a : list) {
            ar.remove(a.getId());
        }
        
        assertTrue(ar.size() == 0);
    }
    
    @Test
    public void testGetByLogin() {
        
        Author a = new Author("olle", "bulan", Author.AccessLevel.AUTHOR);
        ar.add(a);
        a = ar.find(a.getId());
        
        Author b = ar.getAuthorByLogin("olle", Author.generateHashedPassword("bulan"));
        
        assertTrue(a.equals(b));
    }
}
