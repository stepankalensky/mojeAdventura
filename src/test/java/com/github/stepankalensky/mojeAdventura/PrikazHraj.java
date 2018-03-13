/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.stepankalensky.mojeAdventura;

/**
 * Třída PrikazHraj implementuje pro hru příkaz hraj.
 * 
 * Tato třída je součástí jednoduché textové hry.
 * 
 * @author Štěpán Kalenský
 * @version 1.0
 *
 */
public class PrikazHraj implements IPrikaz
{
    private static final String NAZEV = "hraj";
    private HerniPlan plan;

    
    /**
     * Konstruktor třídy
     *  
     *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
     */

    public PrikazHraj(HerniPlan plan)
    {
        this.plan = plan;

    }

    /**
     * Provádí příkaz "hraj". Rozhodující příkaz, díky kterému se rozhodne, zda-li hráč vyhraje či prohraje.
     * Tento příkaz je spustitelný pouze v prostoru "stadion".
     * Aby hráč vyhrál potřebuje u sebe mít 3 věci - kraťasy, dres a kopačky.
     * Po napsání příkazu hraj se vypíše gratulace a hra se ukončí.
     * 
     * Spustit příkaz lze i, aniž by hráč měl všechny 3 předměty u sebe,
     * to však znamená prohru a vypíše se hlášení prohry.
     * 
     * 
     */
    @Override   
    public String provedPrikaz(String... parametry){  
        if (parametry.length > 0) {
            return "Hrát s kým? Stačí napsat samostatné sloveso.";
        }

        Prostor aktualniProstor = plan.getAktualniProstor();
        Batoh batoh = plan.getBatoh();
        if( aktualniProstor.getNazev().equals("stadion")){
            if(batoh.veciVBatohu().contains("kopačky") && batoh.veciVBatohu().contains("dres") && batoh.veciVBatohu().contains("kraťasy"))  {
                plan.nastavVyhra(true);
                return "Vyhráli jsme zápas!";
            }
            else {
                plan.nastavProhra(true);
                return "Prohráli jsme, planeta bude zničena. Můžeš se jít rozloučit s milovanými.";
            }

        }
        return "Nejsi na stadionu a zde, kde jsi nemůžeš odehrát zápas.";
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
