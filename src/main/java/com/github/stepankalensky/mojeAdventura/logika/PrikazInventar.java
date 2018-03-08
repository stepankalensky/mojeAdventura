package com.github.stepankalensky.mojeAdventura.logika;

/**
 * Třída PrikazInventar implementuje pro hru příkaz inventář.
 *  Tato třída je součástí jednoduché textové hry.
 * 
 * @author Štěpán Kalenský 
 * @version 1.0
 */
public class PrikazInventar implements IPrikaz
{
    private static final String NAZEV = "inventář";
    private HerniPlan plan;

    /**
     * Konstruktor třídy
     *  
     *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
     */
    public PrikazInventar(HerniPlan plan)
    {
        this.plan = plan;
    }

    /**
     * Provádí příkaz "inventář". Zobrazuje hráči, jaké věci se nacházejí konkrétně v jeho batohu.
     * 
     */
    @Override
    public String provedPrikaz(String... parametry) {

        return plan.getBatoh().veciVBatohu();
    }
    
    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */    

    @Override
    public String getNazev(){
        return NAZEV;
    }
}
