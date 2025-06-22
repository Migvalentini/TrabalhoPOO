package trabalho;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Usuario implements Comparable<Usuario> {
	private Cliente cliente;
	private String usuario;
    private String senha;
    private TipoUsuario tipo;

    public Usuario() {
    	
    }
    
    public Usuario(String usuario, String senha, TipoUsuario tipo) {
        this.usuario = usuario;
        this.senha = senha;
        this.tipo = tipo;
    }
    
	public String getUsuario() { 
    	return usuario; 
    }
    
    public String getSenha() { 
    	return senha; 
    }
    
    public TipoUsuario getTipo() { 
    	return tipo; 
    }

	@Override
	public String toString() {
		return "Usuário: " + usuario + " Senha: " + senha + " Tipo: " + tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(usuario, other.usuario);
	}

	@Override
	public int compareTo(Usuario o) {
		return this.usuario.compareTo(o.usuario);
	}

}
