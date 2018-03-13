/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.stepankalensky.mojeAdventura;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testovací třída  PostavaTest slouží ke komplexnímu otestování
 * třídy Postava.
 *
 * @author  Štěpán Kalenský
 * @version 1.0
 */
public class PostavaTest
{
   /**
     * Inicializace předcházející testu.
     *
     * 
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Úklid po testu - tato metoda se spustí po konci každého testu.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Testuje metody getJmeno a getProslov
     */
    @Test
    public void testPostava(){
        Postava postava1 = new Postava("Kopyto", "zdar");
        assertEquals("Kopyto", postava1.getJmeno());
        assertEquals("zdar", postava1.getProslov());
    }
}
