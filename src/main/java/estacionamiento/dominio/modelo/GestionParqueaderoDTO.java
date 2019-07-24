package estacionamiento.dominio.modelo;

import java.math.BigDecimal;
import java.util.Date;



public class GestionParqueaderoDTO {

	private Long idTransaccion;
	private Date fechaIngreso;
	private Date fechaSalida;
	private BigDecimal valorServicio;
	private Boolean estadoRegistro;
	private VehiculoDTO vehiculo;
	
	
	public GestionParqueaderoDTO() {
	}
	
	public GestionParqueaderoDTO(Long idTransaccion, Date fechaIngreso, Date fechaSalida, BigDecimal valorServicio,
			Boolean estadoRegistro, VehiculoDTO vehiculo) {
		this.idTransaccion = idTransaccion;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.valorServicio = valorServicio;
		this.estadoRegistro = estadoRegistro;
		this.vehiculo = vehiculo;
	}

	public Long getIdTransaccion() {
		return idTransaccion;
	}
	
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	
	public Date getFechaSalida() {
		return fechaSalida;
	}

	public BigDecimal getValorServicio() {
		return valorServicio;
	}

	public Boolean getEstadoRegistro() {
		return estadoRegistro;
	}

	public VehiculoDTO getVehiculo() {
		return vehiculo;
	}

	

}
