/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.stepankalensky.mojeAdventura;


/*******************************************************************************
 * Trida Vec - obsahuje jednotlivé věci rozmístěné ve všech prostorách
 * 
 * Tato třída je součástí jednoduché textové hry.
 * 
 * Věc reprezentuje jeden objekt ve scénáři hry.
 * Věc může být přenositelná a nebo ne.
 * Existují 3 věci, které hráč potřebuje k úspěšnému dokončení hry.
 * Kraťasy, kopačky a dres.
 *
 * @author   Štěpán Kalenský
 * @version   1.0
 */
public class Vec
{
    //== Datové atributy (statické i instancí)======================================

    private String nazev;
    private boolean prenositelnost;
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor 
     *  Vytvoří název věci a booleanovskou hodnotu, zda-li je přenositelné či nikoliv.
     *  @param nazev nazev věci, jednoznačný identifikátor - jedno slovo či víceslovný název bez mezer.
     *  
     *  @param boolean prenositelnost - označuje, zda-li je předmět přenositelný či ne.
     */

    public Vec(String nazev, boolean prenositelnost)
    {
        this.nazev = nazev;
        this.prenositelnost = prenositelnost;
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    /**
     * Getter názvu.
     */ public String getNazev(){
        return nazev;
    }

    /**
     * Metoda, která nám zodpoví, zda-li je věc přenositelná čí nikoliv.
     */
    public boolean jePrenositelna(){
        return prenositelnost;
    }

    //== Soukromé metody (instancí i třídy) ========================================

}
