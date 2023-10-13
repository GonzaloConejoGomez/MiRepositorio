package CeuFct.dao;

import java.sql.Connection;
import java.util.List;

import CeuFct.modelo.Fecha;
import CeuFct.modelo.Registro;

public class RegistrosDao {

	// Consulta un registro con id y una fecha, devuelve un registro. (Se hace conPreparedStatement).
	public Registro consultarRegistroFecha(Connection conn, Long id, Fecha fecha) {
		return null;
	}

	// Devuelve una lista con todos los registros.
	public List<Registro> consultarRegistro(Connection conn, Long id) {
		return null;
	}
	
	//Inserta un registro
	public long insertarRegistro(Connection conn, Registro registro) {
		return 0L;
	}
}
