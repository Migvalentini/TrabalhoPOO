package projeto;

import java.util.Scanner;

public class Produto {
	private static int ultimoCodigo = 0;
	private int codigo;
	private String nome;
	private String descricao;
	private Estoque estoque;
	
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
	
	public static Produto criarProduto(Estoque estoque, Scanner sc) {
		try {			
			System.out.println("Nome do produto:");
			String nome = sc.nextLine();
			System.out.println("Descrição:");
			String descricao = sc.nextLine();
			
			return new Produto(nome, descricao, estoque);
		} catch(Exception ex) {
			System.out.println("Erro ao cadastrar produto: " + ex);
			return null;
		}
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
}
