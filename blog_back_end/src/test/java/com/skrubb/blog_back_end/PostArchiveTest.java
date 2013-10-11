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
    static final String TEST_PU_EMBEDDED = "blog_test_embedded";
    static PostArchive pa;
    static AuthorRegistry ar;
    static TagArchive ta;
    
    @Before
    public void before() {
        pa = new PostArchive(TEST_PU_EMBEDDED);
        ar = new AuthorRegistry(TEST_PU_EMBEDDED);
        ta = new TagArchive(TEST_PU_EMBEDDED);
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
        
        pa.remove(tpost.getId());
        assertTrue(pa.size() == 1);
        
        pa.remove(ppost.getId());
        assertTrue(pa.size() == 0);
        
        ar.remove(a.getId());
        assertTrue(ar.size() == 0);
    }
    
    @Test
    public void testGetByAuthor(){
    
        Author a1 = new Author("name1", "password", Author.AccessLevel.AUTHOR);
        Author a2 = new Author("name2", "password", Author.AccessLevel.AUTHOR);
        
        ar.add(a1);
        ar.add(a2);
        
        TextPost tpost1 = new TextPost(ar.find(a1.getId()), "First post", new TreeSet<Tag>(), "Hello Olle! 1");
        TextPost tpost2 = new TextPost(ar.find(a1.getId()), "Second post", new TreeSet<Tag>(), "Hello Olle! 2");
        TextPost tpost3 = new TextPost(ar.find(a2.getId()), "Third post", new TreeSet<Tag>(), "Hello Olle! 3");
        
        pa.add(tpost1);
        pa.add(tpost2);
        pa.add(tpost3);
        
        assertTrue(pa.getByAuthor(ar.find(a1.getId())).size() == 2);
        assertTrue(pa.getByAuthor(ar.find(a2.getId())).size() == 1);
        
    }
    
    @Test
    public void testGetByTag(){
    
        Author a1 = new Author("name1", "password", Author.AccessLevel.AUTHOR);
        Author a2 = new Author("name2", "password", Author.AccessLevel.AUTHOR);
        
        ar.add(a1);
        ar.add(a2);
        
        TagComparator comparator = new TagComparator();
        
        TreeSet<Tag> textTags1 = new TreeSet<Tag>(comparator);
        TreeSet<Tag> textTags2 = new TreeSet<Tag>(comparator);
        TreeSet<Tag> textTags3 = new TreeSet<Tag>(comparator);
        
        Tag firstTag =  new Tag("first");
        ta.add(firstTag);
        
        Tag lifeTag =  new Tag("life");
        ta.add(lifeTag);
        
        Tag deathTag =  new Tag("death");
        ta.add(deathTag);
        
        Tag unknownTag =  new Tag("unknown");
        ta.add(unknownTag);
        
        textTags1.add(ta.find(firstTag.getId()));
        textTags1.add(ta.find(lifeTag.getId()));
        
        textTags2.add(ta.find(lifeTag.getId()));
        textTags2.add(ta.find(deathTag.getId()));
        
        TextPost tpost1 = new TextPost(ar.find(a1.getId()), "First post", textTags1, "Hello Olle! 1");
        TextPost tpost2 = new TextPost(ar.find(a1.getId()), "Second post", textTags2, "Hello Olle! 2");
        TextPost tpost3 = new TextPost(ar.find(a2.getId()), "Third post", textTags3, "Hello Olle! 3");
        
        pa.add(tpost1);
        pa.add(tpost2);
        pa.add(tpost3);
        
        assertTrue(pa.getByTag(ta.find(firstTag.getId())).size() == 1);
        assertTrue(pa.getByTag(ta.find(firstTag.getId())).get(0).getTitle().equals("First post"));
        assertTrue(pa.getByTag(ta.find(lifeTag.getId())).size() == 2);
        assertTrue(pa.getByTag(ta.find(deathTag.getId())).size() == 1);
        assertTrue(pa.getByTag(ta.find(unknownTag.getId())).size() == 0);
    }
}
