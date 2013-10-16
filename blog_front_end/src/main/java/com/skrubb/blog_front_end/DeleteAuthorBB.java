/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.Author;
import java.util.Iterator;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jonasberglund
 */
@Named("delAuthor")
@ConversationScoped
public class DeleteAuthorBB extends ConversationalBase{
   
    public DeleteAuthorBB(){
    
    }
    
    @Override
    protected void execute() {
        
        Long idtoRemove=getId();
        Iterator<Author> it=DummyDB.authors.iterator();
        while(it.hasNext())
        {
        if(it.next().getId()==idtoRemove)
            it.remove();
        }
        
    }
    
}
