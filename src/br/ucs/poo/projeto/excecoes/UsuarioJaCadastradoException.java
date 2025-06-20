package br.ucs.poo.projeto.excecoes;

public class UsuarioJaCadastradoException extends Exception {
public static final String MESSAGE = "Erro: Usuário Já Cadastrado!";
	
	public UsuarioJaCadastradoException() {
		super(MESSAGE);
	}

	public UsuarioJaCadastradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(MESSAGE + " " + message, cause, enableSuppression, writableStackTrace);
	}

	public UsuarioJaCadastradoException(String message, Throwable cause) {
		super(MESSAGE + " " + message, cause);
	}

	public UsuarioJaCadastradoException(String message) {
		super(MESSAGE + " " + message);
	}

	public UsuarioJaCadastradoException(Throwable cause) {
		super(MESSAGE, cause);
	}
}
