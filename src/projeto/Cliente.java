package projeto;

public class Cliente {
	private String nome;
	private String telefone;
	private String email;
	private String cartaoCredito;
	private Endereco endereco;
	private Pedido pedidos[];
	
	public Cliente(String nome, String telefone, String email, String cartaoCredito, Endereco endereco, Pedido pedidos[]) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cartaoCredito = cartaoCredito;
		this.endereco = endereco;
		this.pedidos = pedidos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(String cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Pedido[] getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedido[] pedidos) {
		this.pedidos = pedidos;
	}
}
