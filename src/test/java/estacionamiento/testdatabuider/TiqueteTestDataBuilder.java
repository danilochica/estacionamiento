package estacionamiento.testdatabuider;

import java.math.BigDecimal;
import java.util.Date;

import estacionamiento.dominio.modelo.Tiquete;
import estacionamiento.dominio.modelo.Vehiculo;

public class TiqueteTestDataBuilder {
	
	private Long idTiquete;
	private Date fechaIngreso;
	private Date fechaSalida;
	private BigDecimal valorServicio;
	private boolean estadoRegistro;
	private Vehiculo vehiculo;
	
	public TiqueteTestDataBuilder conIdTransaccion(Long idTiquete) {
		this.idTiquete = idTiquete;
		return this;
	}
	
	public TiqueteTestDataBuilder conFechaDeIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}
	
	public TiqueteTestDataBuilder conFechaDeSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}
	
	public TiqueteTestDataBuilder conValorDeServicio(BigDecimal valorServicio) {
		this.valorServicio = valorServicio;
		return this;
	}
	
	public TiqueteTestDataBuilder conEstadoRegistro(boolean estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
		return this;
	}
	
	public TiqueteTestDataBuilder conVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		return this;
	}
	
	public Tiquete build() {
		return new Tiquete(this.idTiquete, this.fechaIngreso, this.fechaSalida, this.valorServicio, this.estadoRegistro, this.vehiculo);
	}
}
