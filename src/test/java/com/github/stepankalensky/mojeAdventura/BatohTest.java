/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.stepankalensky.mojeAdventura;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testovací třída BatohTest slouží ke komplexnímu otestování třídy Batoh.
 *
 * @author  Štěpán Kalenský
 * @version 1.0
 */
public class BatohTest
{
    private Vec vec1;
    private Vec vec2;
    private Vec vec3;
    private Vec vec4;
    private Batoh batoh1;

    /**
     * Inicializace předcházející spuštění každého testu.
     *
     */
    @Before
    public void setUp()
    {
        vec1 = new Vec ("jídlo", false);
        vec2 = new Vec ("hrnek", true);
        vec3 = new Vec ("šála", true);
        vec4 = new Vec ("pití", true);
        batoh1 = new Batoh();
    }

    /**
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void tearDown()
    {
        //úklid
    }
    /**
     * Testuje metody obsahujeVec a vlozDoBatohu.
     */
    @Test
    public void testVlozDoBatohu(){
        assertEquals(true, batoh1.vlozDoBatohu(vec1));
        assertEquals(true, batoh1.obsahujeVec("jídlo"));
        assertEquals(true, batoh1.vlozDoBatohu(vec2));
        assertEquals(true, batoh1.obsahujeVec("hrnek"));
        assertEquals(true, batoh1.vlozDoBatohu(vec3));
        assertEquals(true, batoh1.obsahujeVec("šála"));
        assertEquals(true, batoh1.vlozDoBatohu(vec4));
        assertEquals(true, batoh1.obsahujeVec("pití"));
        
    }
    
    /**
     * ¨Testuje metodu vecVInventari.
     */
    @Test
    public void testVecVInventari (){
        assertEquals(true, batoh1.vlozDoBatohu(vec2));
        assertEquals(null, batoh1.vecVInventari("kafe"));
    }
}
