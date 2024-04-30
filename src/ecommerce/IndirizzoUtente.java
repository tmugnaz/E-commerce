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
	
	
	public IndirizzoUtente() {
		// TODO Auto-generated constructor stub
	}


	public void cambiaIndirizzoType() {
		if (this.indirizzotype == INDIRIZZOTYPE.SPEDIZIONE) {
			this.indirizzotype = INDIRIZZOTYPE.FATTURAZIONE;
		}
			
	}

	public String getIndirizzoVia() {
		return indirizzoVia;
	}

	public void setIndirizzoVia(String indirizzoVia) {
		this.indirizzoVia = indirizzoVia;
	}

	public String getCAP() {
		return CAP;
	}

	public void setCAP(String cAP) {
		CAP = cAP;
	}

	public INDIRIZZOTYPE getIndirizzotype() {
		return indirizzotype;
	}

	public void setIndirizzotype(INDIRIZZOTYPE indirizzotype) {
		this.indirizzotype = indirizzotype;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}


	public void info() {
		System.out.println("via: "+this.getIndirizzoVia()+" CAP"+this.getCAP()+" tipologia:"+this.getIndirizzotype().name());
	}
	
	
}
