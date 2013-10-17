/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.Author;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

/**
 *
 * @author jonasberglund
 */
@Named("editAuthor")
@ConversationScoped
public class EditAuthorBB extends ConversationalAuthor{

    public EditAuthorBB()
    {
    
    }
    
    
    @Override
    protected void execute() {
       Author authorUpdated = new Author(getId(),getName(), getPassword(), getAL());
       blog.getAuthorRegistry().update(authorUpdated);
    }
    
}
