package projeto;

import java.util.Arrays;

public class Cliente {
	private static int ultimoCodigo = 0;
	private int codigo;
	private String nome;
	private String telefone;
	private String email;
	private String cartaoCredito;
	private Endereco endereco;
	private Pedido pedidos[];
	
	public Cliente(String nome, String telefone, String email, String cartaoCredito, Endereco endereco, Pedido pedidos[]) {
		this.codigo = ultimoCodigo++;
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

	@Override
	public String toString() {
		return "Cliente:\nCódigo=" + codigo + " Nome=" + nome + " Telefone=" + telefone + " Email=" + email
				+ " CartãoCrédito=" + cartaoCredito + " Endereco=" + endereco + " Pedidos="
				+ Arrays.toString(pedidos);
	}
	
	public String toStringTxt() {
	    String enderecoStr = (endereco != null) ? endereco.toStringTxt() : "null";
	    return nome + ";" + telefone + ";" + email + ";" + cartaoCredito + ";" + enderecoStr;
	}

	public static Cliente fromString(String linha) {
	    String[] partes = linha.split(";", 9);
	    String nome = partes[0];
	    String telefone = partes[1];
	    String email = partes[2];
	    String cartaoCredito = partes[3];
	    
	    Endereco endereco = Endereco.fromString(
	        partes[4] + ";" + partes[5] + ";" + partes[6] + ";" + partes[7] + ";" + partes[8] + ";" + partes[9] + ";" + partes[10]
	    );

	    return new Cliente(nome, telefone, email, cartaoCredito, endereco, new Pedido[0]);
	}

}
