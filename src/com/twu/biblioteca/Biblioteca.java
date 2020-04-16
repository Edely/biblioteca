package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Biblioteca {

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. You one-stop-shop for great book titles in Brazil.\n");
        Repository Iat = new Repository();
        ShowMenu(Iat);
    }

    private static void LeaveLibrary(){
        System.exit(0);
    }

    protected static void ShowMenu(Repository Repo){

        Map<Integer, String> Menu = new HashMap<Integer, String>();
        Menu.put(0, "Quit");
        Menu.put(1, "List Available Books");
        Menu.put(2, "Checkout a Book");
        Menu.put(3, "Return a Book");

        while(true){
            System.out.println("What would you like to do?");
            Menu.forEach((key, value)->{
                System.out.printf( "%-5s | %-10s %n", key, value);
            });
            int choice = ReadInput(Menu);

            switch (choice){
                case(0):
                    LeaveLibrary();
                    break;
                case(1):
                    Repo.ListAvailableBooks();
                    break;
                case(2):
                    Repo.CheckoutBook();
                    break;
                case(3):
                    Repo.ReturnBook();
                    break;
                default:
                    break;
            }
        }
    }


    private static int ReadInput(Map<Integer, String> Menu){
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

}

