package br.ucs.poo.projeto;

import java.util.ArrayList;
import java.util.Arrays;

public class Cliente extends Pessoa {
	private static int ultimoCodigo = 0;
	private int codigo;
	private String cartaoCredito;
	private ArrayList<Pedido> pedidos = new ArrayList<>();
	private Usuario usuario;
	
	public Cliente(String nome, String telefone, String email, String cartaoCredito, Endereco endereco, ArrayList<Pedido> pedidos, Usuario usuario) {
        super(nome, telefone, email, endereco);
        this.codigo = ultimoCodigo++;
        this.cartaoCredito = cartaoCredito;
        this.pedidos = pedidos;
        this.usuario = usuario;
    }

	public String getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(String cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", cartaoCredito=" + cartaoCredito + ", pedidos=" + pedidos + ", usuario="
				+ usuario + "]";
	}
	
	/*
    @Override
    public String toStringTxt() {
        return super.toStringTxt() + ";" + cartaoCredito;
    }

    public static Cliente fromString(String linha) {
        String[] partes = linha.split(";", 8);
        Pessoa pessoa = Pessoa.fromString(partes[0] + ";" + partes[1] + ";" + partes[2] + ";" + partes[3]);
        String cartaoCredito = partes[4];
        Usuario usuario = Usuario.fromString(partes[5] + ";" + partes[6]);

        return new Cliente(pessoa.getNome(), pessoa.getTelefone(), pessoa.getEmail(), cartaoCredito, pessoa.getEndereco(), new Pedido[0], usuario);
    }
    */
}
