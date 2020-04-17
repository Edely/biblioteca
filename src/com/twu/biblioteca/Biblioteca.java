package com.twu.biblioteca;

import com.sun.tools.javac.comp.Check;
import com.twu.biblioteca.system.Menu;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Biblioteca {

    private static ArrayList<Book> AllBooks;
    private static ArrayList<Book> CheckedBooks;

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. You one-stop-shop for great book titles in Brazil.\n");
        Repository repository = new Repository();

        AllBooks = repository.getAllBooks();
        CheckedBooks = repository.getCheckedBooks();

        Menu menu = new Menu(repository);
        menu.ShowMenu();
    }

    public static void LeaveLibrary(){
        System.exit(0);
    }

    public static int ReadInput(Map<Integer, String> Menu){
        Scanner in = new Scanner(System.in);
        try {
            int option = in.nextInt();
            if(Menu.containsKey(option)){
                return option;
            }else{
                System.out.println("Please select a valid option!\n");
            }
        }catch(Exception e){
            System.out.println("Please select a valid option!\n");
        }
        return -1;
    }

    public static boolean CheckoutBook(){

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

    public static boolean ReturnBook(){
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

    private static Book readInput(ArrayList<Book> checkedBooks){
        System.out.println("Insert the name of the book:");
        Scanner in = new Scanner(System.in);
        String BookName = in.nextLine();
        return GetBook(BookName, checkedBooks);
    }

    public static Book GetBook(String BookName, ArrayList<Book> ListOfBooks){
        for (Book book : ListOfBooks) {
            if (Objects.equals(book.getName(), BookName)) {
                return book;
            }
        }
        return null;
    }

    public static void ListAvailableBooks() {
        System.out.println("These are our available books right now:\n");
        for (Book book : AllBooks) {
            System.out.printf("%-40s | %10s | %15s %n", book.getName(), book.getYearFormatted(), book.getAuthor());
        }
        System.out.println();
    }
}

