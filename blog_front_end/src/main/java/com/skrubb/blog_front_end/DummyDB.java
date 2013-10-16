/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

import com.skrubb.blog_back_end.core.Author;
import com.skrubb.blog_back_end.core.Post;
import com.skrubb.blog_back_end.core.TextPost;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Anders
 */

@ManagedBean
@SessionScoped
public class DummyDB {
     
    public static final String[] dbPosts = {"FC Barcelona is one of only three clubs never to have been relegated from La Liga and is the most successful club in Spanish football along with Real Madrid, having won twenty La Liga titles, a record twenty-five Spanish Cups, eight Spanish Super Cups, four Eva Duarte Cups and two League Cups. They are also one of the most successful clubs in European football having won fourteen official major trophies in total, including ten UEFA competitions. They have won three UEFA Champions League titles, a record four UEFA Cup Winners' Cups, a record three InterCities Fairs Cups (the forerunner to the UEFA Europa League), three UEFA Super Cups and one FIFA Club World Cup. The club is also the only European side to have played continental football in every season since its inception in 1955.","FC Barcelona is one of only three clubs never to have been relegated from La Liga and is the most successful club in Spanish football along with Real Madrid, having won twenty La Liga titles, a record twenty-five Spanish Cups, eight Spanish Super Cups, four Eva Duarte Cups and two League Cups. They are also one of the most successful clubs in European football having won fourteen official major trophies in total, including ten UEFA competitions. They have won three UEFA Champions League titles, a record four UEFA Cup Winners' Cups, a record three InterCities Fairs Cups (the forerunner to the UEFA Europa League), three UEFA Super Cups and one FIFA Club World Cup. The club is also the only European side to have played continental football in every season since its inception in 1955."};
    public static ArrayList<Post> listOfPost =new ArrayList<Post>();
    
    
    public static Author a1=new Author(Long.valueOf("1"),"anders","1", Author.AccessLevel.ADMIN);
    public static Author a2=new Author(Long.valueOf("2"),"jonas","2", Author.AccessLevel.ADMIN);
    public static Author a3=new Author(Long.valueOf("3"),"Sara","3", Author.AccessLevel.AUTHOR);
    public static ArrayList<Author> authors = new ArrayList<Author>() {{
      add(a1);
      add(a2);
      add(a3);
    }};
    public static Post[] postList={new TextPost(a1, null, "titel1", null, "långtext"),new TextPost(a1, null, "titel2", null, "FC Barcelona is one of only three clubs never to have been relegated from La Liga and is the most successful club in Spanish football along with Real Madrid, having won twenty La Liga titles, a record twenty-five Spanish Cups, eight Spanish Super Cups, four Eva Duarte Cups and two League Cups. They are also one of the most successful clubs in European football having won fourteen official major trophies in total, including ten UEFA competitions. They have won three UEFA Champions League titles, a record four UEFA Cup Winners' Cups, a record three InterCities Fairs Cups (the forerunner to the UEFA Europa League), three UEFA Super Cups and one FIFA Club World Cup. The club is also the only European side to have played continental football in every season since its inception in 1955.")};
    
    public DummyDB(){
    
       //loadPost();
       Author a1=new Author("anders","1", Author.AccessLevel.ADMIN);
  
       TextPost tp1=new TextPost(a1, null, "titel1", null, "långtext");
       TextPost tp2=new TextPost(a1, null, "titel1", null, "långtext");
       TextPost tp3=new TextPost(a1, null, "titel1", null, "långtext");
       TextPost tp4=new TextPost(a1, null, "titel1", null, "långtext");

     
    }
    
    public void loadPost()
{
    //listOfPost = 
    listOfPost.add(new TextPost(a1, null, "titel1", null, "långtext"));
    listOfPost.add(new TextPost(a1, null, "titel2", null, "långtext2"));
}
    
    
    public void addPost(String text)
    {
        listOfPost.add(new TextPost(a1, null, "titel1", null, text));
    }
   
    public String[] getposts(){
    
        return dbPosts;
    }
    
    public Post[] getPost(){
    
        return postList;
    }
    public ArrayList<Post> getArrayListOfPost(){
    
        return listOfPost;
    }
    
    public void delPost(Post post){
        
        Iterator<Post> it=DummyDB.listOfPost.iterator();
        while(it.hasNext())
        {
        if(it.next().getId()==post.getId())
            it.remove();
        }
        
        
    }
    
    public ArrayList<Author> getAuthors(){
        return authors;
    }
    
    
    
}