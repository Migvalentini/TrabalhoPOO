package projeto;

public class Usuario {
	private String usuario;
    private String senha;
    private TipoUsuario tipo;
    private Cliente cliente;

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
	
	public String toStringTxt() {
	    String clienteStr = (cliente != null) ? cliente.toStringTxt() : "null";
	    return usuario + ";" + senha + ";" + tipo + ";" + clienteStr;
	}

	public static Usuario fromString(String linha) {
	    String[] partes = linha.split(";", 4);
	    String usuario = partes[0];
	    String senha = partes[1];
	    TipoUsuario tipo = TipoUsuario.valueOf(partes[2]);
	    Cliente cliente = partes[3].equals("null") ? null : Cliente.fromString(partes[3]);
	    
	    return new Usuario(usuario, senha, tipo, cliente);
	}

}
