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
        pa = new PostArchive(TEST_PU_EMBEDDED);
        ar = new AuthorRegistry(TEST_PU_EMBEDDED);
        ca = new CommentArchive(TEST_PU_EMBEDDED);
        
    }
    
    @Test
    public void testAddAndRemoveComment() {
        
        //Create and add author
        Author a = new Author("Trobbe", "loesen", Author.AccessLevel.AUTHOR);
        ar.add(a);
        a = ar.find(a.getId());
        
        //Create and add text post
        TextPost tp = new TextPost(a, "hello world", "hello world again");
        pa.add(tp);
        
        //Create comment
        Comment c = new Comment("Olly", "Nedrans vad ballt!");
        
        //Get text post from archive
        tp = (TextPost) pa.find(tp.getId());
        
        //Add comment to text post
        pa.addComment(tp.getId(), c);
        
        //Check if comment has been added to both post and comment archive
        assertTrue(ca.size() == 1);
        assertTrue(tp.getComments().size() == 1);
        
        //Remove comment
        pa.removeComment(tp.getId(), tp.getComments().get(0).getId());
        
        //Check that comment has been removed from both post and comment archive
        assertTrue(ca.size() == 0);
        assertTrue(pa.find(tp.getId()).getComments().size() == 0);
        
    }
}
