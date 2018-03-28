package com.github.stepankalensky.mojeAdventura.logika;

import java.util.Observable;

/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Štěpán Kalenský
 *@version    1.0
 */
public class HerniPlan extends Observable{

    private Prostor aktualniProstor;
    private Prostor viteznyProstor;
    Batoh batoh = new Batoh();  // vytvoří instanci baťohu
    private boolean vyhra = false;
    private boolean prohra = false;

    /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();

    }

    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor domov = new Prostor("domov","Tvůj dům, ve kterém bydlíš.");
        Prostor letiste = new Prostor("letiště", "Letiště - rychlý způsob dopravy přes moře a oceány.");

        Prostor lanus = new Prostor("Lanus","Rodné místo Diega Maradony.");
        Prostor radniceLanus = new Prostor("radnice","Městská radnice Lanusu. Nic tu ale není.");
        Prostor muzeumLanus = new Prostor("muzeum","Místní muzeum Diega Maradony.");
        Prostor dumLanus = new Prostor("dům","Velmi hezký dům, kde vyrůstal Diego Maradona.");

        Prostor funchal = new Prostor("Funchal","Rodné místo Cristiana Ronalda.");
        Prostor radniceFunchal = new Prostor("radnice","Městská radnice Funchalu.");
        Prostor muzeumFunchal = new Prostor("muzeum","Místní muzeum Cristiana Ronalda.");
        Prostor dumFunchal = new Prostor("dům","Dům, ve kterém vyrůstal Cristiano Ronaldo. Přísně střežené.");

        Prostor coracoes = new Prostor("Coracoes","Rodné místo Pelého.");
        Prostor radniceCoracoes = new Prostor("radnice","Městská radnice Coracoesu.");
        Prostor muzeumCoracoes = new Prostor("muzeum","Místní muzeum na poctu Pelého. Dnes mají bohužel zavřeno.");
        Prostor dumCoracoes = new Prostor("dům","Chatrč, kde vyrůstal Pelé.");

        Prostor mnichov = new Prostor("Mnichov","Město, ve kterém se bude konat zápas.");
        Prostor stadion = new Prostor("stadion","Rozhodující zápas se bude hrát přímo na tomto stadionu.");
        // přiřazují se průchody mezi prostory (sousedící prostory)
        domov.setVychod(letiste);

        letiste.setVychod(lanus);
        letiste.setVychod(funchal);
        letiste.setVychod(coracoes);
        letiste.setVychod(mnichov); 
        letiste.setVychod(domov);

        lanus.setVychod(radniceLanus);           
        lanus.setVychod(muzeumLanus);             
        lanus.setVychod(dumLanus);              
        lanus.setVychod(letiste);
        radniceLanus.setVychod(lanus);
        muzeumLanus.setVychod(lanus);
        dumLanus.setVychod(lanus);

        coracoes.setVychod(radniceCoracoes);
        coracoes.setVychod(muzeumCoracoes);
        coracoes.setVychod(dumCoracoes);
        coracoes.setVychod(letiste);
        radniceCoracoes.setVychod(coracoes);
        muzeumCoracoes.setVychod(coracoes);
        dumCoracoes.setVychod(coracoes);

        funchal.setVychod(radniceFunchal);
        funchal.setVychod(muzeumFunchal);
        funchal.setVychod(dumFunchal);
        funchal.setVychod(letiste);
        radniceFunchal.setVychod(funchal);
        muzeumFunchal.setVychod(funchal);
        dumFunchal.setVychod(funchal);

        mnichov.setVychod(stadion);
        stadion.setVychod(mnichov);
        mnichov.setVychod(letiste);

        aktualniProstor = domov;// hra začíná v domovu
        viteznyProstor = stadion;

        Vec stul = new Vec("stůl",false);
        Vec postel = new Vec("postel",false);
        Vec televize = new Vec("televize",false);
        Vec svacina = new Vec("svačina", true);
        Vec lampa = new Vec("lampa", false);
        Vec zavazadlo = new Vec("zavazadlo", true);
        Vec letadlo= new Vec("letadlo", false);
        Vec automat= new Vec("automat", false);
        Vec dvere = new Vec("dveře", false);
        Vec rozcestnik = new Vec("rozcestník", false);
        Vec mic= new Vec("míč", true);
        Vec socha= new Vec("socha", false);
        Vec kratasy= new Vec("kraťasy", true); //nutné sebrat, aby hráč vyhrál
        Vec pivo= new Vec("pivo", true);
        Vec kopacky= new Vec("kopačky", true);   //nutné sebrat, aby hráč vyhrál
        Vec stojan=new Vec("stojan", false);
        Vec trouba= new Vec("trouba", false);
        Vec dres= new Vec("dres", true);    //nutné sebrat, aby hráč vyhrál
        Vec paratko= new Vec("párátko", true);
        Vec euro= new Vec("euro", true);
        Vec trofej=new Vec("trofej", false);
        Vec taxik=new Vec("taxík", false);
        Vec mapa = new Vec("mapa", false);

        Postava tajemnak = new Postava ("muž","Tak si piš! Jsou to Pelého kopačky, kraťasy Maradony a dres Cristiana Ronalda. \n" +
                "Věříme, že s těmito magickými předměty dokážes být rozdílovým hráčem našeho mužstva. Kdyby se ti všechny tři předměty nepodařilo získat, tak radši ani nechceme vědět, co by následovalo. \n" +
                "Teď se jdi vyspat a hned zítra se do toho dej. Jsi zmaten, nevíš jestli sníš, tak si jdeš lehnout, abys to otestoval(snít ve snu je totiž paradox). \n" +
                "Nic. Ráno jsi se probudil a teď už je jasné, že je to všechno doopravdy. Rozhodneš se tedy, že se do toho dáš a zkusíš předměty využít. Jsi doma, co teď uděláš? \n" );
        domov.vlozPostavu(tajemnak); //proslov se provede po použití příkazu mluv

        domov.vlozVec(stul);
        domov.vlozVec(postel);
        domov.vlozVec(televize);
        domov.vlozVec(svacina);
        domov.vlozVec(zavazadlo);

        letiste.vlozVec(lampa);
        letiste.vlozVec(letadlo);
        lanus.vlozVec(automat);
        lanus.vlozVec(dvere);
        muzeumLanus.vlozVec(socha);
        muzeumLanus.vlozVec(mic);
        dumLanus.vlozVec(kratasy);

        coracoes.vlozVec(rozcestnik);
        dumCoracoes.vlozVec(pivo);
        radniceCoracoes.vlozVec(stojan);
        radniceCoracoes.vlozVec(kopacky);
        dumCoracoes.vlozVec(trouba);

        funchal.vlozVec(mapa);
        radniceFunchal.vlozVec(paratko);
        radniceFunchal.vlozVec(euro);
        muzeumFunchal.vlozVec(trofej);
        muzeumFunchal.vlozVec(dres);

        mnichov.vlozVec(taxik);


    }

    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */

    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }

    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
        this.setChanged();
        this.notifyObservers();
    }

    public boolean jeVyhra(){
        return vyhra;

    }

    /**
     * Metoda vrací instanci baťohu
     */
    public  Batoh getBatoh(){
        return this.batoh;
    }

    public boolean jeProhra() {
        return prohra;
    }

    /**
     * Metody nastaví výhru či prohru //
     */
    public void nastavVyhra(boolean stav) {
        this.vyhra = stav;
    }

    public void nastavProhra(boolean stav) {
        this.prohra = stav;
    }

}
