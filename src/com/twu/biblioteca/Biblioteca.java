package com.twu.biblioteca;

import com.twu.biblioteca.system.Menu;

import java.util.Map;
import java.util.Scanner;

public class Biblioteca {

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. You one-stop-shop for great book titles in Brazil.\n");
        Repository repository = new Repository();
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

}

