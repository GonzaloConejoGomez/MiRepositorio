package CeuFct.servicios;

import java.sql.Connection;
import java.sql.SQLException;

import CeuFct.dao.UsuarioDao;
import CeuFct.modelo.Usuario;

public class ServicioLogin {
	private OpenConnection openConnection;

	public ServicioLogin() {
		openConnection = new OpenConnection();
	}

	public Usuario loginUsuario(String email, String pass) throws SQLException {
		Connection conn = null;

		try {
			conn = openConnection.abrirConexion();
			UsuarioDao dao = new UsuarioDao();
			if (dao.consultarUsuario(conn, email) != null && dao.consultarUsuario(conn, email).getPass().equals(pass)) {
				System.out.println("Login correcto");
				return dao.consultarUsuario(conn, email);
			} else {
				System.err.println("Email o contraseña incorrectas");
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Ha habido un error en la base de datos: " + e.getMessage());
			return null;

		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
		

	}

}
