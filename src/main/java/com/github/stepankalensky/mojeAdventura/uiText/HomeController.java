package com.github.stepankalensky.mojeAdventura.uiText;



import java.util.Observable;
import java.util.Observer;

import com.github.stepankalensky.mojeAdventura.logika.IHra;
import com.github.stepankalensky.mojeAdventura.logika.Prostor;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou
 * a logikou adventury
 * 
 * @author Filip Vencovsky
 *
 */
public class HomeController extends GridPane implements Observer {
	
	@FXML private TextField textVstup;
	@FXML private TextArea textVypis;
    @FXML private Button odesli;
    @FXML private ListView<Prostor> seznamMistnosti;
	private IHra hra;
	
	/**
	 * Metoda čte příkaz ze vstupního textového pole
	 * a zpracuje ho...
	 */
	public void odesliPrikaz() {
		 String vypis = hra.zpracujPrikaz(textVstup.getText());
		 textVypis.appendText("\n--------\n"+textVstup.getText()+"\n-------\n");
		 textVypis.appendText(vypis);
		 textVstup.setText("");
		 
		 if(hra.konecHry()) {
			  textVypis.appendText("\n\n Konec hry \n");
			  textVstup.setDisable(true);
			  odesli.setDisable(true);
			  
			}

		
	}
	public void inicializuj(IHra hra) {
		this.hra = hra;
		textVypis.setText(hra.vratUvitani());
		seznamMistnosti.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVychody());
		hra.getHerniPlan().addObserver(this);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		seznamMistnosti.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVychody());
	}
	

}