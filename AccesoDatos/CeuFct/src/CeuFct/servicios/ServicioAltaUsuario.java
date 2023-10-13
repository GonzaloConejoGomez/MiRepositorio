package CeuFct.servicios;

import java.sql.Connection;
import java.sql.SQLException;

import CeuFct.dao.UsuarioDao;
import CeuFct.modelo.Usuario;

public class ServicioAltaUsuario {
	private OpenConnection openConnection;

	public ServicioAltaUsuario() {
		openConnection = new OpenConnection();
	}

	public void registrarUsuario(Usuario usuario) throws SQLException {
		Connection conn = null;
		try {
			conn = openConnection.abrirConexion();
			conn.setAutoCommit(false);

			UsuarioDao dao = new UsuarioDao();

			if (dao.consultarUsuario(conn, usuario.getEmail()) == null) {
				dao.insertarUsuario(conn, usuario);
			} else {
				System.err.println("El usuario ya existe");
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
