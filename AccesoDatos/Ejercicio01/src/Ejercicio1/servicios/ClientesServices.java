package Ejercicio1.servicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Ejercicio1.dao.ClientesDao;
import Ejercicio1.modelo.Cliente;

public class ClientesServices {

	private OpenConnection openConnection;

	public ClientesServices() {
		openConnection = new OpenConnection();
	}

	public Map<String, Cliente> consultarClientes() throws ClientesServiceException {
		Connection conn = null;
		try {
			conn = openConnection.abrirConexion();
			ClientesDao dao = new ClientesDao();
			Map<String, Cliente> clientesEmail = new HashMap<>();
			List<Cliente> clientes = dao.consultarClientes(conn);
			for (Integer i = 0; i < clientes.size(); i++) {
				clientesEmail.put(clientes.get(i).getEmail(), clientes.get(i));
			}
			return clientesEmail;
		} catch (SQLException e) {
			System.err.println("Ha habido un error en la base de datos: " + e.getMessage());
			throw new ClientesServiceException("Error al obtener clientes de la bbdd", e);

		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}

	}

}
