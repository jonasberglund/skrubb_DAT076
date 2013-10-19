/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;

import org.icefaces.application.PushRenderer;

/**
 *
 * @author Anders
 */
@Named("chatBean")
@RequestScoped
public class ChatBean implements Serializable{
    
    private static String PUSH_GROUP= "SkruBBBloggen";
    @Inject
    private MessageBean messageBean;
    
    private String message;
    private String name;
    @Inject
    private LoginBean loginBean;
    
    public ChatBean(){
    
    }
    
    
    @PostConstruct
    public void postConstruct(){
        PushRenderer.addCurrentSession(PUSH_GROUP);        
    }
    
    public void setMessageBean(MessageBean messageBean) {
        this.messageBean = messageBean;
    }
    
    public MessageBean getMessageBean(){
        return messageBean;
    }
    
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message=message;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
         
    public String pushAuthor(){
        String aName=loginBean.getUsername();
        messageBean.addToList(message,aName);
        //push to all
        PushRenderer.render(PUSH_GROUP);
        return null;
    }
    
    public String push(){
        messageBean.addToList(message,name);
        //push to all
        PushRenderer.render(PUSH_GROUP);
        return null;
    }
    
    
}
