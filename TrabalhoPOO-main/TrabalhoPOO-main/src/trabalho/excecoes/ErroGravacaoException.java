package trabalho.excecoes;

public class ErroGravacaoException extends Exception {
	
	public static final String MESSAGE = "Ocorreu um erro salvando o conteudo JSON";

	public ErroGravacaoException() {
		super(MESSAGE);
	}

	public ErroGravacaoException(String message) {
		super(MESSAGE + " " + message);
	}

	public ErroGravacaoException(Throwable cause) {
		super(MESSAGE, cause);
	}

	public ErroGravacaoException(String message, Throwable cause) {
		super(MESSAGE + " " + message, cause);
	}

	public ErroGravacaoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(MESSAGE + " " + message, cause, enableSuppression, writableStackTrace);
	}

}
