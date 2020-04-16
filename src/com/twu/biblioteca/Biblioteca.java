package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Biblioteca{

    static Repository BooksRepository = new Repository();
    private static void ShowMenu(){

        Map<Integer, String> Menu = new HashMap<Integer, String>();

        Menu.put(1, "Print Books");

        System.out.println("What would you like to do?");

        Menu.forEach((key, value)->{
            System.out.printf( "%-5s | %-10s %n", key, value);
        });

        int choice = ReadInput(Menu);
        if(choice != -1){
            ExecMenu(choice);
        }
    }

    private static void ExecMenu(int choice){
        switch (choice){
            case(1):
                PrintBooks();
                break;
            default:
                break;
        }
    }

    private static int ReadInput(Map<Integer, String> Menu){
        Scanner in = new Scanner(System.in);
        try {
            int option = in.nextInt();
            if(Menu.containsKey(option)){
                return option;
            }
        }catch(Exception e){
            System.out.println("Please select a valid option!");
        }
        return -1;
    }

    private static void LeaveLibrary(){
        System.exit(0);
    }

    public static void main(String[] args) {
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
