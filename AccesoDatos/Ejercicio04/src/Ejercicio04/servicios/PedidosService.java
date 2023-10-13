package Ejercicio04.servicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Ejercicio04.dao.LineaPedidosDao;
import Ejercicio04.dao.PedidosDao;
import Ejercicio04.modelo.LineaPedido;
import Ejercicio04.modelo.Pedido;



public class PedidosService {

	private OpenConnection openConnection;

	public PedidosService() {
		openConnection = new OpenConnection();
	}

	public void registrarPedido(Pedido pedido) throws SQLException {
		Connection conn = null;
		try {
			conn = openConnection.abrirConexion();
			conn.setAutoCommit(false);
			PedidosDao insertarPedido = new PedidosDao();
			LineaPedidosDao insertarLineas = new LineaPedidosDao();
			Long id = insertarPedido.insertarPedido(conn, pedido);
			List<LineaPedido> lineas = pedido.getLineasPedido();
			for(Integer i = 0; i<pedido.getLineasPedido().size(); i++) {
				lineas.get(i).setIdPedido(id);
				insertarLineas.insertarLineasPedido(conn, lineas.get(i));
			}
			conn.commit();
			
		} catch (SQLException e) {
			System.err.println("Ha habido un error en la base de datos: " + e.getMessage());
			conn.rollback();

		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}

	}

}
