package com.twu.biblioteca.system;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Repository;
import com.twu.biblioteca.Book;

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
            System.out.println("What would you like to do?\n");
            Menu.forEach((key, value)->{
                System.out.printf( "%-5s | %-10s %n", key, value);
            });
            int choice = Biblioteca.ReadOptions(Menu);

            switch (choice){
                case(0):
                    Biblioteca.LeaveLibrary();
                    break;
                case(1):
                    Biblioteca.ListAvailableBooks();
                    break;
                case(2):
                    Book BookToCheck = Biblioteca.ReadBookName(repository.GetAllBooks());
                    Biblioteca.CheckoutBook(BookToCheck, repository);
                    break;
                case(3):
                    Book BookToReturn = Biblioteca.ReadBookName(repository.GetCheckedBooks());
                    Biblioteca.ReturnBook(BookToReturn, repository);
                    break;
                default:
                    break;
            }
        }
    }
}
