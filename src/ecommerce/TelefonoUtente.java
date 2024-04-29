package ecommerce;

public class TelefonoUtente {
	
	private Long Id;
	private Utente utente;
	private String numeroTelefono;
	
	public TelefonoUtente() {};
	
	public TelefonoUtente(Utente utente, String numeroTelefono) {
		super();
		this.utente = utente;
		this.numeroTelefono = numeroTelefono;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	
	

}
