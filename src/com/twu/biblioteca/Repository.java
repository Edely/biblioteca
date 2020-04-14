package com.twu.biblioteca;

import java.util.ArrayList;

public class Repository {

    private ArrayList<Book> ListaDeLivros = new ArrayList<Book>();

    public Repository(){
        createListOfBooks();
    }

    private void createListOfBooks(){
        ListaDeLivros.add(new Book("I, Robots", "Isaac Asimov", 1950));
        ListaDeLivros.add(new Book("Do Androids Dream of Electric Sheep?", "Philip K. Dick", 1974));
        ListaDeLivros.add(new Book("The Odyssey", "Homer", -800));
    }

    public ArrayList<Book> getListOfBooks() {
        return ListaDeLivros;
    }
}
