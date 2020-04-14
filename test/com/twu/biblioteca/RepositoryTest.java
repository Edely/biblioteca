package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;


public class RepositoryTest {

    Repository Repo;

    @Before
    public void setUp(){
        Repo = new Repository();
    }

    @Test
    public void RepositoryShouldHaveAListOfBooks(){
        ArrayList<Book> Lista = Repo.getListOfBooks();
        Assert.assertNotNull(Lista);
    }

    @Test
    public void ListOfBooksShouldNotBeEmpty(){
        ArrayList<Book> Lista = Repo.getListOfBooks();
        Assert.assertTrue(Lista.size() > 0);
    }

}
