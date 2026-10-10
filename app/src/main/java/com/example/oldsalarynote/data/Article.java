package com.example.oldsalarynote.data;
public class Article {
    public final long id;
    public final String title;
    public final String summary;

    public Article(long id, String title, String summary) {
        this.id = id;
        this.title = title;
        this.summary = summary;
    }
}