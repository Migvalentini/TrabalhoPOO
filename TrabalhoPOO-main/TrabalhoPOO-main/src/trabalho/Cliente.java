package trabalho;

import java.util.ArrayList;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Cliente extends Pessoa {
	private static int ultimoCodigo = 0;
	private int codigo;
	private String cartaoCredito;
	private ArrayList<Pedido> pedidos = new ArrayList<>();
	private Usuario usuario;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String telefone, String email, String cartaoCredito, Endereco endereco, ArrayList<Pedido> pedidos, Usuario usuario) {
        super(nome, telefone, email, endereco);
        this.codigo = ultimoCodigo++;
        this.cartaoCredito = cartaoCredito;
        this.pedidos = pedidos;
        this.usuario = usuario;
    }
	
	

	public static void setUltimoCodigo(int ultimoCodigo) {
		Cliente.ultimoCodigo = ultimoCodigo;
	}

	public int getCodigo() {
		return codigo;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(codigo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return codigo == other.codigo;
	}

	public int compareTo(Cliente o) {
		return this.codigo -o.codigo;
	}

}
