package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.Author;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Common code for delete and edit (which uses conversational scope) 
 * @author hajo
 */
public abstract class ConversationalBase implements Serializable {

    private Long id;
    
    @NotNull(message="{common.notEmpty}")
    @Size(min=4, max=20, message="{user.name}")
    private String name;
    
    @NotNull(message="{common.notEmpty}")
    @Size(min=4, max=20, message="{user.password}")
    private String password;
    
    @NotNull(message="{common.notEmpty}")
    private Author.AccessLevel al;
    
    protected Blog blog;
    
    @Inject
    public void Blog(Blog blog)
    {
        this.blog=blog;
    }
    
    @Inject
    private Conversation conversation;

    public ConversationalBase(){
    
    }
        
    public void setSelected(Long id) {
        Logger.getAnonymousLogger().log(Level.INFO, "setSelected id={0}", id);
        if (conversation.isTransient()) {
            conversation.begin();
        }
        
       
                
       
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
        return "manage_authors";
    }

    // Implemented by subclasses
    protected abstract void execute();

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
