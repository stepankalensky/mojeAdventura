/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.stepankalensky.mojeAdventura;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testovací třída  VecTest slouží ke komplexnímu otestování třídy Vec.
 *
 *
 * @author  Štěpán Kalenský
 * @version 1.0
 */
public class VecTest
{
  

    /**
     * Inicializace předcházející spuštění každého testu.
     * 
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Úklid po testu, tato metoda se pustí po vykonání testu.
     * 
     * 
     * */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Tento test metody zkouší přenositelnost věcí.
     */
    @Test
    public void testPrenositelnost(){
        Vec vec1 = new Vec ("hrnek", true);
        Vec vec2 = new Vec ("oceán", false);
        assertTrue(vec1.jePrenositelna());
        assertFalse(vec2.jePrenositelna());
    }    
}
