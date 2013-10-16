/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.Author;
import com.skrubb.blog_back_end.core.TextPost;
import java.util.Iterator;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Anders
 */
//@ManagedBean(name="editorBean")
//@SessionScoped
@Named("addPost")
@ConversationScoped
public class AddPost extends ConversationalPost {
    
    public AddPost(){
    
    }
    
    @Override
    protected void execute() {
       
        
       // Blog.listOfPost.add(new TextPost(Blog.a1, getTitle(), getValue()));
        //DummyDB.listOfPost.add(new TextPost(DummyDB.a1, null, getTitle(), null, getValue()));
        /*TextPost tp=new TextPost(null,DummyDB.a1, null, getTitle(), null, getValue());
        Long i=Long.valueOf("1");
        tp.id=i;
        DummyDB.listOfPost.add(tp );
        */
        
       
    }
}
