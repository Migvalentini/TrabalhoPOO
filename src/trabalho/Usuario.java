package trabalho;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Usuario {
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
        return "Usuário: " + usuario + 
               ", Tipo: " + tipo;
    }

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
