/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end.bb;

import com.skrubb.blog_back_end.core.AbstractPost;
import com.skrubb.blog_front_end.mb.PostsBB;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Anders
 */
@Named("tag_con")
@ConversationScoped
public class ConversationalTag extends ConversationalBase implements Serializable{
    
    private static final long serialVersionUID = 100562977208890438L;
    
    private String tag;
    
    @Inject
    private PostsBB postsBB;
    
    public ConversationalTag(){
    }
    
    @Override
    protected void execute() {  
    }
    
    public void setSelected(String tag) {
        if (conversation.isTransient()) {
            conversation.begin();
        }
        
        this.tag=tag;
    }

    @PreDestroy  // Must have for back button etc.
    public void destroy() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }
    
    public String getTag() {
        return tag;        
    }
    
    public void setTag(String tag) {
        this.tag=tag;
    }
    
    public List<AbstractPost> getByTag() {
        return postsBB.getByTag(tag);
        
    }  
}
