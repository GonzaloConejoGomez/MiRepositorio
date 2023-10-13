package Ejercicio1.modelo;

import java.math.BigDecimal;
import java.sql.Date;


public class Pago {
	private BigDecimal importe;
	private Date fecha;

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Pago [importe=" + importe + ", fecha=" + fecha + "]";
	}

}
