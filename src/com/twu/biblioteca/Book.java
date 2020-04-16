package com.twu.biblioteca;

public class Book {

    private String Name;
    private int Year;
    private String Author;
    private boolean Availabel;

    public Book(String BookName, String BookAuthor, int BookYear){
        Name =      BookName;
        Year =      BookYear;
        Author =    BookAuthor;
    }

    public String getName(){
        return Name;
    }

    public int getYear() {
        return Year;
    }

    public String getYearFormatted() {
        if(Year < 0){
            return "BC " + String.valueOf(Math.abs(Year));
        }else if(Year > 0){
            return "AD " + String.valueOf(Math.abs(Year));
        }

        return "AD 1";
    }

    public String getAuthor() {
        return Author;
    }
}
