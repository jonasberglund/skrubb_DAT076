/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end;

import com.skrubb.blog_back_end.core.AbstractPost;
import com.skrubb.blog_back_end.core.Author;
import com.skrubb.blog_back_end.core.AuthorRegistry;
import com.skrubb.blog_back_end.core.Comment;
import com.skrubb.blog_back_end.core.CommentArchive;
import com.skrubb.blog_back_end.core.PhotoPost;
import com.skrubb.blog_back_end.core.PostArchive;
import com.skrubb.blog_back_end.core.Tag;
import com.skrubb.blog_back_end.core.TagArchive;
import com.skrubb.blog_back_end.core.TextPost;
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
    static final String TEST_PU_EMBEDDED = "blog_test_embedded";
    static PostArchive pa;
    static AuthorRegistry ar;
    static TagArchive ta;
    static CommentArchive ca;
    
    @Before
    public void before() {
        
        pa = new PostArchive(TEST_PU_EMBEDDED);
        ar = new AuthorRegistry(TEST_PU_EMBEDDED);
        ta = new TagArchive(TEST_PU_EMBEDDED);
        ca = new CommentArchive(TEST_PU_EMBEDDED);
    }
    
//    @Test
    public void addAndRemovePostTest() {
        
        Author a = new Author("name", "password", Author.AccessLevel.AUTHOR);
        ar.add(a);
        a = ar.find(a.getId());
        
        TextPost tpost = new TextPost(a, "First post", "Hello Olle!");
        PhotoPost ppost = new PhotoPost(a, "First photo post", "http://someurl.com/pic.jpg");
        
        pa.add(tpost);
        assertTrue(pa.size() == 1);
        
        pa.add(ppost);
        assertTrue(pa.size() == 2);
        
        pa.remove(tpost.getId());
        assertTrue(pa.size() == 1);
        
        pa.remove(ppost.getId());
        assertTrue(pa.size() == 0);
        
        ar.remove(a.getId());
        assertTrue(ar.size() == 0);
    }
    
//    @Test
    public void testGetByAuthor(){
    
        Author a1 = new Author("name1", "password", Author.AccessLevel.AUTHOR);
        Author a2 = new Author("name2", "password", Author.AccessLevel.AUTHOR);
        
        ar.add(a1);
        ar.add(a2);
        
        TextPost tpost1 = new TextPost(ar.find(a1.getId()), "First post", "Hello Olle! 1");
        TextPost tpost2 = new TextPost(ar.find(a1.getId()), "Second post", "Hello Olle! 2");
        TextPost tpost3 = new TextPost(ar.find(a2.getId()), "Third post", "Hello Olle! 3");
        
        pa.add(tpost1);
        pa.add(tpost2);
        pa.add(tpost3);
        
        assertTrue(pa.getByAuthor(ar.find(a1.getId())).size() == 2);
        assertTrue(pa.getByAuthor(ar.find(a2.getId())).size() == 1);
        
    }
    
//    @Test
    public void testGetByTag(){
    
        Author a1 = new Author("name1", "password", Author.AccessLevel.AUTHOR);
        Author a2 = new Author("name2", "password", Author.AccessLevel.AUTHOR);
        
        ar.add(a1);
        ar.add(a2);
        
        TextPost tpost1 = new TextPost(ar.find(a1.getId()), "First post", "Hello Olle! 1");
        TextPost tpost2 = new TextPost(ar.find(a1.getId()), "Second post", "Hello Olle! 2");
        TextPost tpost3 = new TextPost(ar.find(a2.getId()), "Third post", "Hello Olle! 3");
        
        pa.add(tpost1);
        pa.add(tpost2);
        pa.add(tpost3);
        
        //tpost1 = (TextPost)pa.find(tpost1.getId());
        //tpost2 = (TextPost)pa.find(tpost2.getId());
        
        pa.addTag(tpost1.getId(), new Tag("first"));
        pa.addTag(tpost1.getId(), new Tag("life"));
        
        pa.addTag(tpost2.getId(), new Tag("life"));
        pa.addTag(tpost2.getId(), new Tag("death"));
        
        assertTrue(pa.getByTag(ta.find("FIRSt ")).size() == 1);
        assertTrue(pa.getByTag(ta.find("FIRST")).get(0).getTitle().equals("First post"));
        assertTrue(pa.getByTag(ta.find("life")).size() == 2);
        assertTrue(pa.getByTag(ta.find("deaTh")).size() == 1);
        assertTrue(pa.getByTag(ta.find("unknown")).size() == 0);
    }
    
//    @Test
    public void addCommentTest() {
        
        Author a1 = new Author("Bill", "bull", Author.AccessLevel.AUTHOR);
        ar.add(a1);
        a1 = ar.find(a1.getId());
        
        PhotoPost photoPost = new PhotoPost(a1, "photo post", "http://someurl.com/photo.jpg");
        
        pa.add(photoPost);
        
        TextPost textPost = new TextPost(a1, "Test text post", "blablabla");
        
        pa.add(textPost);
        
        AbstractPost post = pa.find(photoPost.getId());
        
        Comment c = new Comment("Manne", "Vilken snygg bild!");
        pa.addComment(post.getId(), c);
        c = new Comment("B-T", "Håller med Manne");
        pa.addComment(post.getId(), c);
        
        assertTrue(post.getComments().size() == 2);
        
        pa.remove(post.getId());
        
        assertTrue(ca.size() == 0);
    }
    
//    @Test
    public void postUpdateTest() {
        Author olleTheAuthor = new Author("Olle", "mittlösenord", Author.AccessLevel.AUTHOR);
        
        ar.add(olleTheAuthor);
        olleTheAuthor =  ar.find(olleTheAuthor.getId());
        
        PhotoPost post = new PhotoPost(olleTheAuthor, "Olles FotoPost", "http://www.test.se/img.jpeg");
        
        pa.add(post);
        
        post = (PhotoPost)pa.find(post.getId());
        pa.addComment(post.getId(), new Comment("B-T", "Underbart fartyg, snyggt fotat Olle!"));
        pa.addComment(post.getId(), new Comment("Uno", "Många fina styralgoritmer där!"));
        assertTrue(ca.size() == 2);
        
        PhotoPost updatedPost = new PhotoPost(post, "http://www.newURL.com/bild.png");
        pa.update(updatedPost);
        assertTrue(ca.size() == 2);
        
        post = (PhotoPost)pa.find(post.getId());
        pa.addComment(post.getId(), new Comment("B-T", "hejsan hoppas!"));
        assertTrue(ca.size() == 3);
        
        assertTrue(post.getComments().size() == 3);
        
        pa.remove(updatedPost.getId());
        assertTrue(ca.size() == 0);
        
    }
}
