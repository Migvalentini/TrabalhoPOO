package trabalho.excecoes;

@SuppressWarnings("serial")
public class RegistroNaoEncontradoException extends Exception {
	public static final String MESSAGE = "Registro Não Encontrado";
	
	public RegistroNaoEncontradoException() {
		super(MESSAGE);
	}

	public RegistroNaoEncontradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(MESSAGE + " " + message, cause, enableSuppression, writableStackTrace);
	}

	public RegistroNaoEncontradoException(String message, Throwable cause) {
		super(MESSAGE + " " + message, cause);
	}

	public RegistroNaoEncontradoException(String message) {
		super("Registro de " + message + " Não Encontrado!");
	}

	public RegistroNaoEncontradoException(Throwable cause) {
		super(MESSAGE, cause);
	}
}
