/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.Author;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jonasberglund
 */
@ManagedBean(name="delAuthor") 
public class DeleteAuthorBB extends ConversationalBase{
     
    
    @Override
    protected void execute() {
        Author a = new Author(getName(), getPassword(), getAL());
        DummyDB.authors.remove(getId());
    }
    
}
