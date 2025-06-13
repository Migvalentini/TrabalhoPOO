package br.ucs.poo.projeto;

public class Produto {
	private static int ultimoCodigo = 0;
	private int codigo;
	private String nome;
	private String descricao;
	private Estoque estoque;
	
	public Produto() {
		this.codigo = ultimoCodigo++;
	}
	
	public Produto(String nome, String descricao, Estoque estoque) {
		this.codigo = ultimoCodigo++;
		this.nome = nome;
		this.descricao = descricao;
		this.estoque = estoque;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    
	    sb.append("\nProduto:");
	    sb.append("\n  Código: ").append(codigo);
	    sb.append("\n  Nome: ").append(nome);
	    sb.append("\n  Descrição: ").append(descricao);
	    
	    if (estoque != null) {
	        sb.append("\n  Estoque: ").append(estoque.toString());
	    } else {
	        sb.append("\n  Estoque: Não informado");
	    }
	    
	    return sb.toString();
	}
	
	/*
	public String toStringTxt() {
	    String estoqueStr = (estoque != null) ? estoque.toStringTxt() : "null";
	    return codigo + ";" + nome + ";" + descricao + ";" + estoqueStr;
	}

	public Produto fromString(String linha) {
	    String[] partes = linha.split(";", 6); 

	    int codigo = Integer.parseInt(partes[0]);
	    String nome = partes[1];
	    String descricao = partes[2];
	    
	    Estoque estoque = partes[3].equals("null") 
	        ? null 
	        : Estoque.fromString(partes[3] + ";" + partes[4] + ";" + partes[5]);

	    Produto produto = new Produto(nome, descricao, estoque);
	    produto.setCodigo(codigo);

	    return produto;
	}
	*/
}
