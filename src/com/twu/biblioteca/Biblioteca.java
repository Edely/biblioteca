package com.twu.biblioteca;

public class Biblioteca {

    static Repository BooksRepository = new Repository();

    public static void main(String[] args) {
        Greetings();
        PrintBooks();
    }

    private static void Greetings(){
        System.out.println("Welcome to Biblioteca. You one-stop-shop for great book titles in Brazil.");
    }

    private static void PrintBooks(){
        System.out.println("These are our available books right now");
        for (Book book: BooksRepository.getListOfBooks()) {
            System.out.println(book.getName());
        }
    }

}
