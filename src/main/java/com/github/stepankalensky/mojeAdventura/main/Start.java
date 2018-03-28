/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.stepankalensky.mojeAdventura.main;



import com.github.stepankalensky.mojeAdventura.logika.*;
import com.github.stepankalensky.mojeAdventura.logika.IHra;
import com.github.stepankalensky.mojeAdventura.uiText.HomeController;
import com.github.stepankalensky.mojeAdventura.logika.*;
import com.github.stepankalensky.mojeAdventura.uiText.TextoveRozhrani;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*******************************************************************************
 * Třída  Start je hlavní třídou projektu,
 * který představuje jednoduchou textovou adventuru určenou k dalším úpravám a rozšiřování
 *
 * @author    Jarmila Pavlíčková
 * @version   ZS 2016/2017
 */
public class Start extends Application
{
    /***************************************************************************
     * Metoda, prostřednictvím níž se spouští celá aplikace.
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args)
    {
        
 //       IHra hra = new Hra();
 //       TextoveRozhrani ui = new TextoveRozhrani(hra);
 //       ui.hraj();
    	launch(args);
    	
    	
    }
    /**
	 * Metoda, ve které se konstruuje okno, kontroler a hra,
	 * která se předává kontroleru
	 */
    
    @Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("../resources/MainWindow.fxml"));    	
    	Parent root = loader.load();

    	
     	HomeController controller = loader.getController();
   	    IHra hra = new Hra();
		controller.inicializuj(hra);
    	
    	primaryStage.setScene(new Scene(root));
    	primaryStage.show();
    	primaryStage.setTitle("Fotbalová adventura");
    	

    }
}
  
