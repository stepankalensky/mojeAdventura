package com.github.stepankalensky.mojeAdventura.uiText;



import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import com.github.stepankalensky.mojeAdventura.Batoh;
import com.github.stepankalensky.mojeAdventura.Postava;
import com.github.stepankalensky.mojeAdventura.logika.Vec;
import com.github.stepankalensky.mojeAdventura.logika.Hra;
import com.github.stepankalensky.mojeAdventura.logika.IHra;
import com.github.stepankalensky.mojeAdventura.logika.Prostor;


import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.collections.ObservableList;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou
 * a logikou adventury
 * 
 * @author Filip Vencovsky, Štěpán Kalenský
 *
 */
public class HomeController extends GridPane implements Observer {
	
	@FXML private TextField textVstup;
	@FXML private TextArea textVypis;
    @FXML private Button odesli;
    @FXML private ListView<Prostor> seznamMistnosti;
    @FXML private ListView<Object> obsahBatohu;
    
    
    private ObservableList<Object> veciBatoh = FXCollections.observableArrayList();
    private ObservableList<Prostor> vychody = FXCollections.observableArrayList();
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
		 
		 hra.getHerniPlan().getAktualniProstor().addObserver(this);
		
		 
		 if(hra.konecHry()) {
			  textVypis.appendText("\n\n Konec hry \n");
			  textVstup.setDisable(true);
			  odesli.setDisable(true);
			  
			}

		
	}
	public void inicializuj(IHra hra) {
		this.hra = hra;
		textVstup.setEditable(true);
		textVypis.setEditable(false);
		textVypis.setText(hra.vratUvitani());
		
		
		seznamMistnosti.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVychody());
		hra.getHerniPlan().addObserver(this);
		hra.getHerniPlan().getBatoh().addObserver(this);
		hra.getHerniPlan().getAktualniProstor().addObserver(this);
		
		obsahBatohu.getItems().addAll(hra.getHerniPlan().getBatoh().getVeci());
		
		obsahBatohu.setItems(veciBatoh);
		seznamMistnosti.setItems(vychody);
		
	}
	
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		veciBatoh.clear();
		vychody.clear();
		
		seznamMistnosti.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVychody());
		// obsahBatohu.getItems().addAll(hra.getHerniPlan().getBatoh().getVeci());
		Collection<Vec> obsahBatohu1 = hra.getHerniPlan().getBatoh().getVeci();
		for (Vec vec : obsahBatohu1) {
			ImageView picture = new ImageView(new Image(getClass().getResourceAsStream("../resources/" + vec.getNazevObrazku()), 65, 65, true, false));
			obsahBatohu.getItems().add(picture);
		}
	
		
		
	
	}
	/**
	 * Metoda pro spuštění nové hry
	 */
	  @FXML
	    private void novaHra() {
	        IHra hra = new Hra();
	        this.inicializuj(hra);
	  }
	  /**
	   * Metoda, která nám zobrazí nápovědu
	   */
	  
	
		@FXML public void napoveda() {
			Stage help = new Stage();
			help.setTitle("Nápověda");
			
			WebView webView = new WebView();
			webView.getEngine().load(getClass().getResource("../resources/napoveda.html").toExternalForm());
	        
	        help.setScene(new Scene(webView, 1200, 850));
	        help.show();
		}
	  
	
	  

}