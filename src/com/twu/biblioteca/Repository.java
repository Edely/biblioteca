package com.twu.biblioteca;

import java.util.ArrayList;

public class Repository {
    private ArrayList<Book> ListaDeLivros = new ArrayList<Book>();
    String[] Names = {"Robots", "The Roman Republic", "Purr-Fect Crime"};

    public Repository(){
        createListOfBooks();
    }

    private void createListOfBooks(){

        for (String name: Names) {
            Book b = new Book(name);
            ListaDeLivros.add(b);
        }
    }

    public ArrayList<Book> getListOfBooks() {
        return ListaDeLivros;
    }
}
