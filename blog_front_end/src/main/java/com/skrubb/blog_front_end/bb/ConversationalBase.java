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
 * Main class for all conversational classes. Common code for all clases which uses conversationalBase)
 * @author jonasberglund, Anders Johansson
 */
public abstract class ConversationalBase {
    
    @Inject
    protected Blog blog;
    
    @Inject
    protected NavigationBean navigationBean;
    
    @Inject
    protected Conversation conversation;
    
    protected abstract void execute();
}
