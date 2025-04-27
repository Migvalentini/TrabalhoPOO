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
	
	public static Produto criarProduto(Scanner sc) {
        System.out.println("Nome do fornecedor:");
        String nome = sc.nextLine();
        System.out.println("Descrição:");
        String descricao = sc.nextLine();
        
        return new Produto(nome, descricao, null);
    }

	@Override
	public String toString() {
		return "Produto:\nCódigo=" + codigo + " Nome=" + nome + " Descricao=" + descricao + " Estoque=" + estoque;
	}
	
	
}
