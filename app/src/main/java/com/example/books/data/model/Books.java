package com.example.books.data.model;

import java.io.Serializable;

public class Books implements Serializable {
    private String name;
    private String author;
    private String desc;

    public Books(String name, String author, String desc) {
        this.name = name;
        this.author = author;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
