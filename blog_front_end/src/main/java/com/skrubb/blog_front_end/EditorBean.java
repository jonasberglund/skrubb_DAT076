/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.TextPost;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Anders
 */
@ManagedBean(name="editorBean")
@SessionScoped
//@Named("delProduct")
//@ConversationScoped
public class EditorBean {
    
    private String value;
    private String title;
  
    public String getValue() {  
        return value;  
    }  
  
    public void setValue(String value) {  
        this.value = value;  
        
    }
    public String getTitle() {  
        return title;  
    }  
  
    public void setTitle(String title) {  
        this.title = title;  
        
    }
    public void textPost(){
    
        DummyDB.listOfPost.add(new TextPost(DummyDB.a1, null, getTitle(), null, getValue()));
    }
    public void textClear(){
    
        this.value="";
    }
 }
