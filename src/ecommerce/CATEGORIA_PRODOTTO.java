package ecommerce;

public enum CATEGORIA_PRODOTTO {
	
	CATEGORIA_0("prodotto"), 
	CATEGORIA_1("CARNE", CATEGORIA_0), 
	CATEGORIA_1_1("POLLO",CATEGORIA_1), 
	CATEGORIA_2("VERDURA", CATEGORIA_0), 
	CATEGORIA_2_2("LATTUGA", CATEGORIA_2);
	
	private String nome;
	private CATEGORIA_PRODOTTO categoriaMadre;

	private CATEGORIA_PRODOTTO(String nome, CATEGORIA_PRODOTTO categoriaMadre) {
		this.nome = nome;
		this.categoriaMadre = categoriaMadre;
	}

	private CATEGORIA_PRODOTTO(String nome) {
		this.nome = nome;
	}

	private CATEGORIA_PRODOTTO() {
	}

	public String getNomeCategoria() {
		return this.nome;
	}

	public CATEGORIA_PRODOTTO getCategoriaMadre() {
		return categoriaMadre;
	}

	public  static void categorieLista() {
		for (CATEGORIA_PRODOTTO categoria : CATEGORIA_PRODOTTO.values()) {
			System.out.println("categoria :" + categoria.name() + "nome :" + categoria.getNomeCategoria() + "sottocategoria di :"
					+ categoria.getCategoriaMadre().getNomeCategoria() + ";");

		}
	}
	
	public static CATEGORIA_PRODOTTO setDefaultCategoria() {
		return CATEGORIA_PRODOTTO.CATEGORIA_0;
	}



}
