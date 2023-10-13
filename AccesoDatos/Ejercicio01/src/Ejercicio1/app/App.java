package Ejercicio1.app;

import java.util.List;
import java.util.Map;

import Ejercicio1.modelo.Pago;
import Ejercicio1.servicios.ActoresServiceException;
import Ejercicio1.servicios.PagosService;

public class App {
	public static void main(String[] args) throws ActoresServiceException {
		PagosService service = new PagosService();
		Map<String, List<Pago>> pagos;
		try {
			pagos = service.consultarPagos();
			System.out.println(pagos.get("MARILYN.ROSS@sakilacustomer.org"));
		} catch (ActoresServiceException e) {
			e.printStackTrace();
		}
	}
}
