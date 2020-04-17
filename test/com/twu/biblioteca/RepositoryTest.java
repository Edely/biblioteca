package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;


public class RepositoryTest {

    Repository AnisioTeixeira;

    @Before
    public void setUp() throws IOException {
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
    public void ShouldTestIfBookIsOnList(){
        ArrayList<Book> AllBooks = AnisioTeixeira.getAllBooks();
        Book isAvailable = AnisioTeixeira.GetBook("The Price of Salt", AllBooks);
        Assert.assertNull(isAvailable);
        isAvailable = AnisioTeixeira.GetBook("I, Robot", AllBooks);
        Assert.assertNotNull(isAvailable);
    }



}
