package ecommerce;

import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		System.out.println("sta compilando ");
		Scanner scanner = new Scanner(System.in);
		
		Utente utente = new Utente("tommaso","mugnai");
		utente.addIndirizzoFatturazione("viacitrulli", "5020");
		utente.addIndirizzoSpedizione("viadallepalle", "4300");
		utente.addTelefonoUtente("333333");
		utente.creaOrdine("mele", "bancomat");
		utente.info();
		
	
	
	
}	}
	
