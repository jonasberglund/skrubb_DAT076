package com.skrubb.blog_front_end.bb.author;

import com.skrubb.blog_front_end.bb.ConversationalBase;
import com.skrubb.blog_back_end.core.Author;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Common code for delete and edit (which uses conversational scope) 
 * @author anders
 */
public abstract class ConversationalAuthor extends ConversationalBase implements Serializable {

    private Long id;
    
    @NotNull(message="{common.notEmpty}")
    @Size(min=4, max=20, message="{user.name}")
    private String name;
    
    @NotNull(message="{common.notEmpty}")
    @Size(min=4, max=20, message="{user.password}")
    private String password;
    
    @NotNull(message="{common.notEmpty}")
    private Author.AccessLevel al;

    public ConversationalAuthor(){
    
    }
        
    public void setSelected(Long id) {
        Logger.getAnonymousLogger().log(Level.INFO, "setSelected id={0}", id);
        if (conversation.isTransient()) {
            conversation.begin();
        }
                
        Author a = blog.getAuthorRegistry().find(id);
        this.id = a.getId();
        this.name = a.getName();
        this.password = a.getHashedPassword();
        this.al = a.getAccessLevel();

    }

    @PreDestroy  // Must have for back button etc.
    public void destroy() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }

    public String actOnSelected() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
        execute();
        return navigationBean.toAuthors();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
   public Author.AccessLevel getAL() {
        return al;
    }

    public void setAL(Author.AccessLevel al) {
        this.al = al;
    }
}
