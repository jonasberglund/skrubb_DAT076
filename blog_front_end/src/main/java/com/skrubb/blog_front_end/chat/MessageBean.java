package com.skrubb.blog_front_end.chat;
import java.io.Serializable;
import java.util.LinkedList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * Holds a List of chat messages and is accessible to all users of the chat.
 * @author Anders Johansson, Jonas Berglund
 */
@Named("messageBean")
@ApplicationScoped
public class MessageBean implements Serializable {
    private static final long serialVersionUID = 10011297720999998L;
    
    Boolean authorPresent=false;
    
    private static final int MAX_SIZE = 25;
    private LinkedList<TextModel> list = new LinkedList<TextModel>();

    public MessageBean() {
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
