package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	List <String> listaParole = new LinkedList <String>();
	
	public void loadDictionary(String language) {
		if(language.equals("English")) {
		try {
			FileReader fr = new FileReader("rsc/English.txt");
			BufferedReader br = new BufferedReader(fr);
			String word = "";
			while ((word = br.readLine()) != null) {
				word = word.trim();
				listaParole.add(word);
			    			}
			br.close();
		}
		
		catch (IOException e ){
			System. out .println("Errore nella lettura del file.");
			}
		}
		
		else if(language.equals("Italian")) {
			try {
				FileReader fr = new FileReader("rsc/Italian.txt");
				BufferedReader br = new BufferedReader(fr);
				String word = "";
				while ((word = br.readLine()) != null) {
					word = word.trim();
					listaParole.add(word);
					}
			br.close();
			}
			
			catch (IOException e ){
			System. out .println( "Errore nella lettura del file." );
			}
		}
	}
	
	public List<RichWord> spellCheckText(String testo) {
		List <RichWord> list = new LinkedList <RichWord>();
		String s = testo.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
		String [] ss = s.split(" ");
		for(String p : ss) {
			RichWord r = new RichWord(p);
				list.add(r);
		}
		for(RichWord r : list) {
			String sss = r.getParola();
			if(!listaParole.contains(sss));
			r.setCorretta(false);
		}
		return list;
	}

	public String errori(List<RichWord> list) {
		String s1 = "";
		for(RichWord r : list) {
			if(!r.isCorretta()) {
				s1 += r.getParola() + "\n";
			}
		}
		return s1;
	}
	
	public int numErrori(List<RichWord> list) {
		int count = 0;
		for(RichWord r : list) {
			if(!r.isCorretta())
				count++;
		}
		return count;
	}
}
