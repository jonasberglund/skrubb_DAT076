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
@Named("editAuthor")
@ConversationScoped
//@ManagedBean(name="editAuthor") 
public class EditAuthorBB extends ConversationalBase{

    public EditAuthorBB()
    {
    
    }
    
    
    @Override
    protected void execute() {
        
        Long idtoEdit=getId();
        Iterator<Author> it=DummyDB.authors.iterator();
        while(it.hasNext())
        {
        if(it.next().getId()==idtoEdit)
            it.remove();
        }
        
            
        Author autherUpdated = new Author(getId(),getName(), getPassword(), getAL());
        DummyDB.authors.add(autherUpdated);
    }
    
}
