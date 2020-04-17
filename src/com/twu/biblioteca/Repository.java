package com.twu.biblioteca;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Repository {

    private ArrayList<Book> AllBooks = new ArrayList<Book>();
    private ArrayList<Book> CheckedBooks = new ArrayList<Book>();

    public Repository() {
        createListOfBooks();
    }

    private void createListOfBooks() {

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("books.csv"));
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(";");
                AllBooks.add(new Book(data[0], data[1], Integer.parseInt(data[2])));
            }
            csvReader.close();
        } catch(IOException ie) {
            ie.printStackTrace();
        }
    }

    public ArrayList<Book> getAllBooks() {
        return AllBooks;
    }

    public ArrayList<Book> getCheckedBooks() {
        return CheckedBooks;
    }


}