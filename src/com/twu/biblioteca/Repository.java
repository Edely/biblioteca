package com.twu.biblioteca;

import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Repository {

    private ArrayList<Book> AllBooks = new ArrayList<Book>();
    private ArrayList<Book> CheckedBooks = new ArrayList<Book>();

    public Repository(){
        createListOfBooks();
    }

    private void createListOfBooks(){
        AllBooks.add(new Book("I, Robot", "Isaac Asimov", 1950));
        AllBooks.add(new Book("Do Androids Dream of Electric Sheep?", "Philip K. Dick", 1974));
        AllBooks.add(new Book("The Odyssey", "Homer", -800));
        AllBooks.add(new Book("Romeo and Juliet", "Shakespeare", 1595));
    }

    public ArrayList<Book> getAllBooks() {
        return AllBooks;
    }

    protected void ListAvailableBooks(){
        System.out.println("These are our available books right now:\n");
        for (Book book: getAllBooks()) {
            System.out.printf( "%-40s | %10s | %15s %n", book.getName(), book.getYearFormatted(), book.getAuthor());
        }
        System.out.println();
    }

    protected void CheckoutBook(){
        System.out.println("Insert the name of the book:");
        Scanner in = new Scanner(System.in);
        Book bk = IsBookAvailable(in.nextLine());
        if(bk != null) {
            ProcessBook(bk);
        }
    }

    protected boolean ProcessBook(Book bk){
        String BookName = bk.getName();
        Book bkReturned = IsBookAvailable(BookName);
        if(bkReturned == null){
            return false;
        }
        CheckedBooks.add(bkReturned);
        AllBooks.remove(bkReturned);
        return true;
    }

    public Book IsBookAvailable(String BookName){
        for (Book book: getAllBooks()) {
            if(Objects.equals(book.getName(), BookName)) {
                return book;
            }
        }
        return null;
    }
}
