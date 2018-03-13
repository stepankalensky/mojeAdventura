/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.stepankalensky.mojeAdventura;

/**
 * Třida PrikazMluv implementuje pro hru příkaz zahoď.
 * Tato třída je součástí jednoduché textové hry.
 * 
 * 
 * @author Štěpán Kalenský
 * @version 1.0
 */

public class PrikazMluv implements IPrikaz
{
    // instance variables - replace the example below with your own
    private static final String NAZEV = "mluv";
    private HerniPlan plan;

    /**
     * Konstruktor třídy
     *  
     *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
     */
    public PrikazMluv(HerniPlan plan)
    {
        this.plan = plan;
    }

    /**
     * Provádí příkaz "mluv". Pokouší se spustit proslovy postav v aktuálním prostředí.
     * Pokud hráč nenapíše s kým mluvit, vypíše se chyba.
     * Pokud chtěná postava není v prostoru, vypíše se chyba.
     * Pokud postava je v prostoru, vypíše se zpráva(proslov) určený hráči.
     * 
     * 
     *  return zpráva, kterou vypíše hra hráči
     * 
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {           
            return "S kým mám mluvit? Musíš zadat jméno postavy";
        }

        String jmeno = parametry[0];
        Prostor aktualniProstor = plan.getAktualniProstor();
        Postava postava = aktualniProstor.najdiPostavu(jmeno);

        if(postava == null) {
            return "Taková postava tu není.";
        }

        else{
            return postava.getProslov();

        }
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */   

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
