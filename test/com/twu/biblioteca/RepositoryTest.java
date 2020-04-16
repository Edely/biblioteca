package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;


public class RepositoryTest {

    Biblioteca AnisioTeixeira;

    @Before
    public void setUp(){
        AnisioTeixeira = new Biblioteca();
    }

    @Test
    public void RepositoryShouldHaveAListOfNotAvailableBooks(){
        //dado que um livro foi escolhido por um usuário

        // quando um outro usuário acessa a biblioteca, ele deve ver apenas os livros que estao disponíveis no momento

        // e o livro em questao deve ser armazendo numa lista de livros não disponíveis
    }

    @Test
    public void RepositoryShouldHaveAListOfBooks(){
        ArrayList<Book> Lista = AnisioTeixeira.BooksRepository.getAllBooks();
        Assert.assertNotNull(Lista);
    }


    @Test
    public void ListOfBooksShouldNotBeEmpty(){
        ArrayList<Book> Lista = AnisioTeixeira.BooksRepository.getAllBooks();
        Assert.assertTrue(Lista.size() > 0);
    }

}
