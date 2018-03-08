/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.stepankalensky.mojeAdventura.logika;


/**
 * Trida Postava - obsahuje postavy, se kterými se dá ve hře komunikovat.
 * 
 * Tato třída je součástí jednoduché textové hry.
 * 
 * Postava reprezentuje jednu bytost ve scénáři hry.
 * Postava má proslov, který může být a nemusí důležitý vzhledem k vyhrání hry
 * 
 * Postava má 2 atributy - jmeno a proslov.
 * jmeno - jednoznačný identifikátor postavy
 * proslov - vrací text, který nám chce postava sdělit
 * 
 * @author Štěpán Kalenský
 * @version 1.0
 */
public class Postava
{

    private String jmeno;
    private String proslov;

    /**
     *Konstruktor
     *Vytváří název postavy a její proslov viz. komentář nahoře.
     */
    public Postava (String jmeno, String proslov) {
        this.jmeno = jmeno;
        this.proslov = proslov;
    }

    /**
     * Getter na jméno postavy.
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Metoda vrací proslov postavy.
     */
    public String getProslov() {
        return proslov;

    }

   
}
