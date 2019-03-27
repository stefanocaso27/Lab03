package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SpellCheckerController {
	
	public void setModel(Dictionary dic) {
    	this.dic = dic;
        combobox.getItems().removeAll(combobox.getItems());
    	combobox.getItems().addAll("English", "Italian");
    }

	
	private Dictionary dic = new Dictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTitle;

    @FXML
    private TextField txtLanguage;

    @FXML
    private ComboBox<String> combobox;

    @FXML
    private TextArea txtTranslate;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextField txtWrong;

    @FXML
    private TextArea txtListWrong;

    @FXML
    private Text txtNWrong;

    @FXML
    private Button btnReset;

    @FXML
    void doClearText(ActionEvent event) {
    	txtTranslate.clear();
    	txtListWrong.clear();
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	String lingua = combobox.getValue();
    	dic.loadDictionary(lingua);
    	
    	String testo = txtTranslate.getText();
    	List<RichWord> uscita1 = new LinkedList<RichWord>();
    	uscita1 = dic.spellCheckText(testo);
    	
    	String uscita2 = "";
    	uscita2 = dic.errori(uscita1);
    	System.out.println(uscita2);
    	
    	int nErr = 0;
    	nErr = dic.numErrori(uscita1);
    	txtNWrong.setText("The text contains " + nErr + " errors.");
    }

    @FXML
    void initialize() {
        assert txtTitle != null : "fx:id=\"txtTitle\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtLanguage != null : "fx:id=\"txtLanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert combobox != null : "fx:id=\"combobox\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTranslate != null : "fx:id=\"txtTranslate\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtWrong != null : "fx:id=\"txtWrong\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtListWrong != null : "fx:id=\"txtListWrong\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtNWrong != null : "fx:id=\"txtNWrong\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SpellChecker.fxml'.";

    }
}
