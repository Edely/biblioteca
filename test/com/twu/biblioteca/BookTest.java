package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
public class BookTest {

    Book WarAndPeace;
    Book TheIdiot;
    Book AsMeninas;

    @Before
    public void setUp(){
        WarAndPeace = new Book("War and Peace", "Leo Tolstoy", 1865);
        TheIdiot = new Book("The Idiot", "Fyodor Dostoyevsky", 0);
        AsMeninas = new Book("As Meninas", "Ligya Fagundes Teles", -1973);
    }

    @Test
    public void BookShouldHaveName(){
        Assert.assertTrue(WarAndPeace.getName() != "");
    }


    @Test
    public void BookShouldHaveYear(){
        Assert.assertNotNull( TheIdiot.getYear());
    }

    @Test
    public void BookShouldHaveAuthor(){
        Assert.assertTrue(AsMeninas.getAuthor() != "");
    }

    @Test
    public void ShouldConvertYearToGregorian(){
        Assert.assertEquals( TheIdiot.getYearFormatted(), "AD 1");
        Assert.assertEquals( AsMeninas.getYearFormatted(), "BC 1973");
        Assert.assertEquals( WarAndPeace.getYearFormatted(), "AD 1865");
    }

}
