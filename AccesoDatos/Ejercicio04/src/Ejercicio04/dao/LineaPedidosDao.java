package Ejercicio04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import Ejercicio04.modelo.LineaPedido;

public class LineaPedidosDao {

	public void insertarLineasPedido(Connection conn, LineaPedido lineaPedido) throws SQLException {
		PreparedStatement pstmt = null;
		
		
		
		
		try {
			
			pstmt = conn.prepareStatement("insert into pedidos_lineas values (?,?,?,?)");
			pstmt.setLong(1, lineaPedido.getIdPedido());
			pstmt.setInt(2, lineaPedido.getNumeroLinea());
			pstmt.setString(3, lineaPedido.getArticulo());
			pstmt.setBigDecimal(4, lineaPedido.getPrecio());
			pstmt.executeUpdate();
			
				  
			
			
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				
			}
		}

	}

}
