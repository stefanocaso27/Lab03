package it.polito.tdp.spellchecker.model;

public class RichWord {
	private String parola = "";
	private boolean corretta = false;
	
	public RichWord(String p) {
		super();
		this.parola = p;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public boolean isCorretta() {
		return corretta;
	}

	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}
}

