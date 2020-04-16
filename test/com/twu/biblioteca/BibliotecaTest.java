package com.twu.biblioteca;
import com.sun.tools.corba.se.idl.ModuleEntry;
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

    @Test
    public void ShouldCheckoutBook(){
        /*
        *
        "I, Robots"
        "Do Androids Dream of Electric Sheep?"
        "The Odyssey"
        "Romeo and Juliet"
        * */

        boolean checked = MonteiroLobato.CheckoutBook();
        boolean isOnAllBooksList = false;
        for (Book book: MonteiroLobato.BooksRepository.getAllBooks()) {
            System.out.printf( "%-40s | %10s | %15s %n", book.getName(), book.getYearFormatted(), book.getAuthor());
        }

    }

}
