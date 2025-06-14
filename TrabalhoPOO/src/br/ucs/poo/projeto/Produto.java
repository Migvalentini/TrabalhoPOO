package br.ucs.poo.projeto;

import java.util.Objects;

public class Produto implements Comparable<Produto>{
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
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return codigo == other.codigo && Objects.equals(nome, other.nome);
	}

	@Override
	public int compareTo(Produto o) {
		Produto a= o;

		return this.nome.compareTo(a.nome);
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
