package ejemploJdbc2.servicios;

public class ActoresServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6692629904708728907L;

	public ActoresServiceException() {
	}

	public ActoresServiceException(String message) {
		super(message); 
	}

	public ActoresServiceException(Throwable cause) {
		super(cause);
	}

	public ActoresServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ActoresServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
