package ecommerce;

public class RigaOrdine {
	
	private Articolo articolo;
	private int quantit� ;
	private int iva;
	private int prezzo;
	private int sconto;
	private Ordine ordine;
	
	
	public RigaOrdine (Ordine ordine, Articolo articolo, int quantit�, int iva, int sconto) {
		this.articolo=articolo;
		this.quantit�=quantit�;
		this.iva=iva;
		this.sconto=sconto;
		this.prezzo=this.articolo.getPrezzoUnitario();
		this.ordine = ordine;
	}
	
	public void info() {
		System.out.println("nome: " +this.getArticolo().getNome()+" prezzo: "+getPrezzo()+" quantit�: "+getQuantit�()+" iva: "
									+getIva()+" sconto: "+getSconto()+" codice:"+getArticolo().getCodice());
	}

	
	
	

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public Articolo getArticolo() {
		return articolo;
	}


	public void setArticolo(Articolo articolo) {
		this.articolo = articolo;
	}


	public int getQuantit�() {
		return quantit�;
	}


	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}


	public int getIva() {
		return iva;
	}


	public void setIva(int iva) {
		this.iva = iva;
	}


	public int getSconto() {
		return sconto;
	}


	public void setSconto(int sconto) {
		this.sconto = sconto;
	}
	
	
	

}
