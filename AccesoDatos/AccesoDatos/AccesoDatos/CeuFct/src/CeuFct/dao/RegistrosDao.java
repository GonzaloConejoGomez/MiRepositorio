package CeuFct.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import CeuFct.modelo.Registro;

public class RegistrosDao {

	// Consulta un registro con id y una fecha, devuelve un registro. (Se hace
	// conPreparedStatement).
	public Registro consultarRegistroFecha(Connection conn, Long id, LocalDate fecha) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			String sql = "SELECT * from registros where id_usuario= ? and fecha = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.setDate(2, Date.valueOf(fecha));
			rs = stmt.executeQuery();
			Registro registro = new Registro();
			if (rs.next()) {
				registro.setId_registro(rs.getLong("id_registro"));
				registro.setId_usuario(rs.getLong("id_usuario"));
				registro.setFecha(rs.getDate("fecha").toLocalDate());
				registro.setNumHoras(rs.getInt("num_horas"));
				registro.setDescripcion(rs.getString("descripcion"));
				return registro;
			} else {
				return null;
			}
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}

	// Devuelve una lista con todos los registros.
	public List<Registro> consultarRegistro(Connection conn, Long id) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Registro> listaRegistro = new ArrayList<Registro>();
			String sql = "SELECT * from registros";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Registro registro = new Registro();
				registro.setId_registro(rs.getLong("id_registro"));
				registro.setId_usuario(rs.getLong("id_usuario"));
				registro.setFecha(rs.getDate("fecha").toLocalDate());
				registro.setNumHoras(rs.getInt("num_horas"));
				registro.setDescripcion(rs.getString("descripcion"));
				listaRegistro.add(registro);
			}
			return listaRegistro;
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}

	// Inserta un registro
	public long insertarRegistro(Connection conn, Registro registro) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT into registros (id_usuario, fecha, num_horas, descripcion) values (?,?,?,?)";
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, registro.getId_usuario());
			stmt.setDate(2, Date.valueOf(registro.getFecha()));
			stmt.setInt(3, registro.getNumHoras());
			stmt.setString(4, registro.getDescripcion());
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
