package com.example.ehill.musicalstructureapp;

public class Audiobook {
    private String bTitle;
    private String bAuthor;
    private int coverImage;
    private String bookLength;

    public Audiobook(String title, String author, int cover, String duration) {
        bTitle = title;
        bAuthor = author;
        coverImage = cover;
        bookLength = duration;
    }

    public String getTitle() {
        return bTitle;
    }


    public String getAuthor() {
        return bAuthor;
    }

    public int getImageResourceId() {
        return coverImage;
    }

    public String getDuration() {
        return bookLength;
    }

}
