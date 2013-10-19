/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import javax.enterprise.context.Conversation;
import javax.inject.Inject;

/**
 *
 * @author jonasberglund
 */
public abstract class ConversationalBase {
    
    protected Blog blog;
    
    @Inject
    protected NavigationBean navigationBean;
    
    @Inject
    protected Conversation conversation;
    
    @Inject
    public void Blog(Blog blog)
    {
        this.blog=blog;
    }
    
        // Implemented by subclasses
    protected abstract void execute();
}
