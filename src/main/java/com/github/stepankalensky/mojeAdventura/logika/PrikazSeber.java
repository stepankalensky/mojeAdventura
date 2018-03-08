/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.stepankalensky.mojeAdventura.logika;

/*******************************************************************************
 * Třída PrikazSeber implementuje pro hru příkaz seber.
 *  Tato třída je součástí jednoduché textové hry.
 *
 * @author  Štěpán Kalenský
 * @version  1.0
 */
public class PrikazSeber implements IPrikaz
{
    //== Datové atributy (statické i instancí)=====================================
    private static final String NAZEV = "seber";
    private HerniPlan plan;
    /**
     *  Konstruktor třídy
     *  
     *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
     */    
    public PrikazSeber(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *  Provádí příkaz "seber". Zkouší sebrat věc z prostoru. Pokud věcv daném prostoru
     *  existuje, tak z prostoru zmizí a přidá se hráči do inventáře.
     *  Pokud věc v prostoru není, vypíše se chybové hlášení. Pokud věc v prostoru je,
     *  ale není přenositelná, vypíše se chybové hlášení.
     *
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {           
            return "Co mám sebrat? Musíš zadat název věci";
        }

        String nazevSbiraneVeci = parametry[0];       
        Prostor aktualniProstor = plan.getAktualniProstor(); 

        if (aktualniProstor.jeVecVProstoru(nazevSbiraneVeci)== false)  {
            return "to tu není";
        }
        else {
            Vec vec = aktualniProstor.odeberVec(nazevSbiraneVeci);

            if(vec.jePrenositelna() == true ){
                aktualniProstor.vlozVec(vec);
                Batoh batoh = plan.getBatoh();
                batoh.vlozDoBatohu(vec);
                aktualniProstor.odeberVec(nazevSbiraneVeci);
                return "Máš-li místo v inventáři, sebral jsi " + vec.getNazev() ;

            }
            else{
                return "To neuzvedneš";
            }
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

    //== Nesoukromé metody (instancí i třídy) ======================================

    //== Soukromé metody (instancí i třídy) ========================================
}
