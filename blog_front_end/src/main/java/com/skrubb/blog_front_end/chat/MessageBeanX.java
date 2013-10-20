package com.skrubb.blog_front_end.chat;
import java.io.Serializable;
import java.util.LinkedList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Anders
 */
@Named("messageBeanX")
@ApplicationScoped
public class MessageBeanX implements Serializable {

    Boolean authorPresent=false;
    
    private static final int MAX_SIZE = 25;
    private LinkedList<TextModel> list = new LinkedList<TextModel>();

    public MessageBeanX() {
    }

    public LinkedList<TextModel> getList() {
        return list;
    }
    public void setAuthorPresent(){
        this.authorPresent=true;
    }

    public void setList(LinkedList<TextModel> list) {
        this.list = list;
    }
    public void addToList(String text, String name) {
        if(!authorPresent){
            list.addFirst(new TextModel("There is no author present in the chat, the chat will start when an author has logged in", "BLOGGMESSAGE: "));
        }
        else{
            list.addFirst(new TextModel(text, name));
        }
        if (list.size() > MAX_SIZE) {
            list.removeLast();
        }
    }
    
}
