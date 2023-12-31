package CeuFct.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import CeuFct.modelo.Usuario;

public class UsuarioDao {
	public Long insertarUsuario(Connection conn, Usuario usuario) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			stmt = conn.prepareStatement(
					"INSERT into usuarios (email, password, nombre, apellidos, ciclo, activo) values (?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getPass());
			stmt.setString(3, usuario.getNombre());
			stmt.setString(4, usuario.getApellidos());
			stmt.setString(5, usuario.getCiclo());
			stmt.setBoolean(6, usuario.getActivo());
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

	public Usuario consultarUsuario(Connection conn, String email) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from usuarios where email=" + email;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString("email").equals(email)) {
					Usuario u = new Usuario();
					u.setId(rs.getLong("id_usuario"));
					u.setEmail(rs.getString("email"));
					u.setPass(rs.getString("password"));
					u.setNombre(rs.getString("nombre"));
					u.setApellidos(rs.getString("apellidos"));
					u.setCiclo(rs.getString("ciclo"));
					u.setActivo(rs.getBoolean("activo"));
					return u;
				}
			}
			return null;
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

	}

}
