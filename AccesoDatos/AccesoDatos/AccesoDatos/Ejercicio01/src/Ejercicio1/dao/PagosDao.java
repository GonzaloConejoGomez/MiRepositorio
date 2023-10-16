package Ejercicio1.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Ejercicio1.modelo.Pago;

public class PagosDao {

	public List<Pago> consultarPagos(Connection conn, Integer id) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Pago> pagos = new ArrayList<Pago>();
			String sql = "select * from payment where customer_id = "+ id;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Pago p = new Pago();
				p.setImporte(rs.getBigDecimal("amount"));
				p.setFecha(rs.getDate("payment_date"));
				pagos.add(p);
			}
			return pagos;
		}
		finally {
			try {
				stmt.close();
			}catch(Exception e) {}
		}
	
	}

}
