package Ejercicio1.servicios;

public class ClientesServiceException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2613223404937270510L;

	public ClientesServiceException() {
		super();
		
	}

	public ClientesServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public ClientesServiceException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ClientesServiceException(String message) {
		super(message);
		
	}

	public ClientesServiceException(Throwable cause) {
		super(cause);
		
	}

	

}
