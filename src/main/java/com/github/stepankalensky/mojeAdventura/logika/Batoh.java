package com.github.stepankalensky.mojeAdventura.logika;

import java.util.Map;
import java.util.HashMap;

/**
 * Trida Batoh - obsahuje seznam Věcí, které má hráč u sebe.
 * 
 * Tato třída je součástí jednoduché textové hry.
 * 
 * Batoh reprezentuje inventář věcí, které hráč nasbírá.
 * Batoh má 2 atributy 
 * inventarHrace - seznam věcí, které hráč má u sebe
 * NOSNOST - statistická proměnná udávající maximální možný počet předmětů,
 * které hráč může mít v jednu chvíli u sebe
 * 
 * Do batohu se dají věci přidávat a také z něj jdou vyhazovat.
 * 
 * @author Štěpán Kalenský
 * @version 1.0
 */
public class Batoh
{
    private Map<String, Vec> inventarHrace;
    private static final int NOSNOST = 10;


    /**
     * Konstruktor
     * Vytvoří seznam na  věcí, které hráč sbírá v průběhu hry.
     */
    public Batoh()
    {
        inventarHrace = new HashMap<>(); 

    }
    /**
     * Metoda, které vloží věc do batohu.
     * Je omezená - pokud bude chtít hráč vložit do batohu věc, na kterou už nemá místo
     * - věc se nepřidá.
     */
    public boolean vlozDoBatohu(Vec vec){
        if (inventarHrace.size() < NOSNOST) {
            inventarHrace.put(vec.getNazev(), vec);
            return true;
        }
        return false;

    }
    /**
     * Metoda, které odebere věc z batohu.
     */
    public void odeberVec (String nazevVeci){
        inventarHrace.remove(nazevVeci);

    }

    /**
     * Metoda , kterou označíme věc.
     * 
     */
    public Vec vecVInventari (String nazevVeci) {
        return inventarHrace.get(nazevVeci);
    }

    /**
     * Metoda, ve které se ptáme, jestli batoh obsahuje určitou věc.
     * 
     */
    public boolean obsahujeVec (String nazevVeci) {
        return inventarHrace.containsKey(nazevVeci);
    }

    /**
     * Metoda vypisující seznam věcí v batohu.
     */
    public String veciVBatohu() {
        String nazvy= "věci v batohu: ";
        for (String nazevVeci : inventarHrace.keySet()){
            nazvy += nazevVeci + " ";
        }
        return nazvy;
    }

    /**
     * Getter na batoh.
     */
    public Map getBatoh(){
        return inventarHrace;
    }

    /**
     * Getter na NOSNOST batohu.
     */
    public int getNosnostBatohu(){
        return NOSNOST;
    }

}
