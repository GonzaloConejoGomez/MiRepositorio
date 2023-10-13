package Ejercicio1.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Ejercicio1.modelo.Cliente;

public class ClientesDao {

	public List<Cliente> consultarClientes(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();
			String sql = "select * from customer";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getInt("customer_id"));
				c.setFirstName(rs.getString("first_name"));
				c.setLastName(rs.getString("last_name"));
				c.setEmail(rs.getString("email"));
				c.setActivo(rs.getInt("active") == 1);
				clientes.add(c);
			}
			return clientes;
		}
		finally {
			try {
				stmt.close();
			}catch(Exception e) {}
		}
	
	}

}
