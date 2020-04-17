package com.twu.biblioteca;
import sun.lwawt.macosx.CSystemTray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

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

    public void ListAvailableBooks() {
        System.out.println("These are our available books right now:\n");
        for (Book book : getAllBooks()) {
            System.out.printf("%-40s | %10s | %15s %n", book.getName(), book.getYearFormatted(), book.getAuthor());
        }
        System.out.println();
    }

    public boolean CheckoutBook(){

        Book BookToCheck = readInput(AllBooks);
        if (BookToCheck == null) {
            System.out.println("Sorry, that book is not available.\n");
            return false;
        }
        CheckedBooks.add(BookToCheck);
        AllBooks.remove(BookToCheck);
        System.out.println("Thank You! Enjoy the book.\n");

        return  true;
    }

    public boolean ReturnBook(){
        Book BookToReturn = readInput(CheckedBooks);
        if (BookToReturn == null) {
            System.out.println("That is not a valid book to return.\n");
            return false;
        }
        AllBooks.add(BookToReturn);
        CheckedBooks.remove(BookToReturn);

        System.out.println("Thank You! Enjoy the book.\n");

        return true;
    }

    private Book readInput(ArrayList<Book> checkedBooks) {
        System.out.println("Insert the name of the book:");
        Scanner in = new Scanner(System.in);
        String BookName = in.nextLine();
        return GetBook(BookName, checkedBooks);
    }

    public Book GetBook(String BookName, ArrayList<Book> ListOfBooks) {
        for (Book book : ListOfBooks) {
            if (Objects.equals(book.getName(), BookName)) {
                return book;
            }
        }
        return null;
    }

}