/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end;

import com.skrubb.blog_back_end.core.Author;
import com.skrubb.blog_back_end.core.AuthorRegistry;
import com.skrubb.blog_back_end.core.PhotoPost;
import com.skrubb.blog_back_end.core.PostArchive;
import com.skrubb.blog_back_end.core.Tag;
import com.skrubb.blog_back_end.core.TagArchive;
import com.skrubb.blog_back_end.core.TextPost;
import com.skrubb.blog_back_end.utils.TagComparator;
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
    static AuthorRegistry ar;
    static TagArchive ta;
    
    @Before
    public void before() {
        pa = new PostArchive(TEST_PU);
        ar = new AuthorRegistry(TEST_PU);
        ta = new TagArchive(TEST_PU);
    }
    
    @Test
    public void addAndRemovePostTest() {
        
        Author a = new Author("name", "password", Author.AccessLevel.AUTHOR);
        ar.add(a);
        a = ar.find(a.getId());
        
        TagComparator comparator = new TagComparator();
        
        TreeSet<Tag> textTags = new TreeSet<Tag>(comparator);
        TreeSet<Tag> photoTags = new TreeSet<Tag>(comparator);
        
        Tag firstTag =  new Tag("first");
        ta.add(firstTag);
        
        Tag lifeTag =  new Tag("life");
        ta.add(lifeTag);
        
        textTags.add(ta.find(firstTag.getId()));
        textTags.add(ta.find(lifeTag.getId()));
        photoTags.add(ta.find(lifeTag.getId()));
        
        TextPost tpost = new TextPost(a, "First post", textTags, "Hello Olle!");
        PhotoPost ppost = new PhotoPost(a, "First photo post", photoTags, "http://someurl.com/pic.jpg");
        
        pa.add(tpost);
        assertTrue(pa.size() == 1);
        
        pa.add(ppost);
        assertTrue(pa.size() == 2);
        
//        pa.remove(tpost.getId());
//        assertTrue(pa.size() == 1);
//        
//        pa.remove(ppost.getId());
//        assertTrue(pa.size() == 0);
    }
}
