/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end.bb.post;

import com.skrubb.blog_back_end.core.Tag;
import com.skrubb.blog_back_end.core.TextPost;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

/**
 *
 * @author Anders
 */
@Named("addPost")
@ConversationScoped
public class AddTextPostBB extends ConversationalPost {
    private static final long serialVersionUID = 10056297270999998L;
    
    public AddTextPostBB(){
    
    }
    
    @Override
    protected void execute() {
       List<String> items = Arrays.asList(getTags().split("\\s*,\\s*"));
       
       TextPost tp = new TextPost(blog.getAuthorRegistry().find(loginbean.getAuthor().getId()), getTitle(), getValue());
       blog.getPostArchive().add(tp);
       
       for(String s:items) {
           Tag tag=new Tag(s);
           blog.getPostArchive().addTag(tp.getId(), tag);
       }   
    }
}
