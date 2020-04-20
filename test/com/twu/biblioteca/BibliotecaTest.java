package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;

public class BibliotecaTest {
    Repository Repo;

    @Before
    public void setUp() {
        this.Repo = new Repository();
    }

    @Test
    public void UserShouldCheckoutBook(){
        String BookName = "I, Robot";
        Book BookToCheck = Biblioteca.GetBook(BookName, Repo.GetAllBooks());
        Assert.assertTrue(Biblioteca.CheckoutBook(BookToCheck, Repo));
    }

    @Test
    public void UserShouldReturnBook(){
        String BookName = "Romeo and Juliet";
        Book BookToCheck = Biblioteca.GetBook(BookName, Repo.GetAllBooks());
        Biblioteca.CheckoutBook(BookToCheck, Repo);
        Book BookToReturn = Biblioteca.GetBook(BookName, Repo.GetCheckedBooks());
        Assert.assertTrue(Biblioteca.ReturnBook(BookToReturn, Repo));
    }

}
