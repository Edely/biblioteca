package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Biblioteca{

    Repository BooksRepository = new Repository();
    protected void ShowMenu(){

        Map<Integer, String> Menu = new HashMap<Integer, String>();
        Menu.put(0, "Quit");
        Menu.put(1, "Print Books");


        while(true){
            ShowOptions(Menu);
            int choice = ReadInput(Menu);
            ExecMenu(choice);
        }
    }

    private static void ShowOptions(Map Menu){
        System.out.println("What would you like to do?");
        Menu.forEach((key, value)->{
            System.out.printf( "%-5s | %-10s %n", key, value);
        });
    }

    private void ExecMenu(int choice){
        switch (choice){
            case(0):
                LeaveLibrary();
                break;
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
            }else{
                System.out.println("Please select a valid option!");
            }
        }catch(Exception e){
            System.out.println("Please select a valid option!");
        }
        System.out.println();
        return -1;
    }

    private static void LeaveLibrary(){
        System.exit(0);
    }


    protected void Greetings(){
        System.out.println("Welcome to Biblioteca. You one-stop-shop for great book titles in Brazil.");
    }

    private void PrintBooks(){
        System.out.println("These are our available books right now:\n");
        for (Book book: BooksRepository.getAllBooks()) {
            System.out.printf( "%-40s | %10s | %15s %n", book.getName(), book.getYearFormatted(), book.getAuthor());
        }
        System.out.println();
    }

    protected boolean CheckoutBook(){
        return true;
    }

}
