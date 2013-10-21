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
    
    @Test
    public void addAndRemovePostTest() {
        
        //Create, add and auhtor
        Author a = new Author("name", "password", Author.AccessLevel.AUTHOR);
        ar.add(a);
        
        //Get auhtor from archive
        a = ar.find(a.getId());
        
        //Create text and photo post
        TextPost tpost = new TextPost(a, "First post", "Hello Olle!");
        PhotoPost ppost = new PhotoPost(a, "First photo post", "http://someurl.com/pic.jpg");
        
        //Add text post and check if added
        pa.add(tpost);
        assertTrue(pa.size() == 1);
        
        //Create photo post and check if added
        pa.add(ppost);
        assertTrue(pa.size() == 2);
        
        //Remove text post and check if removed
        pa.remove(tpost.getId());
        assertTrue(pa.size() == 1);
        
        //Remove photo post and check if removed
        pa.remove(ppost.getId());
        assertTrue(pa.size() == 0);
        
        //Optional cleanup if not running embedded db
        ar.remove(a.getId());
        assertTrue(ar.size() == 0);
    }
    
    @Test
    public void testGetByAuthor(){
    
        //Create and add 2 auhtors
        Author a1 = new Author("name1", "password", Author.AccessLevel.AUTHOR);
        Author a2 = new Author("name2", "password", Author.AccessLevel.AUTHOR);
        ar.add(a1);
        ar.add(a2);
        
        //Create and add 2 posts by author a1
        TextPost tpost1 = new TextPost(ar.find(a1.getId()), "First post", "Hello Olle! 1");
        TextPost tpost2 = new TextPost(ar.find(a1.getId()), "Second post", "Hello Olle! 2");
        pa.add(tpost1);
        pa.add(tpost2);
        
        //Create and add post by author a2
        TextPost tpost3 = new TextPost(ar.find(a2.getId()), "Third post", "Hello Olle! 3");
        pa.add(tpost3);
        
        //Check if author a1 has 2 posts
        assertTrue(pa.getByAuthor(ar.find(a1.getId())).size() == 2);
        
        //Check if author a2 has 1 post
        assertTrue(pa.getByAuthor(ar.find(a2.getId())).size() == 1);
        
    }
    
    @Test
    public void testGetByTag(){
    
        //Create and add 2 authors
        Author a1 = new Author("name1", "password", Author.AccessLevel.AUTHOR);
        Author a2 = new Author("name2", "password", Author.AccessLevel.AUTHOR);    
        ar.add(a1);
        ar.add(a2);
        
        //Create and add 2 posts by author a1
        TextPost tpost1 = new TextPost(ar.find(a1.getId()), "First post", "Hello Olle! 1");
        TextPost tpost2 = new TextPost(ar.find(a1.getId()), "Second post", "Hello Olle! 2");
        pa.add(tpost1);
        pa.add(tpost2);
        
        //Create and add post by author a2
        TextPost tpost3 = new TextPost(ar.find(a2.getId()), "Third post", "Hello Olle! 3");
        pa.add(tpost3);
        
        //Add tags to post1
        pa.addTag(tpost1.getId(), new Tag("first"));
        pa.addTag(tpost1.getId(), new Tag("life"));
        
        //Add tags to post2
        pa.addTag(tpost2.getId(), new Tag("life"));
        pa.addTag(tpost2.getId(), new Tag("death"));
        
        //Check if tags are case sensitive (shouldn't be)
        assertTrue(pa.getByTag(ta.find("FIRSt ")).size() == 1);
        assertTrue(pa.getByTag(ta.find("deaTh")).size() == 1);
        
        //Check that correct post is returned
        assertTrue(pa.getByTag(ta.find("FIRST")).get(0).getTitle().equals("First post"));
        
        //Check that all posts with tag in common are returned
        assertTrue(pa.getByTag(ta.find("life")).size() == 2);
        
        //Check that tag not linked to any post doesn't return any post
        assertTrue(pa.getByTag(ta.find("unknown")).size() == 0);
    }
    
    @Test
    public void addAndRemoveCommentCascadeTest() {
        
        //Add and create author
        Author a1 = new Author("Bill", "bull", Author.AccessLevel.AUTHOR);
        ar.add(a1);
        a1 = ar.find(a1.getId());
        
        //Create and add photo post
        PhotoPost photoPost = new PhotoPost(a1, "photo post", "http://someurl.com/photo.jpg");
        pa.add(photoPost);
        
        //Create and add text post
        TextPost textPost = new TextPost(a1, "Test text post", "blablabla");
        pa.add(textPost);
        
        //Get photo post from archive
        AbstractPost post = pa.find(photoPost.getId());
        
        //Add 2 comments to post
        Comment c = new Comment("Manne", "Vilken snygg bild!");
        pa.addComment(post.getId(), c);
        c = new Comment("B-T", "Håller med Manne");
        pa.addComment(post.getId(), c);
        
        //Get updated reference to post
        post = pa.find(photoPost.getId());
        
        //Check that comments are added to both post and comment archive
        assertTrue(post.getComments().size() == 2);
        assertTrue(ca.size() == 2);
        
        //Remove post
        pa.remove(post.getId());
        
        //Check that comments are removed when post is removed (cascade)
        assertTrue(ca.size() == 0);
    }
    
    @Test
    public void postUpdateTest() {
        
        //Create and add author
        Author olleTheAuthor = new Author("Olle", "mittlösenord", Author.AccessLevel.AUTHOR);
        ar.add(olleTheAuthor);
        olleTheAuthor =  ar.find(olleTheAuthor.getId());
        
        //Create and add photo post
        PhotoPost post = new PhotoPost(olleTheAuthor, "Olles FotoPost", "http://www.test.se/img.jpeg");
        pa.add(post);
        post = (PhotoPost)pa.find(post.getId());
        
        //Add comments to post
        pa.addComment(post.getId(), new Comment("B-T", "Underbart fartyg, snyggt fotat Olle!"));
        pa.addComment(post.getId(), new Comment("Uno", "Många fina styralgoritmer där!"));
        
        //Check if added to post
        assertTrue(ca.size() == 2);
        
        //Update post
        PhotoPost updatedPost = new PhotoPost(post, "http://www.newURL.com/bild.png");
        pa.update(updatedPost);
        
        //Check that comments have not been removed
        assertTrue(ca.size() == 2);
        
        //Add new comment
        post = (PhotoPost)pa.find(post.getId());
        pa.addComment(post.getId(), new Comment("B-T", "hejsan hoppas!"));
        
        //Check that updated post has both old and new comments
        assertTrue(post.getComments().size() == 3);
        
        //Check that all comments are still in archive
        assertTrue(ca.size() == 3);
        
        //Remove post
        pa.remove(updatedPost.getId());
        
        //Check that comments are removed from archive (cascade)
        assertTrue(ca.size() == 0);
        
    }
}
