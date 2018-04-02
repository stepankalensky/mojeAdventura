package com.github.stepankalensky.mojeAdventura.logika;


import java.util.Observable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import java.util.List;

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
public class Batoh extends Observable
{
    private List<Vec> inventarHrace;
    private static final int NOSNOST = 10;


    /**
     * Konstruktor
     * Vytvoří seznam na  věcí, které hráč sbírá v průběhu hry.
     */
    public Batoh()
    {
        inventarHrace = new ArrayList<Vec>(); 

    }
    

    
    /**
     * Metoda, které odebere věc z batohu.
     */
    public Vec odeberVec (String nazevVeci){
        Vec mazanaVec = null;
        for (Vec item : inventarHrace) {
			if (item.getNazev().equals(nazevVeci)) {
				mazanaVec = item;
				inventarHrace.remove(item);
				
				setChanged();
				notifyObservers();
				
				break;
			}
		}
		
		return mazanaVec;
	}

    

   

    /**
     * Metoda, ve které se ptáme, jestli batoh obsahuje určitou věc.
     * 
     */
    public boolean obsahujeVec (String nazevVeci) {
    	for (Vec item : inventarHrace) {
			if (item.getNazev().equals(nazevVeci)) {
				return true;
			}
		}
		return false;
    }
    
    /**
	 * Metoda zjistujici obsah batohu
	 * 
	 * @return retezec obsahujici jednotlive nazvy veci z batohu
	 */
	public String getObsahBatohu() {
		String obsah = "";
		
		for (Vec item : inventarHrace) {
			obsah += item.getNazev() + " ";
		}
		
		return obsah;
	}
	
	/**
	 * Metoda zjistuje, zdali neni naplnena kapacita batohu
	 * 
	 * @return true, zdali je mozne vlozit dalsi vec
	 */
	public boolean jeMisto() {
		return inventarHrace.size() < NOSNOST;
	}
    
    /**
     * Metoda vraci seznam veci v batohu
     * 
     * @return Kolekce veci obsazenych v batohu.
     */
	public Collection<Vec> getVeci() {
    	return Collections.unmodifiableCollection(inventarHrace);
    }

   
    
    /**
	 * Metoda prida vec do batohu pokud se vejde a je prenositelna
	 * 
	 * @param vec - vec pro vlozeni
	 */
	public boolean vlozDoBatohu(Vec vec) {
		if (jeMisto() && vec.jePrenositelna()) {
			inventarHrace.add(vec);
			
			setChanged();
			notifyObservers();
			
			return true;
		}
		
		return false;
	}
  

   

    /**
     * Getter na NOSNOST batohu.
     */
    public int getNosnostBatohu(){
        return NOSNOST;
    }
    
   

}
    
