package Ejercicio04.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import Ejercicio04.modelo.Pedido;

public class PedidosDao {

	public Long insertarPedido(Connection conn, Pedido pedido) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			stmt = conn.prepareStatement("INSERT into pedidos (fecha_pedido, fecha_entrega, cliente) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setDate(1, Date.valueOf(pedido.getFechaPedido()));
			stmt.setDate(2, Date.valueOf(pedido.getFechaEntrega()));
			stmt.setString(3, pedido.getCliente());
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			rs.next();
			Long id = rs.getLong(1);
			
			return id;
			

		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

	}

}
