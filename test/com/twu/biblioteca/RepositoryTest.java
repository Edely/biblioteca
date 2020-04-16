package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;


public class RepositoryTest {

    Repository AnisioTeixeira;

    @Before
    public void setUp(){
        AnisioTeixeira = new Repository();
    }

    @Test
    public void RepositoryShouldHaveAListOfBooks(){
        ArrayList<Book> Lista = AnisioTeixeira.getAllBooks();
        Assert.assertNotNull(Lista);
    }


    @Test
    public void ListOfBooksShouldNotBeEmpty(){
        ArrayList<Book> Lista = AnisioTeixeira.getAllBooks();
        Assert.assertTrue(Lista.size() > 0);
    }


    @Test
    public void BookOnAllBooksShouldBeCheckOuted(){
        Book RomeoAndJuliet = AnisioTeixeira.IsBookAvailable("Romeo and Juliet");
        Assert.assertTrue(AnisioTeixeira.ProcessBook(RomeoAndJuliet));
    }

    @Test
    public void ShouldTestIfBookIsAvailable(){
        ArrayList<Book> Books = AnisioTeixeira.getAllBooks();
        Book isAvailable = AnisioTeixeira.IsBookAvailable("The Price of Salt");
        Assert.assertNull(isAvailable);
        isAvailable = AnisioTeixeira.IsBookAvailable("I, Robot");
        Assert.assertNotNull(isAvailable);
    }

}
