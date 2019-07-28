package estacionamiento.dominio.modelo;

import java.math.BigDecimal;
import java.util.Date;



public class Tiquete {

	private Long idTiquete;
	private Date fechaIngreso;
	private Date fechaSalida;
	private BigDecimal valorServicio;
	private Boolean estadoRegistro;
	private Vehiculo vehiculo;
	
	public Long getIdTiquete() {
		return idTiquete;
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

	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	public Tiquete(Long idTiquete, Date fechaIngreso, Date fechaSalida, BigDecimal valorServicio,
			Boolean estadoRegistro, Vehiculo vehiculo) {
		this.idTiquete = idTiquete;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.valorServicio = valorServicio;
		this.estadoRegistro = estadoRegistro;
		this.vehiculo = vehiculo;
	}

	public Tiquete(Date fechaIngreso, Boolean estadoRegistro, Vehiculo vehiculo) {
		this.fechaIngreso = fechaIngreso;
		this.estadoRegistro = estadoRegistro;
		this.vehiculo = vehiculo;
	}
	
	
	
	
	

}
