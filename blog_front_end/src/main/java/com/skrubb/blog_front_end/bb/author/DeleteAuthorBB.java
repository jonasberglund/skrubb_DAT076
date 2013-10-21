/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end.bb.author;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

/**
 * Delete a Author from database
 * @author jonasberglund, Anders Johansson
 */
@Named("delAuthor")
@ConversationScoped
public class DeleteAuthorBB extends ConversationalAuthor{
    
    private static final long serialVersionUID = 100562111208890438L;
   
    public DeleteAuthorBB(){
    
    }
    
    @Override
    protected void execute() {
        blog.getAuthorRegistry().remove(getId());
    }
    
}
