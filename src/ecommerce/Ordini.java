package ecommerce;

import java.util.*;

public class Ordini {
	private Utente utente;
	
	private STATO stato ;
	private String indirizzoFatturazione;
	private String indirizzoSpedizione;
	private List<String> modalit‡Pagamento=new ArrayList<String>();
	private List<RigaOrdine> righeOrdine= new ArrayList<RigaOrdine>();
	
	
	
	public Ordini (Utente utente , String nuovaPagamento, RigaOrdine rigaOrdine) {
		this.utente= utente;
		for(String mp : modalit‡Pagamento) {
			if(mp != nuovaPagamento) {
				modalit‡Pagamento.add(nuovaPagamento);
			}
		}
		if(utente.getIndirizzo().isEmpty()) {
			System.out.println("nessun indirizzo!!"
					+ "impostalo e riprova!");
			
		}else if ( utente.getIndirizzo().size()==1) {
			this.indirizzoFatturazione= this.utente.getIndirizzo().get(0).getIndirizzoVia()
										.concat(this.utente.getIndirizzo().get(0).getCAP());
			this.indirizzoSpedizione=this.indirizzoFatturazione;
		}else {
			int contatore = 0;
			for (IndirizzoUtente in : utente.getIndirizzo()) {
				if ( in.getIndirizzotype() == INDIRIZZOTYPE.FATTURAZIONE ) {
					this.indirizzoFatturazione = in.getIndirizzoVia().concat(in.getCAP());
				}
				else if (in.getIndirizzotype() == INDIRIZZOTYPE.SPEDIZIONE) {
					this.indirizzoSpedizione= in.getIndirizzoVia().concat(in.getCAP());
				}
			}
		}
		
		
		
	}

}
