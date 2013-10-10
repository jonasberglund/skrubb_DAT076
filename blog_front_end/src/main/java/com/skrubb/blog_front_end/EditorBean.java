/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.TextPost;
import static com.skrubb.blog_front_end.DummyDB.a1;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Anders
 */
@ManagedBean(name="editorBean")
@SessionScoped
public class EditorBean {
    
    private String value;  
  
    public String getValue() {  
        return value;  
    }  
  
    public void setValue(String value) {  
        this.value = value;  
        
    } 
    public void textPost(){
    
        DummyDB.listOfPost.add(new TextPost(DummyDB.a1, null, "titel1", null, getValue()));
    } 
 }
