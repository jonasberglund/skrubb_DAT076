/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end.bb.author;

import com.skrubb.blog_back_end.core.Author;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author jonasberglund
 */
@Named("editAuthor")
@ConversationScoped
public class EditAuthorBB extends ConversationalAuthor{
    
    private static final long serialVersionUID = 100560987208890438L;
    
    private String oldPassword;
    private String newPassword;
    
    public EditAuthorBB() {
    
    }
    
    @Override
    protected void execute() {
        
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
                return navigationBean.toEditAuthor();
                
            }
        }
        
        Author authorUpdated = new Author(getId(),getName(), getPassword(), getAL(), updatedPassword);
        blog.getAuthorRegistry().update(authorUpdated);
        
        destroy();
        
        return navigationBean.toAuthors();
    }
    
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
    
}
