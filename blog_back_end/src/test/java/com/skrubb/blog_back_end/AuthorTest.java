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
    
    @Test
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
    
    @Test
    public void testUpdate() {
        
        //Create author
        Author a = new Author("olle", "trobbe", AccessLevel.ADMIN);
        
        //Add to registry
        ar.add(a);
        
        //Check if author was added to registry
        assertTrue(ar.size() == 1);
        
        //Create updated author
        Author b = new Author(a.getId(), "updated", "updated_pass", AccessLevel.AUTHOR, true);
        
        //Update
        a = ar.update(b);
        
        //Check if authors has been updated
        assertTrue(a.equals(b));
        
        //Optional clean up if not using embedded db
        ar.remove(a.getId());
        assertTrue(ar.size() == 0);
    }
    
    @Test
    public void testGetRange() {
        
        //Add 5 auhtors to registry
        for (int i = 0; i < 5; i++) {
            ar.add(new Author("name" + i, "pass" + i, AccessLevel.AUTHOR));
        }
        
        //Check that all authors have been added
        assertTrue(ar.size() == 5);
        
        //Get 3 authors
        List<Author> list = ar.getRange(1, 3);
        
        //Check that 3 auhtors have been returned
        assertTrue(list.size() == 3);
        
        //Optional cleanup if not using embedded db
        list = ar.getRange(0, 5);
        for (Author a : list) {
            ar.remove(a.getId());
        }
        assertTrue(ar.size() == 0);
    }
    
    @Test
    public void testGetByLogin() {
        
        //Create author
        Author a = new Author("olle", "bulan", Author.AccessLevel.AUTHOR);
        
        //Add author to registry
        ar.add(a);
        
        //Get author from registry
        a = ar.find(a.getId());
        
        //Try to get author by name and password
        Author b = ar.getAuthorByLogin("olle", Author.generateHashedPassword("bulan"));
        
        //Check if get was successful
        assertTrue(a.equals(b));
        
        //Optional cleanup if not using embedded db
        ar.remove(b.getId());
        assertTrue(ar.size() == 0);
    }
}
