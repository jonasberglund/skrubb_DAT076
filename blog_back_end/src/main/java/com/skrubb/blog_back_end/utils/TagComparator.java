/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_back_end.utils;

import com.skrubb.blog_back_end.core.Tag;
import java.util.Comparator;

/**
 *
 * @author root
 */
public class TagComparator implements Comparator<Tag> {

    public int compare(Tag t1, Tag t2) {
        return t1.getValue().compareTo(t2.getValue());
    }
    
}
