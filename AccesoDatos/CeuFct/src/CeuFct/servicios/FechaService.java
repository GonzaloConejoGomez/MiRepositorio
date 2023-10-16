package CeuFct.servicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import CeuFct.dao.FechasDao;
import CeuFct.excepciones.FechaException;
import CeuFct.modelo.Fecha;

public class FechaService {
	private OpenConnection openConnection;
	private Integer año;
	private Integer evaluacion;

	public FechaService() {
		openConnection = new OpenConnection();
		año = 0;
		evaluacion = 0;
	}

	// Consulta y devuelve una lista de fechas
	public List<Fecha> consultarFecha() throws FechaException {
		Connection conn = null;
		List<Fecha> listFechas = new ArrayList<Fecha>();
		try {
			conn = openConnection.abrirConexion();

			año = LocalDate.now().getYear();
			if (LocalDate.now().getMonthValue() >= 9 || LocalDate.now().getMonthValue() <= 12) {
				evaluacion = 1;
			} else if (LocalDate.now().getMonthValue() == 1 || LocalDate.now().getMonthValue() == 3) {
				evaluacion = 2;
			} else if (LocalDate.now().getMonthValue() > 3 || LocalDate.now().getMonthValue() <= 6) {
				evaluacion = 3;
			} else {
				throw new FechaException();
			}
			FechasDao fechaDao = new FechasDao();
			listFechas = fechaDao.consultarRegistroFecha(conn, año, evaluacion);

		} catch (SQLException e) {
			System.out.println("Ha habido un error en la base de datos" + e.getMessage());
			e.printStackTrace();
			System.err.println("Error al obtener el usuario de la base de datos");
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}

		}
		return listFechas;
	}
}
