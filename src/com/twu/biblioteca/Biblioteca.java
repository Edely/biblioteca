package com.twu.biblioteca;

import java.util.Vector;
import java.util.ArrayList;

public class Biblioteca{

    static Repository BooksRepository = new Repository();
    static  ArrayList<Vector> Options = new ArrayList<>();
    private static Menu MeuMenu = new Menu();

    private static void ShowMenu(){
       int option = MeuMenu.askOption();
       while(option != -1){
           option = MeuMenu.askOption();
       }
    }

    private static void addOptions(){
        MeuMenu.setOption(createOption("Show List Of Books", "PrintBooks", 0));
        MeuMenu.setOption(createOption("Quit", "LeaveLibrary", -1));
    }

    private static void LeaveLibrary(){
        System.exit(0);
    }

    private static Vector createOption(String Message, String Method, int Key ){
        Vector v = new Vector();
        v.add(Message);
        v.add(Method);
        v.add(Key);
        return v;
    }

    public static void main(String[] args) {
        addOptions();
        Greetings();
        ShowMenu();
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
