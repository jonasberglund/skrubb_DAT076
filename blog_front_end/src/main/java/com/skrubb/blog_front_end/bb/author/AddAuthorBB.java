/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end.bb.author;

import com.skrubb.blog_back_end.core.Author;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

/**
 * @author anders, jonasberglund
 */
@Named("addAuthor")
@ConversationScoped
public class AddAuthorBB extends ConversationalAuthor {
    
    private static final long serialVersionUID = 100562977263890438L;
        
    public AddAuthorBB(){
    
    }
   
    @Override
    protected void execute() {
        Author autherUpdated = new Author(getName(), getPassword(), getAL());
        blog.getAuthorRegistry().add(autherUpdated); 
    }
}
