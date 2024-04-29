package ecommerce;

import java.util.*;

public class Utente {
	
	private long idUtente;

	private String  nome;
	
	private String cognome;
	private List<TelefonoUtente> numeriTelefono=new ArrayList<TelefonoUtente>();
	private List<IndirizzoUtente> indirizzo= new ArrayList<IndirizzoUtente>();
	private RUOLO ruolo;
	private List<Ordini> ordini = new ArrayList<Ordini>();
	
	
	
	
	public Utente(String nome, String cognome, RUOLO ruolo) {
		super();
		this.nome = nome;
		this.ruolo= RUOLO.AMMINISTRATORE_DI_SISTEMA;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public List<TelefonoUtente> getNumeriTelefono() {
		return numeriTelefono;
	}
	public void setNumeriTelefono(TelefonoUtente numeroTelefono) {
		this.numeriTelefono.add(numeroTelefono);
	}
	public RUOLO getRuolo() {
		return ruolo;
	}
	public void setRuolo(RUOLO ruolo) {
		this.ruolo = ruolo;
	}
	public void setIdUtete (long id ) {
		this.idUtente= id;
	}
	public void setIndirizzoUtente(IndirizzoUtente indirizzo) {
		this.indirizzo.add(indirizzo);
	}
	public long getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
	}
	public List<IndirizzoUtente> getIndirizzo() {
		return indirizzo;
	}
	public List<Ordini> getOrdini() {
		return ordini;
	}
	public void setOrdini(List<Ordini> ordini) {
		this.ordini = ordini;
	}
	
	
}
