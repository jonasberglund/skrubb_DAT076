/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end;

import com.skrubb.blog_back_end.core.Author;
import com.skrubb.blog_back_end.core.PostArchive;
import com.skrubb.blog_back_end.core.Tag;
import com.skrubb.blog_back_end.core.TextPost;
import java.util.TreeSet;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ollesvensson
 * @author robintornquist
 */
public class PostArchiveTest {
    
    static final String TEST_PU = "blog_test";
    static PostArchive pa;
    
    @Before
    public void before() {
        pa = new PostArchive(TEST_PU);
    }
    
    @Test
    public void addPostTest() {
        
        Author a = new Author("name", "password", Author.AccessLevel.AUTHOR);
        TextPost tpost = new TextPost(a, "First post", new TreeSet<Tag>(), "Hello Olle!");
        
        pa.add(tpost);
        
        
        
        assertTrue(pa.size() == 1);
        
        pa.remove(tpost.getId());
        
        assertTrue(pa.size() == 0);
    }
}
