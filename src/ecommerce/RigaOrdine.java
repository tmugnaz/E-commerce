package ecommerce;

public class RigaOrdine {
	
	private Articolo articolo;
	private int quantità ;
	private int iva;
	private int sconto;
	
	
	public RigaOrdine (Articolo articolo, int quantità, int iva, int sconto) {
		this.articolo=articolo;
		this.quantità=quantità;
		this.iva=iva;
		this.sconto=sconto;
	}
	
	
	

}
