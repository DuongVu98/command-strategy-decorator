package com.tma.models;

public class Book {
    private String id;
    private String title;
    private String author;
    private String gerne;

    public Book(String id, String title, String author, String gerne) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.gerne = gerne;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGerne() {
        return gerne;
    }

    public void setGerne(String gerne) {
        this.gerne = gerne;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", gerne='" + gerne + '\'' +
                '}';
    }
}
