package com.twu.biblioteca;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Vector;

public class Menu {
    private ArrayList<Vector> Options = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    public ArrayList<Vector> getOptions() {
        return Options;
    }

    public void setOption(Vector Option) {
        Options.add(Option);
    }

    public int askOption(){
        int i = 0;

        System.out.println("What would you like to do?");

        for (Vector opt: Options){
            System.out.println(i + " " + opt.get(0));
            i++;
        }
        System.out.println();

        try {
            int optionChosed = in.nextInt();
            return optionChosed;
        }catch (Exception e){
            System.out.println("Please select a valid option.");
            int optionChosed = askOption();
            return optionChosed;
        }
    }

}
