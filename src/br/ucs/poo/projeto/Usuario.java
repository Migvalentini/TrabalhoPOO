package br.ucs.poo.projeto;

public class Usuario {
	private String usuario;
    private String senha;
    private TipoUsuario tipo;

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
	
	/*
	public String toStringTxt() {
	    return usuario + ";" + senha + ";" + tipo + ";";
	}

	public static Usuario fromString(String linha) {
	    String[] partes = linha.split(";", 4);
	    String usuario = partes[0];
	    String senha = partes[1];
	    TipoUsuario tipo = TipoUsuario.valueOf(partes[2]);
	    
	    return new Usuario(usuario, senha, tipo);
	}
	*/
}
