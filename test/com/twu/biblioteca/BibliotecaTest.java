package com.twu.biblioteca;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BibliotecaTest {

    private Biblioteca MonteiroLobato;

    @Before
    public void setUp(){
        MonteiroLobato = new Biblioteca();
    }

    @Test
    public void ShouldReturnARepository(){
        Assert.assertNotNull(MonteiroLobato.BooksRepository);
    }

}
