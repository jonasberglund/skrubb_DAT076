/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end;

import com.skrubb.blog_back_end.core.Author;
import com.skrubb.blog_back_end.core.AuthorRegistry;
import com.skrubb.blog_back_end.core.Comment;
import com.skrubb.blog_back_end.core.CommentArchive;
import com.skrubb.blog_back_end.core.PostArchive;
import com.skrubb.blog_back_end.core.TextPost;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ollesvensson
 */
public class CommentTest {
    
    static final String TEST_PU = "blog_test";
    static final String TEST_PU_EMBEDDED = "blog_test_embedded";
    PostArchive pa;
    AuthorRegistry ar;
    CommentArchive ca;
    
    @Before
    public void before() {
        pa = new PostArchive(TEST_PU);
        ar = new AuthorRegistry(TEST_PU);
        ca = new CommentArchive(TEST_PU);
        
    }
    
    @Test
    public void testRemoveComment() {
        Author a = new Author("Trobbe", "loesen", Author.AccessLevel.AUTHOR);
        ar.add(a);
        a = ar.find(a.getId());
        
        TextPost tp = new TextPost(a, "hello world", "hello world again");
        
        Comment c = new Comment("Olly", "Nedrans vad ballt!");
        pa.add(tp);
        tp = (TextPost) pa.find(tp.getId());
        
        pa.addComment(tp, c);
        
        assertTrue(ca.size() == 1);
        assertTrue(tp.getComments().size() == 1);
        
        pa.removeComment(tp.getId(), tp.getComments().get(0).getId());
        
        assertTrue(ca.size() == 0);
        assertTrue(pa.find(tp.getId()).getComments().size() == 0);
        
    }
}
