package me.dreggcake.eggBooks.Logic;

import java.util.List;

public class BookData {

    private final String message;
    private final String title;
    private final String author;
    private final List<List<String>> pages;

    public BookData(String message, String title, String author, List<List<String>> pages) {
        this.message = message;
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getMessage() { return message; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public List<List<String>> getPages() { return pages; }
}