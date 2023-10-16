package CeuFct.servicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import CeuFct.dao.RegistrosDao;
import CeuFct.modelo.Registro;

public class RegistroService {
	private OpenConnection openConnection;
	private RegistrosDao registroDao;

	public RegistroService() {
		openConnection = new OpenConnection();
		registroDao = new RegistrosDao();
	}

	// Consulta una lista de registros
	public List<Registro> consultarRegistro(Long id) {
		Connection conn = null;
		try {
			conn = openConnection.abrirConexion();
			return registroDao.consultarRegistro(conn, id);

		} catch (SQLException e) {
			System.out.println("Ha habido un error en la base de datos" + e.getMessage());
			e.printStackTrace();
			System.err.println("Error al obtener el registro de la base de datos");
			return null;
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

	// Consulta si existe un registro con el id usuario y la fecha y si es null
	// inserta.
	public void insertarRegistro(Registro registro) {

	}

}
