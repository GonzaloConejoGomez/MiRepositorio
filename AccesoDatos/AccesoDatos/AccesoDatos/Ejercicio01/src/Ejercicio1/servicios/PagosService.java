package Ejercicio1.servicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Ejercicio1.dao.ClientesDao;
import Ejercicio1.dao.PagosDao;
import Ejercicio1.modelo.Cliente;
import Ejercicio1.modelo.Pago;

public class PagosService {

	private OpenConnection openConnection;

	public PagosService() {
		openConnection = new OpenConnection();
	}

	public Map<String, List<Pago>> consultarPagos() throws ActoresServiceException {
		Connection conn = null;
		try {
			conn = openConnection.abrirConexion();
			ClientesDao daoCliente = new ClientesDao();
			PagosDao daoPago = new PagosDao();
			List<Cliente> clientes = daoCliente.consultarClientes(conn);
			List<Pago> pagos = new ArrayList<>();
			Map<String, List<Pago>> mapaPagos = new HashMap<>();
			for(Integer i = 0; i<clientes.size(); i++) {
				pagos = daoPago.consultarPagos(conn, clientes.get(i).getId());
				mapaPagos.put(clientes.get(i).getEmail(), pagos);
				
			}
			return mapaPagos;
			
		} catch (SQLException e) {
			System.err.println("Ha habido un error en la base de datos: " + e.getMessage());
			throw new ActoresServiceException("Error al obtener actores de la bbdd", e);

		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}

	}

}
