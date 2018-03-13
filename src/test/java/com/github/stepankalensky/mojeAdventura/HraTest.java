/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */

package com.github.stepankalensky.mojeAdventura;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.stepankalensky.mojeAdventura.logika.Hra;

import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 * @author    Jarmila Pavlíčková
 * @version  pro školní rok 2016/2017
 */
public class HraTest {
    private Hra hra1;

    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
        hra1 = new Hra();
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /***************************************************************************
     * Testuje průběh hry, po zavolání každěho příkazu testuje, zda hra končí
     * a v jaké aktuální místnosti se hráč nachází.
     * Při dalším rozšiřování hry doporučujeme testovat i jaké věci nebo osoby
     * jsou v místnosti a jaké věci jsou v batohu hráče.
     * 
     */
    @Test
    public void testPrubehHry() {
        assertEquals("domov", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("seber stůl");
        assertFalse( hra1.getHerniPlan().getAktualniProstor().jeVecVProstoru("stůl"));

        hra1.zpracujPrikaz("jdi letiště");
        assertEquals(false, hra1.konecHry());
        assertEquals("letiště", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("jdi Lanus");
        assertEquals(false, hra1.konecHry());
        assertEquals("Lanus", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("jdi dům");
        assertEquals(false, hra1.konecHry());
        assertEquals("dům", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("seber kraťasy");
        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("jdi Lanus");
        assertEquals(false, hra1.konecHry());
        assertEquals("Lanus", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("jdi letiště");
        assertEquals(false, hra1.konecHry());
        assertEquals("letiště", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("jdi Coracoes");
        assertEquals(false, hra1.konecHry());
        assertEquals("Coracoes", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("jdi radnice");
        assertEquals(false, hra1.konecHry());
        assertEquals("radnice", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("seber kopačky");
        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("jdi Coracoes");
        assertEquals(false, hra1.konecHry());
        assertEquals("Coracoes", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("jdi letiště");
        assertEquals(false, hra1.konecHry());
        assertEquals("letiště", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("jdi Funchal");
        assertEquals(false, hra1.konecHry());
        assertEquals("Funchal", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("jdi muzeum");
        assertEquals(false, hra1.konecHry());
        assertEquals("muzeum", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("seber dres");
        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("jdi Funchal");
        assertEquals(false, hra1.konecHry());
        assertEquals("Funchal", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("jdi letiště");
        assertEquals(false, hra1.konecHry());
        assertEquals("letiště", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("jdi Mnichov");
        assertEquals(false, hra1.konecHry());
        assertEquals("Mnichov", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("jdi stadion");
        assertEquals(false, hra1.konecHry());
        assertEquals("stadion", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("hraj");
        assertEquals(true, hra1.konecHry());
    }

    /**
     * Tento test testuje špatný průběh hry, kdy hráč nemá potřebné předměty u sebe.
     */
    @Test
    public void testSpatnyPrubeh (){
        assertEquals("domov", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("jdi letiště");
        assertEquals(false, hra1.konecHry());
        assertEquals("letiště", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("jdi Mnichov");
        assertEquals(false, hra1.konecHry());
        assertEquals("Mnichov", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("jdi stadion");
        assertEquals(false, hra1.konecHry());
        assertEquals("stadion", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("hraj");
        assertEquals(false, hra1.konecHry());
    }
}
