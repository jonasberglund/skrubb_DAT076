/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.Author;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jonasberglund
 */
//@Named("editAuthor")
//@ConversationScoped
@ManagedBean(name="editAuthor") 
public class EditAuthorBB extends ConversationalBase{
     
    
    @Override
    protected void execute() {
        //DummyDB.authors.remove(this);
        Author a = new Author(Long.getLong("4"),getName(), getPassword(), getAL());
        DummyDB.authors.add(a);
    }
    
}
