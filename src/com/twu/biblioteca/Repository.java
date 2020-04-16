package com.twu.biblioteca;
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
        AllBooks.add(new Book("I, Robot", "Isaac Asimov", 1950));
        AllBooks.add(new Book("Do Androids Dream of Electric Sheep?", "Philip K. Dick", 1974));
        AllBooks.add(new Book("The Odyssey", "Homer", -800));
        AllBooks.add(new Book("Romeo and Juliet", "Shakespeare", 1595));
    }

    public ArrayList<Book> getAllBooks() {
        return AllBooks;
    }

    public ArrayList<Book> getCheckedBooks() {
        return CheckedBooks;
    }

    protected void ListAvailableBooks() {
        System.out.println("These are our available books right now:\n");
        for (Book book : getAllBooks()) {
            System.out.printf("%-40s | %10s | %15s %n", book.getName(), book.getYearFormatted(), book.getAuthor());
        }
        System.out.println();
    }

    protected boolean CheckoutBook(){

        System.out.println("Insert the name of the book:");
        Scanner in = new Scanner(System.in);
        String BookName = in.nextLine();

        Book BookToCheck = GetBook(BookName, AllBooks);
        if (BookToCheck == null) {
            System.out.println("Sorry, that book is not available.\n");
            return false;
        }
        CheckedBooks.add(BookToCheck);
        AllBooks.remove(BookToCheck);
        System.out.println("Thank You! Enjoy the book.\n");

        return  true;
    }

    protected boolean ReturnBook(){
        System.out.println("Insert the name of the book:");
        Scanner in = new Scanner(System.in);
        String BookName = in.nextLine();
        Book BookToReturn = GetBook(BookName, CheckedBooks);
        if (BookToReturn == null) {
            System.out.println("That is not a valid book to return.\n");
            return false;
        }
        AllBooks.add(BookToReturn);
        CheckedBooks.remove(BookToReturn);

        System.out.println("Thank You! Enjoy the book.\n");

        return true;
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