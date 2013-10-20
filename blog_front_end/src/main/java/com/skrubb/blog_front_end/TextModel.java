package com.skrubb.blog_front_end;

import java.io.Serializable;
/**
 *
 * @author Anders
 */
public class TextModel implements Serializable {

    private String text;
    private String name;

    public TextModel() {
    }

    public TextModel(String text, String name) {
        this.text = text;
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return text;
    }
}
