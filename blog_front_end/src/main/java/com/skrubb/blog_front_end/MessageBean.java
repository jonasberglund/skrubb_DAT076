/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Anders
 */
@Named("messageBean")
@ApplicationScoped
public class MessageBean implements Serializable{
    
    private static final int MAX_SIZE= 5;
    private LinkedList<MessageModel> messageList = new LinkedList<MessageModel>();
   
    
    public MessageBean(){
    }
    
    public MessageBean(LinkedList<MessageModel>messageList){
        this.messageList=messageList;
    }
    
    public LinkedList<MessageModel> getMessageList(){
         return messageList;
    }
    public void setMessageList(LinkedList<MessageModel> messageList){
        this.messageList=messageList;
    }
    public void addToList(String message,String name){
        messageList.addLast(makeMessageModel(message,name));
        if(messageList.size()>MAX_SIZE){
            messageList.removeFirst();           
        }
    }
    private MessageModel makeMessageModel(String message, String name){
        return new MessageModel(message, name);
    }
}
