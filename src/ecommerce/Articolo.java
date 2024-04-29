package ecommerce;

public class Articolo extends CategoriaMerceologica{
	private String nome;
	private String codice;
	private int prezzoUnitario;

	public Articolo(String nome, String codice, int prezzoUnitario) {
		super();
		this.nome = nome;
		this.codice = codice;
		this.prezzoUnitario = prezzoUnitario;
	}
	
	
	public void setCodiceCategoria(String codice) {
		this.codiceCategoria = codice;
	}
	public void setNomeCategoria (String nome) {
		this.nomeCategoria = nome;
	}
	
	public String getCodiceCategoria() {
		return this.codiceCategoria;
		
	}
	public String getNomeCategoria() {
		return this.nomeCategoria;
		
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
