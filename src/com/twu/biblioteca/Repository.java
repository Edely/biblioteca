package com.twu.biblioteca;

import java.util.ArrayList;

public class Repository {

    private ArrayList<Book> AllBooks = new ArrayList<Book>();
    private ArrayList<Book> CheckedBooks = new ArrayList<Book>();

    public Repository(){
        createListOfBooks();
    }

    private void createListOfBooks(){
        AllBooks.add(new Book("I, Robots", "Isaac Asimov", 1950));
        AllBooks.add(new Book("Do Androids Dream of Electric Sheep?", "Philip K. Dick", 1974));
        AllBooks.add(new Book("The Odyssey", "Homer", -800));
        AllBooks.add(new Book("Romeo and Juliet", "Shakespeare", 1595));
    }



    public ArrayList<Book> getAllBooks() {
        return AllBooks;
    }
}
