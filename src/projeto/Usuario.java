package projeto;

import java.util.Scanner;

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
    
    public static Usuario criarUsuario(Scanner sc, TipoUsuario tipo) {
		try {			
			System.out.println("Usuário:");
			String usuario = sc.nextLine();
			System.out.println("Senha:");
			String senha = sc.nextLine();
			
			return new Usuario(usuario, senha, tipo);
		} catch(Exception ex) {
			System.out.println("Erro ao cadastrar endereço: " + ex);
			return null;
		}
    }

	@Override
	public String toString() {
		return "Usuário: " + usuario + " Senha: " + senha + " Tipo: " + tipo;
	}
	
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
}
