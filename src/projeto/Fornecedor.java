package projeto;

public class Fornecedor {
	private String nome;
	private String descricao;
	private String telefone;
	private String email;
	private Endereco endereco;
	private Produto produtos[];
	
	public Fornecedor(String nome, String descricao, String telefone, String email, Endereco endereco, Produto produtos[]) {
		this.nome = nome;
		this.descricao = descricao;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.produtos = produtos;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Produto[] getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produtos[]) {
		this.produtos = produtos;
	}
}
