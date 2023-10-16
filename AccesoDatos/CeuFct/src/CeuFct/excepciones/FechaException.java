package CeuFct.excepciones;

public class FechaException extends Exception {

	private static final long serialVersionUID = -8768049204755475544L;

	public FechaException() {
	}

	public FechaException(String message) {
		super(message);
	}

	public FechaException(Throwable cause) {
		super(cause);
	}

	public FechaException(String message, Throwable cause) {
		super(message, cause);
	}

	public FechaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
