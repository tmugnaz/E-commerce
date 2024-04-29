package ecommerce;

public class IndirizzoUtente {
	private String indirizzoVia;
	private String CAP;
	private INDIRIZZOTYPE indirizzotype;
	private Utente utente;
	
	
	public IndirizzoUtente (String indirizzoVia, String CAP, Utente utente) {
		this.indirizzoVia= indirizzoVia;
		this.CAP=CAP;
		this.utente=utente;
		this.indirizzotype = INDIRIZZOTYPE.SPEDIZIONE;
		
	}
	
	public void cambiaIndirizzoType() {
		if (this.indirizzotype == INDIRIZZOTYPE.SPEDIZIONE) {
			this.indirizzotype = INDIRIZZOTYPE.FATTURAZIONE;
		}else {
			this.indirizzotype= INDIRIZZOTYPE.SPEDIZIONE;
		}
	}
	
}
