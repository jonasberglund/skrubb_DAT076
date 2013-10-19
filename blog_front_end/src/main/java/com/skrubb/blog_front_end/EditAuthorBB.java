/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.Author;
import java.util.Iterator;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jonasberglund
 */
@Named("editAuthor")
@ConversationScoped
public class EditAuthorBB extends ConversationalAuthor{
    
    private String oldPassword;
    private String newPassword;
    
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
    public String getOldPassword() {
        return oldPassword;
    }
    
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    public String getNewPassword() {
        return newPassword;
    }
    
    public EditAuthorBB()
    {
    
    }
    public String updateAuthor() {
        
        boolean updatedPassword = false;
        
        if((newPassword != null && !newPassword.isEmpty()) ||
                (oldPassword != null && !oldPassword.isEmpty())){
            
            if(Author.generateHashedPassword(oldPassword).equals(getPassword())
                    && (newPassword != null && newPassword.length() > 3 && newPassword.length() < 21 )){
                setPassword(newPassword);
                updatedPassword = true;
            }
            else {
                //message
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Felaktigt lösenord", "Fyll i rätt"));
                return "edit_author";
                
            }
        }
        
        
        Author authorUpdated = new Author(getId(),getName(), getPassword(), getAL(), updatedPassword);
        blog.getAuthorRegistry().update(authorUpdated);
        return "manage_authors";
    }

    @Override
    protected void execute() {
        
    }
    
}
