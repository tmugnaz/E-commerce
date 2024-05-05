package ecommerce;

import java.util.*;

public class Utente {

	private long idUtente;

	private String nome;

	private String cognome;
	private List<TelefonoUtente> numeriTelefono = new ArrayList<TelefonoUtente>();
	private List<IndirizzoUtente> indirizzi = new ArrayList<IndirizzoUtente>();
	private RUOLO ruolo;
	private List<Ordine> ordini = new ArrayList<Ordine>();

	
	public Utente(String nome,String cognome) {
		this.nome = nome;
		this.cognome=cognome;
		this.ruolo = RUOLO.AMMINISTRATORE_DI_SISTEMA;
	}
	public void infoIndirizzi() {
		for (IndirizzoUtente indirizzoUtente : indirizzi) {
			indirizzoUtente.info();
			
		}
	}

	public void infoOrdini() {
		for (Ordine o : this.getOrdini()) {
			o.info();
		}
	}
	public void info() {
		System.out.println("Nome: "+this.getNome()+" Cognome: "+this.getCognome());
		System.out.println();
		int tempo=1;
		for (IndirizzoUtente indirizzoUtente : indirizzi) {
			
			if(indirizzoUtente.getIndirizzotype()==INDIRIZZOTYPE.FATTURAZIONE) {
				System.out.println("indirizzo Fatturazione: "+indirizzoUtente.getIndirizzoVia().concat(indirizzoUtente.getCAP()));
				
			}else {
			System.out.println("indirizzo Spedizione: "+indirizzoUtente.getIndirizzoVia().concat(indirizzoUtente.getCAP()));
			
					}
			
		}
		int cont = 1;
		System.out.println();
		for (TelefonoUtente tf : numeriTelefono) {
			System.out.println("numero telefono "+cont+" :"+tf.getNumeroTelefono());
			cont++;
		}
		System.out.println("ruolo: "+this.getRuolo().name());
	}

	public void creaOrdine(String nomeOrdine, String modPagamento) {
		Ordine o = new Ordine(this, nomeOrdine, modPagamento);
		getOrdini().add(o);

	}
	public void pagaOrdine(String nomeOrdine) {
		if (searchOrdineByName(nomeOrdine)!=null) {
			searchOrdineByName(nomeOrdine).pagaOrdine();
			searchOrdineByName(nomeOrdine).info();
		}
	}
	public void spedisciOrdine(String nomeOrdine) {
		if (this.getRuolo()!= RUOLO.CLIENTE && searchOrdineByName(nomeOrdine)!=null) {
			searchOrdineByName(nomeOrdine).spedisciOrdine();
			searchOrdineByName(nomeOrdine).info();
		}
	}
	public void consegnaOrdine(String nomeOrdine) {
		if (searchOrdineByName(nomeOrdine)!=null) {
			searchOrdineByName(nomeOrdine).consegnaOrdine();
			searchOrdineByName(nomeOrdine).info();
		}
	}

	public void creaRigaOrdine(String nomeOrdine, Articolo articolo, int qta, int iva, int sconto) {
		if (this.searchOrdineByName(nomeOrdine) != null) {
			RigaOrdine ro = new RigaOrdine(searchOrdineByName(nomeOrdine), articolo, qta, iva, sconto);
			searchOrdineByName(nomeOrdine).addRigaOrdine(ro);
			ro.info();
		} else {
			System.out.println("crea prima nuovo ordine!");

		}
	}

	public Ordine searchOrdineByName(String nome) {
		for (Ordine o : this.getOrdini()) {
			if (o.getNome() == nome) {
				return o;
			}

		}
		return null;
	}

	

	public void addTelefonoUtente(String num) {
		TelefonoUtente tu = new TelefonoUtente(this, num);
		this.getNumeriTelefono().add(tu);
	}

	

	public void addIndirizzoSpedizione(String via, String cap) {
		IndirizzoUtente i = new IndirizzoUtente(via, cap, this);
		this.getIndirizzi().add(i);

	}

	public void addIndirizzoFatturazione(String via, String cap) {
		IndirizzoUtente i = new IndirizzoUtente(via, cap, this);
		i.cambiaIndirizzoType();
		this.getIndirizzi().add(i);
	}
	
	
	// METODI SCANNER PER INTERFACCIA UTENTE 
	
	
	public void addTelefonoUtenteScanner(Scanner scanner) {
		{
			System.out.println("digita il numero da aggiungere");
			String num = scanner.nextLine();
			System.out.println();
			TelefonoUtente tu = new TelefonoUtente(this, num);
			System.out.println("Puoi aggiungere nuovi numeri richiamando questo metodo!");
			this.getNumeriTelefono().add(tu);
		}
	}
	
	
	
	public Utente(String nome, String cognome, Scanner scanner) {
		super();
		this.nome = nome;
		this.cognome=cognome;
		this.ruolo = RUOLO.AMMINISTRATORE_DI_SISTEMA;
		System.out.println("aggiungi un numero di telefono");
		addTelefonoUtenteScanner(scanner);
		System.out.println("non scordarti di inserire un indirizzo tramite .addIndirizzi !!!");
	}
	
	
	
	
	public void creaOrdineScanner(Scanner scanner) {
		System.out.println("creazione ordine in corso");
		System.out.println("inserisci un nome al tuo ordine");
		String nomeOrdine = scanner.nextLine();
		System.out.println();
		Ordine o = new Ordine(this, nomeOrdine, scanner);
		if (o.getPagamentoSelezionato() == null || this.indirizzi.isEmpty()) {
			System.out.println("ordine annullato mancano informazioni ");
			o = null;
			return;
		} else {
			this.ordini.add(o);
			System.out.println("ordine creato inserisci gli articoli tramite addArticoloOrdine");
		}
	}
	

	public void addIndirizziScanner(Scanner scanner) {
		System.out.println("Aggiungere indirizzo di spedizione");
		System.out.println("Digitare CAP");
		String capUtente = scanner.nextLine();
		System.out.println();
		System.out.println("digitare la via");
		String viaUtente = scanner.nextLine();
		System.out.println();
		IndirizzoUtente i = new IndirizzoUtente(viaUtente, capUtente, this);
		System.out.println("indirizzo fatturazione è lo stesso di spedizione? (Y/N)");
		String Q = scanner.nextLine();
		System.out.println();
		switch (Q.charAt(0)) {
		case ('Y'): {
			System.out.println("indirizzo fatturazione impostato uguale a quello di spedizione");
			IndirizzoUtente u = new IndirizzoUtente();
			u = i;
			u.cambiaIndirizzoType();
			this.indirizzi.add(i);
			this.indirizzi.add(u);

			break;
		}
		case ('N'): {
			System.out.println("Aggiungere indirizzo di fatturazione");
			System.out.println("Digitare CAP");
			String capUtente1 = scanner.nextLine();
			System.out.println();
			System.out.println("digitare la via");
			String viaUtente1 = scanner.nextLine();
			System.out.println();
			IndirizzoUtente u = new IndirizzoUtente(viaUtente1, capUtente1, this);
			u.cambiaIndirizzoType();
			this.indirizzi.add(i);
			this.indirizzi.add(u);
			break;
		}
		default: {
			System.out.println("scelta non valida, indirizzo fatturazione impostato uguale a quello di spedizione");
			IndirizzoUtente u = new IndirizzoUtente();
			u = i;
			u.cambiaIndirizzoType();
			this.indirizzi.add(i);
			this.indirizzi.add(u);
		}
		}

	}

	// GETTER E SETTER --------------------------------------------
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

	public void setIdUtete(long id) {
		this.idUtente = id;
	}

	public void setIndirizzoUtente(IndirizzoUtente indirizzo) {
		this.indirizzi.add(indirizzo);
	}

	public long getIdUtente() {
		return idUtente;
	}

	public List<IndirizzoUtente> getIndirizzi() {
		return this.indirizzi;
	}

	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}

}
