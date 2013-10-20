/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end.bb;

import com.skrubb.blog_front_end.mb.Blog;
import com.skrubb.blog_front_end.mb.NavigationBean;
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
    
    protected abstract void execute();
}
