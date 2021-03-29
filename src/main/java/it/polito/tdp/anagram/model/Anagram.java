package it.polito.tdp.anagram.model;

import java.util.ArrayList;
import java.util.List;

public class Anagram {

	public List<String> anagrammi(String parola) {
		List<String> risultato = new ArrayList<String>();
		permuta("", parola, 0, risultato); // LANCIA la ricorsione
		//rimuovo dalla lista parole che non esistono nel dizionario
		return risultato;
	}
	
	// livello = lunghezza della soluzione parziale
	// livello iniziale = 0
	// parziale = stringa che contiene l'anagramma incompleto in fase di costruzione
	// lettere = le lettere della parola iniziale che ancora non abbiamo utilizzato
	//           (=== il sottoproblema che dobbiamo risolvere)
	
	private void permuta(String parziale, String lettere, int livello, List<String> risultato) {
		if(lettere.length() == 0) { // caso terminale 
			// la soluzione parziale è anche una soluzione completa
			//System.out.println(parziale);
			//if(parziale è ancora parola valida)
			risultato.add(parziale);
		} 
		else {
			// fai ricorsione
			// sottoproblema == una lettera (un singolo carattere) di 'lettere'
			for(int pos=0; pos<lettere.length(); pos++) {
				
				char tentativo = lettere.charAt(pos); 
				
				String nuovaParziale = parziale + tentativo;
				String nuovaLettere = lettere.substring(0, pos) + lettere.substring(pos+1);
					// togli il carattere pos da lettere
				
				//if(nuovaParziale è PREFISSO valido di almeno una parola nel dizionario)
				
				permuta(nuovaParziale, nuovaLettere, livello+1, risultato);
				
				// Backtracking (NON SERVE)
				// rimetti a posto 'parziale'
				// rimetti a posto 'lettere'
				
			}
		}
	}
	
}
