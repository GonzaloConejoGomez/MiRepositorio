package ejemploJdbc1.servicios;

public class ActoresServiceException extends Exception {

	private static final long serialVersionUID = -6223341013420572966L;

	public ActoresServiceException() {
		super();

	}

	public ActoresServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public ActoresServiceException(String message, Throwable cause) {
		super(message, cause);

	}

	public ActoresServiceException(String message) {
		super(message);

	}

	public ActoresServiceException(Throwable cause) {
		super(cause);

	}

}
