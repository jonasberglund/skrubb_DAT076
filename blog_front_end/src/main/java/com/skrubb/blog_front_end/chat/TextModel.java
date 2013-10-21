package com.skrubb.blog_front_end.chat;

import java.io.Serializable;
/**
 *
 * @author Anders Johansson, Jonas Berglund
 */
public class TextModel implements Serializable {
    private static final long serialVersionUID = 90056297720999998L;

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
