/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.stepankalensky.mojeAdventura.logika;

/**
 * Třída PrikazZahod implementuje pro hru příkaz zahoď.
 *  Tato třída je součástí jednoduché textové hry.
 * 
 * @author Štěpán Kalenský
 * @version 1.0
 */
public class PrikazZahod implements IPrikaz
{
    // instance variables - replace the example below with your own
    private static final String NAZEV = "zahoď";
    private HerniPlan plan;

    /**
     * Konstruktor třídy
     *  
     *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
     */
    public PrikazZahod(HerniPlan plan)
    {
        this.plan = plan;
    }

    /**
     * Provádí příkaz "zahoď". Zkouší vyhodit věc z invetáře do aktuálního prostoru.
     * Pokud hráč nenapíše, co má vyhodit, vypíše se chybové hlášení.
     * Pokud hráč věc v inventáři nemá, vypíše se chybové hlášení.
     * Pokud hráč danou věc v inventáři má, vyhodí ji a ta se objeví v aktuálním prostoru,
     * kde se hráč nachází.
     * 
     * return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry){
        if (parametry.length == 0) {           
            return "Co mám vyhodit? Musíš zadat název věci";
        }
        String nazevVeci = parametry[0];       
        Prostor aktualniProstor = plan.getAktualniProstor();

        Vec mazana = plan.getBatoh().vecVInventari(nazevVeci);
        if (plan.getBatoh().obsahujeVec(nazevVeci) == false) {
            return "Tohle v inventáři nemáš";
        }

        else{
            Batoh batoh = plan.getBatoh();
            aktualniProstor.vlozVec(mazana);
            batoh.odeberVec(nazevVeci);

            return " Zahodil jsi" + " " + nazevVeci ;
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
