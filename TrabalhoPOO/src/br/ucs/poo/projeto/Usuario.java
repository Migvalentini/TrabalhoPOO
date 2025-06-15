package br.ucs.poo.projeto;

import java.util.Objects;

public class Usuario implements Comparable<Usuario>{
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
