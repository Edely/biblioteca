package com.twu.biblioteca.system;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Repository;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    private Repository repository;

    public Menu(Repository repository){
        this.repository = repository;
    }
    public void ShowMenu(){

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
            int choice = Biblioteca.ReadInput(Menu);

            switch (choice){
                case(0):
                    Biblioteca.LeaveLibrary();
                    break;
                case(1):
                    Biblioteca.ListAvailableBooks();
                    break;
                case(2):
                    Biblioteca.CheckoutBook();
                    break;
                case(3):
                    Biblioteca.ReturnBook();
                    break;
                default:
                    break;
            }
        }
    }
}
