package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;


public class RepositoryTest {

    Repository Repo;

    @Before
    public void setUp() throws IOException {
        Repo = new Repository();
    }

    @Test
    public void RepositoryShouldHaveAListAvailableOfBooks(){
        ArrayList<Book> Available = Repo.GetAllBooks();
        Assert.assertNotNull(Available);
    }

    @Test
    public void RepositoryShouldHaveAListOfCheckedBooks(){
        ArrayList<Book> Checked = Repo.GetCheckedBooks();
        Assert.assertNotNull(Checked);
    }

    @Test
    public void ListOfBooksShouldNotBeEmpty(){
        ArrayList<Book> Lista = Repo.GetAllBooks();
        Assert.assertTrue(Lista.size() > 0);
    }

}
