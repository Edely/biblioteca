package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
public class BibliotecaTest {

    Biblioteca Library;

    @Before
    public void setUp() {
        Library = new Biblioteca();
    }

    @Test
    public void UserShouldCheckBooks(){
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("I, Robot".getBytes());
        System.setIn(in);
        Library.CheckoutBook();
        System.setIn(sysInBackup);
    }


}
