package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

public class BibliotecaTest {

    @Test
    public void ShouldReturnARepository(){
        Repository BooksRepository = new Repository();
        Assert.assertNotNull(BooksRepository);
    }


}
