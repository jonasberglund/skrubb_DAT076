/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.Author;
import com.skrubb.blog_back_end.core.Author.AccessLevel;
import java.util.Iterator;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hajo
 */
@Named("addAuthor")
@ConversationScoped
public class AddAuthorBB extends ConversationalBase {
    
    public AddAuthorBB(){
    
    }

    
    @Override
    protected void execute() {
        
        
        Author autherUpdated = new Author(Long.valueOf("5"),getName(), getPassword(), getAL());
        DummyDB.authors.add(autherUpdated);
        
    }
    
}