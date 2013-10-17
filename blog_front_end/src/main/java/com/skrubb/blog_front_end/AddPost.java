/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.Author;
import com.skrubb.blog_back_end.core.TextPost;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

/**
 *
 * @author Anders
 */
@Named("addPost")
@ConversationScoped
public class AddPost extends ConversationalPost {
    
    public AddPost(){
    
    }
    
    @Override
    protected void execute() {
        
        
       Author a1= blog.getAuthorRegistry().getAuthorByLogin("olle", Author.generateHashedPassword("kissekatt"));
       
       TextPost tp = new TextPost(a1, getTitle(), getValue());
       
       blog.getPostArchive().add(tp);
       
       
       //Get author
       //Author a = getAuthor();
        
       //blog.getPostArchive().add(null);
        
        
       // Blog.listOfPost.add(new TextPost(Blog.a1, getTitle(), getValue()));
        //DummyDB.listOfPost.add(new TextPost(DummyDB.a1, null, getTitle(), null, getValue()));
        /*TextPost tp=new TextPost(null,DummyDB.a1, null, getTitle(), null, getValue());
        Long i=Long.valueOf("1");
        tp.id=i;
        DummyDB.listOfPost.add(tp );
        */
        
       
    }
}
