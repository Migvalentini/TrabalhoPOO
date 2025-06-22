package trabalho.excecoes;

public class ErroLeituraException extends Exception {
	
	public static final String MESSAGE = "Ocorreu um erro lendo o conteudo do JSON";

	public ErroLeituraException() {
		super(MESSAGE);
	}

	public ErroLeituraException(String message) {
		super(MESSAGE + " " + message);
	}

	public ErroLeituraException(Throwable cause) {
		super(MESSAGE, cause);
	}

	public ErroLeituraException(String message, Throwable cause) {
		super(MESSAGE + " " + message, cause);
	}

	public ErroLeituraException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(MESSAGE + " " + message, cause, enableSuppression, writableStackTrace);
	}

}
