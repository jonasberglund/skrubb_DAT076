/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.Comment;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

/**
 *
 * @author jonasberglund
 */
@Named("addComment")
@ConversationScoped
public class AddCommentBB extends ConversationalPost {

    public AddCommentBB(){
        
    }
    
    @Override
    protected void execute() {        
        Long id = getId();
        
       //Comment comment = new Comment(co , comm);
        //blog.getPostArchive().addComment(Long.valueOf(552), comment);
    }
    
    public String execute(Long id){
        //Comment comment = new Comment(getCommenter() , getComment()[0]);
        //blog.getPostArchive().addComment(id, comment);
        return "welcome";
    }
    
    public String execute(Long id, int i){
        //Comment comment = new Comment(getCommenter()[0] , getComment()[0]);
        int a = i;
        Comment comment = new Comment("Robin the bos" , getComment().get(id));
        blog.getPostArchive().addComment(id, comment);
        return "welcome";
    }
}
