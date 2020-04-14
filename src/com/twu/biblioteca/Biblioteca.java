package com.twu.biblioteca;

import com.sun.codemodel.internal.JCase;

import java.util.Scanner;

public class Biblioteca {

    static Repository BooksRepository = new Repository();
    private static  String[] MenuOptions = {"Print Books"};
    private static Scanner in = new Scanner(System.in);

    private static void ShowMenu(){
        int i = 0;

        System.out.println("What would you like to do?");

        for (String opt: MenuOptions){
            System.out.println(i + " " + opt);
            i++;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Greetings();
        ShowMenu();
        PrintBooks();
    }

    private static void Greetings(){
        System.out.println("Welcome to Biblioteca. You one-stop-shop for great book titles in Brazil.");
    }

    private static void PrintBooks(){
        System.out.println("These are our available books right now:\n");
        for (Book book: BooksRepository.getListOfBooks()) {
            System.out.printf( "%-40s | %10s | %15s %n", book.getName(), book.getYearFormatted(), book.getAuthor());
        }
    }

}
