/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end.bb.post;

import com.skrubb.blog_back_end.core.Comment;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

/**
 *
 * @author jonasberglund
 */
@Named("addComment")
@ConversationScoped
public class AddCommentBB extends ConversationalPost {

    public AddCommentBB(){
        
    }
    
    @Override
    protected void execute() {        
        Long id = getId();
        
        Comment comment = new Comment(getCommenter() , getValue());
        blog.getPostArchive().addComment(id, comment);
    }
}
