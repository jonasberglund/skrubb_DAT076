/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end;

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
    
   
    public String[] getpost(){
    
        return dbPosts;
    }
    
}
