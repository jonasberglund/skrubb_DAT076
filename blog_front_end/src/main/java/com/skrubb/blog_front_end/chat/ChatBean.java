package com.skrubb.blog_front_end.chat;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.icefaces.application.PushRenderer;
import com.skrubb.blog_front_end.mb.LoginBean;

/*
 *@Author Anders
 */
@Named("chatBean")
@RequestScoped
public class ChatBean implements Serializable {

    private static final String PUSH_GROUP = "colorPage";
    @Inject
    private MessageBeanX messageBean;
    //private String color = "black";
    //private String sessionId;
    private String text;
    private String name;
    
    @Inject
    ConversationalReader con_read;
    
    @Inject
    LoginBean loginBean;
    
    @PostConstruct
    public void postConstruct(){
        PushRenderer.addCurrentSession(PUSH_GROUP);
    }

    public void setMessageBean(MessageBeanX messageBean) {
        this.messageBean = messageBean;
    }

    public String getConName(){
       return con_read.getName();
    }
     
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public String push() {
        if(loginBean.isLoggedIn())
            messageBean.setAuthorPresent();
        
        messageBean.addToList(text, con_read.getName());
        // Push to all in group
        PushRenderer.render(PUSH_GROUP);

        return null; // Navigation stay on same page
    } 
}
