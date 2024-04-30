package ecommerce;

public class Articolo {
	private String nome;
	private String codice;
	private int prezzoUnitario;
	private CATEGORIA_PRODOTTO categoria;
	

	public Articolo(String nome, String codice, int prezzoUnitario) {
		super();
		this.nome = nome;
		this.codice = codice;
		this.prezzoUnitario = prezzoUnitario;
		this.categoria= CATEGORIA_PRODOTTO.setDefaultCategoria();
	}
	
	public void cambiaCategoria(String nomeCategoria) {
		for (CATEGORIA_PRODOTTO categoria: CATEGORIA_PRODOTTO.values()) {
			if(categoria.getNomeCategoria().equalsIgnoreCase(nomeCategoria)) {
				this.setCategoria(categoria);
			}
			else {
				System.out.println("categoria non trovata");
				
			}
			
		}
		
	}
	///GETTER E SETTER --------------------
	
	public CATEGORIA_PRODOTTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CATEGORIA_PRODOTTO categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public int getPrezzoUnitario() {
		return prezzoUnitario;
	}
	public void setPrezzoUnitario(int prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}
	
}
