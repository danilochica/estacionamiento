package estacionamiento.testdatabuider;

import java.math.BigDecimal;
import java.util.Date;

import estacionamiento.dominio.modelo.GestionParqueaderoDTO;
import estacionamiento.dominio.modelo.VehiculoDTO;

public class GestionParqueaderoTestDataBuilder {
	
	private Long idTransaccion;
	private Date fechaIngreso;
	private Date fechaSalida;
	private BigDecimal valorServicio;
	private boolean estadoRegistro;
	private VehiculoDTO vehiculo;
	
	public GestionParqueaderoTestDataBuilder conIdTransaccion(Long idTransaccion) {
		this.idTransaccion = idTransaccion;
		return this;
	}
	
	public GestionParqueaderoTestDataBuilder conFechaDeIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}
	
	public GestionParqueaderoTestDataBuilder conFechaDeSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}
	
	public GestionParqueaderoTestDataBuilder conValorDeServicio(BigDecimal valorServicio) {
		this.valorServicio = valorServicio;
		return this;
	}
	
	public GestionParqueaderoTestDataBuilder conEstadoRegistro(boolean estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
		return this;
	}
	
	public GestionParqueaderoTestDataBuilder conVehiculo(VehiculoDTO vehiculo) {
		this.vehiculo = vehiculo;
		return this;
	}
	
	public GestionParqueaderoDTO build() {
		return new GestionParqueaderoDTO(this.idTransaccion, this.fechaIngreso, this.fechaSalida, this.valorServicio, this.estadoRegistro, this.vehiculo);
	}
}
