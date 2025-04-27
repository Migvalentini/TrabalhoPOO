package projeto;

public class Usuario {
	private String usuario;
    private String senha;
    private TipoUsuario tipo; // "ADMIN" ou "CLIENTE"
    private Cliente cliente; // se for cliente, associa o objeto Cliente aqui

    public Usuario(String usuario, String senha, TipoUsuario tipo, Cliente cliente) {
        this.usuario = usuario;
        this.senha = senha;
        this.tipo = tipo;
        this.cliente = cliente;
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
    
    public Cliente getCliente() { 
    	return cliente; 
    }

	@Override
	public String toString() {
		return "Usuário: " + usuario + " Senha: " + ("*".repeat(senha.length())) + " Tipo: " + tipo + " Cliente: " + cliente;
	}
}
