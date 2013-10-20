/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import java.io.Serializable;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Anders
 */
@Named("con_Reader")
@ConversationScoped
public class ConversationalReader extends ConversationalBase implements Serializable{
    
    private String name;
    
    public ConversationalReader(){}
    
    @Inject
    LoginBean loginBean;
    
    @Override
    protected void execute(){
          
    }
    public void actSelected() {
       
        if (conversation.isTransient()) {
            conversation.begin();
        }
        
        
        
    }
    public void actSelectedAuth() {
       
        if (conversation.isTransient()) {
            conversation.begin();
        }
        this.name=loginBean.getUsername();
        
        
    }

    @PreDestroy  // Must have for back button etc.
    public void destroy() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }

    public void setLoginBean(LoginBean loginBean){
        this.loginBean=loginBean;
    }
    
    public String getName(){
    
        return name;        
    }
    public void setName(String name)
    {
        this.name=name;
    }
}
