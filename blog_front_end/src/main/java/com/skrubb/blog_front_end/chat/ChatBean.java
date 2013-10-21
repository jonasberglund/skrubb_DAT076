package com.skrubb.blog_front_end.chat;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.icefaces.application.PushRenderer;
import com.skrubb.blog_front_end.mb.LoginBean;

/* 
 * Register user to a chat session, uses push via AJAX to inform all users in chat of new message
 *@Author Anders Johansson, Jonas Berglund
 */
@Named("chatBean")
@RequestScoped
public class ChatBean implements Serializable {
    private static final long serialVersionUID = 13456797720999998L;

    private static final String PUSH_GROUP = "skruBBBloggen";
    @Inject
    private MessageBean messageBean;
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

    public void setMessageBean(MessageBean messageBean) {
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
