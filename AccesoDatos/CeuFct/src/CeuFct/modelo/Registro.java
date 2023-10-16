package CeuFct.modelo;

import java.time.LocalDate;

public class Registro {
	private Long id_registro;
	private Long id_usuario;
	private LocalDate fecha;
	private String nombre;
	private Integer numHoras;
	private String descripcion;

	public Long getId_registro() {
		return id_registro;
	}

	public void setId_registro(Long id_registro) {
		this.id_registro = id_registro;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumHoras() {
		return numHoras;
	}

	public void setNumHoras(Integer numHoras) {
		this.numHoras = numHoras;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
