package ejemploJdbc1.app;

import java.sql.SQLException;
import java.util.List;

import ejemploJdbc1.modelo.Actor;
import ejemploJdbc1.servicios.ActoresServiceException;
import ejemploJdbc1.servicios.ActoresServices;

public class App {
	public static void main(String[] args) throws SQLException, ActoresServiceException {
		ActoresServices service = new ActoresServices();
		List<Actor> actores = service.consultarActores();
		for (int i = 0; i < actores.size(); i++) {
			System.out.println(actores.get(i));
		}
		System.out.println("Fin");
	}
}
