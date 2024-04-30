package ecommerce;

public class RigaOrdine {
	
	private Articolo articolo;
	private int quantità ;
	private int iva;
	private int prezzo;
	private int sconto;
	private Ordine ordine;
	
	
	public RigaOrdine (Ordine ordine, Articolo articolo, int quantità, int iva, int sconto) {
		this.articolo=articolo;
		this.quantità=quantità;
		this.iva=iva;
		this.sconto=sconto;
		this.prezzo=this.articolo.getPrezzoUnitario();
		this.ordine = ordine;
	}
	
	public void info() {
		System.out.println("nome: " +this.getArticolo().getNome()+" prezzo: "+getPrezzo()+" quantità: "+getQuantità()+" iva: "
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


	public int getQuantità() {
		return quantità;
	}


	public void setQuantità(int quantità) {
		this.quantità = quantità;
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
