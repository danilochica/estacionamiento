package dominio.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;



public class GestionParqueaderoDTO {

	private Long idTransaccion;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private BigDecimal valorServicio;
	private Boolean estadoRegistro;
	private VehiculoDTO vehiculo;
	
	
	
	public GestionParqueaderoDTO(Long idTransaccion, LocalDateTime fechaIngreso, LocalDateTime fechaSalida,
			BigDecimal valorServicio, Boolean estadoRegistro, VehiculoDTO vehiculo) {
		this.idTransaccion = idTransaccion;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.valorServicio = valorServicio;
		this.estadoRegistro = estadoRegistro;
		this.vehiculo = vehiculo;
	}

	public GestionParqueaderoDTO() {
	}

	public Long getIdTransaccion() {
		return idTransaccion;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public LocalDateTime getFechaSalida() {
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
