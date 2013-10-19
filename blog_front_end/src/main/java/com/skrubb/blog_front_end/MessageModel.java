/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import java.io.Serializable;

/**
 *
 * @author Anders
 */
public class MessageModel implements Serializable {
    
    private String message;
    private String name;
    
    public MessageModel(){
    
    }
    public MessageModel(String message, String name)
    {
        this.message=message;
        this.name=name;
    }
    public void setMessage(String message){
        this.message=message;
    }
    public String getMessage(){    
        return message;
    }
    public String getName(){  
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    
    @Override
    public String toString(){
        
        //return "ChatMessage [user=" + name + ", message=" + message + "]";

        return message;
    }
}
