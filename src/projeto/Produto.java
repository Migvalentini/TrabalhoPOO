package projeto;

public class Produto {
	private String nome;
	private String descricao;
	private Estoque estoque;
	
	public Produto(String nome, String descricao, Estoque estoque) {
		this.nome = nome;
		this.descricao = descricao;
		this.estoque = estoque;
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
	
	
}
