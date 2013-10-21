/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.skrubb.blog_front_end.bb.post;

import com.skrubb.blog_back_end.core.TextPost;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
/**
 * Edit a textpost save on database
 * @author jonasberglund, Anders Johansson
 */
@Named("editPost")
@ConversationScoped
public class EditPostBB extends ConversationalPost{
    private static final long serialVersionUID = 10006297720999998L;

    public EditPostBB(){
        
    }
    
    @Override
    protected void execute() {
        TextPost p = (TextPost)blog.getPostArchive().find(getId());
        TextPost tp = new TextPost(p, getValue());
        blog.getPostArchive().update(tp);
    }
    
}
