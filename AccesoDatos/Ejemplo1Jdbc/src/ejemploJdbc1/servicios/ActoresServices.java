package ejemploJdbc1.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejemploJdbc1.modelo.Actor;

public class ActoresServices {
	private OpenConnection openConn;

	public ActoresServices() {
		openConn = new OpenConnection();

	}

	public List<Actor> consultarActores() throws ActoresServiceException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Actor> resultados = new ArrayList<>();

		ResultSet rs = null;
		conn = openConn.getNewConnection();
		try {
			stmt = conn.prepareStatement("SELECT * FROM actor");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Actor actor1 = new Actor();
				actor1.setId(rs.getInt("actor_id"));
				actor1.setNombre(rs.getString("first_name"));
				actor1.setApellidos(rs.getString("last_name"));

				resultados.add(actor1);

			}
		} catch (SQLException e) {
			System.err.println("Ha habido un error en la base de datos: " + e.getMessage());
			e.printStackTrace();
			throw new ActoresServiceException("error al obtener actores");

		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {}

		}

		return resultados;

	}
}
