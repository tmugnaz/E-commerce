package ecommerce;

import java.util.*;

public class Ordine {
	private String nome;
	private Utente utente;

	private STATO stato;
	private String indirizzoFatturazione;
	private String indirizzoSpedizione;
	private List<String> modalit‡Pagamento = new ArrayList<String>();
	private String pagamentoSelezionato;
	private List<RigaOrdine> righeOrdine = new ArrayList<RigaOrdine>();

	public Ordine(Utente utente, String nome, Scanner scanner) {
		this.nome = nome;
		this.utente = utente;
		addInitialModPagamento();
		sceltaModPagScanner(scanner);
		setIndirizzi(utente);
		this.stato = STATO.CREATO;
	}

	public Ordine(Utente utente, String nome) {
		this.nome = nome;
		this.utente = utente;
		setIndirizzi(utente);
		this.stato = STATO.CREATO;
	}

	public Ordine(Utente utente, String nome, String modPagamento) {
		this.nome = nome;
		this.utente = utente;
		this.addInitialModPagamento();

		this.checkModalit‡Pagamento(modPagamento);
		setIndirizzi(utente);
		this.stato = STATO.CREATO;

	}

	public void pagaOrdine() {
		this.stato = STATO.PAGATO;
	}

	public void spedisciOrdine() {
		this.stato = STATO.SPEDITO;

	}

	public void consegnaOrdine() {
		this.stato = STATO.CONSEGNATO;
	}

	public void setIndirizzi(Utente utente) {
		if (utente.getIndirizzi().isEmpty()) {
			System.out.println("nessun indirizzo!!" + "impostalo e riprova!");

		} else if (utente.getIndirizzi().size() == 1) {
			this.indirizzoFatturazione = this.utente.getIndirizzi().get(0).getIndirizzoVia()
					.concat(this.utente.getIndirizzi().get(0).getCAP());
			this.indirizzoSpedizione = this.indirizzoFatturazione;
		} else {
			for (IndirizzoUtente in : utente.getIndirizzi()) {
				if (in.getIndirizzotype() == INDIRIZZOTYPE.FATTURAZIONE) {
					this.indirizzoFatturazione = in.getIndirizzoVia().concat(in.getCAP());

				} else if (in.getIndirizzotype() == INDIRIZZOTYPE.SPEDIZIONE) {
					this.indirizzoSpedizione = in.getIndirizzoVia().concat(in.getCAP());

				}
			}
		}
	}

	public void addInitialModPagamento() {
		getModalit‡Pagamento().add("Bonifico Bancario");
		getModalit‡Pagamento().add("Carta di credito");
		getModalit‡Pagamento().add("Paypal");
	}

	public void info() {
		System.out.println("Ordine :" + getNome() + " Utente: " + getUtente().getCognome() + " "
				+ getUtente().getCognome() + " Indirizzo Spedizione: " + getIndirizzoSpedizione()
				+ " Indirizzo Fatturazione: " + getIndirizzoFatturazione() + " modalit‡ pagamento selezionata: "
				+ getPagamentoSelezionato() + " Stato ordine: " + getStato().name() + ";");
		stampaRigheOrdine(this);
	}

	public void stampaRigheOrdine(Ordine o) {
		for (RigaOrdine rg : o.getRigheOrdine()) {
			rg.info();
		}
	}

	public void creaRigaOrdine(Articolo articolo, int quantit‡, int iva, int sconto) {
		RigaOrdine rg = new RigaOrdine(this, articolo, quantit‡, iva, sconto);
		addRigaOrdine(rg);

	}

	public void addRigaOrdine(RigaOrdine rg) {
		this.righeOrdine.add(rg);
	}

	public void checkModalit‡Pagamento(String candidato) {
		for (String string : modalit‡Pagamento) {
			if (candidato == string) {
				this.setPagamentoSelezionato(candidato);
			} else {
				this.modalit‡Pagamento.add(candidato);
				this.setPagamentoSelezionato(candidato);
			}

		}
	}

	// METODI SCANNER PER INTERFACCIA UTENTE, SCELTA DI METODO DI PAGAMENTO
	public void sceltaModPagScanner(Scanner scanner) {
		int cont = 0;
		System.out.println("Modalit‡ pagamento correnti");
		for (String string : this.modalit‡Pagamento) {

			System.out.println(string + " " + cont);
			cont++;
		}
		System.out.println(
				"Selezionare la modalit‡ di pagamento, inserire \"3\" se si desidera inserire una nuova modalit‡");
		int sceltaUtente = scanner.nextInt();
		System.out.println();
		switch (sceltaUtente) {
		case (0): {
			System.out.println("hai scelto Bonfifico Bancario");
			this.setPagamentoSelezionato(this.modalit‡Pagamento.get(0));
			break;
		}
		case (1): {
			System.out.println("hai scelto Carta di Credito");
			this.setPagamentoSelezionato(this.modalit‡Pagamento.get(1));
			break;
		}
		case (2): {
			System.out.println("hai scelto Paypal");
			this.setPagamentoSelezionato(this.modalit‡Pagamento.get(2));
			break;
		}
		case (3): {
			System.out.println("Prego inserire metodo di pagamento alternativo");
			String metodoAlt = scanner.next();
			System.out.println();
			this.setPagamentoSelezionato(metodoAlt);
			break;
		}
		default: {
			System.out.println("scelta non valida ordine annullato");
			break;
		}
		}

	}

	/// GETTER E SETTER --------------------------------------------

	public void setPagamentoSelezionato(String scelta) {
		this.pagamentoSelezionato = scelta;

	}

	public List<String> getModalit‡Pagamento() {
		return modalit‡Pagamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setModalit‡Pagamento(List<String> modalit‡Pagamento) {
		this.modalit‡Pagamento = modalit‡Pagamento;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public STATO getStato() {
		return stato;
	}

	public void setStato(STATO stato) {
		this.stato = stato;
	}

	public String getIndirizzoFatturazione() {
		return indirizzoFatturazione;
	}

	public void setIndirizzoFatturazione(String indirizzoFatturazione) {
		this.indirizzoFatturazione = indirizzoFatturazione;
	}

	public String getIndirizzoSpedizione() {
		return indirizzoSpedizione;
	}

	public void setIndirizzoSpedizione(String indirizzoSpedizione) {
		this.indirizzoSpedizione = indirizzoSpedizione;
	}

	public List<RigaOrdine> getRigheOrdine() {
		return righeOrdine;
	}

	public void setRigheOrdine(List<RigaOrdine> righeOrdine) {
		this.righeOrdine = righeOrdine;
	}

	public String getPagamentoSelezionato() {
		return pagamentoSelezionato;
	}

}
