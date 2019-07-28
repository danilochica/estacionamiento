package estacionamiento.infraestructura.persistencia.entidad;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name = "TIQUETE")
public class TiqueteEntidad{

	@Id
	@GeneratedValue
	@Column (name = "ID_TIQUETE", nullable = false)
	private Long idTiquete;
	
	@Column (name = "REGISTRO_INGRESO", nullable = false)
	private Date registroIngreso;
	
	@Column (name = "REGISTRO_SALIDA", nullable = true)
	private Date registroSalida;

	@Column (name = "VALOR_SERVICIO", nullable = true)
	private BigDecimal valorServicio;

	@Column (name = "ESTADO", nullable = false)
	private Boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "ID_VEHICULO", nullable = false)
	private VehiculoEntidad idVehiculo;

	public Long getIdTiquete() {
		return idTiquete;
	}

	public void setIdTiquete(Long idTiquete) {
		this.idTiquete = idTiquete;
	}

	public Date getRegistroIngreso() {
		return registroIngreso;
	}

	public void setRegistroIngreso(Date registroIngreso) {
		this.registroIngreso = registroIngreso;
	}

	public Date getRegistroSalida() {
		return registroSalida;
	}

	public void setRegistroSalida(Date registroSalida) {
		this.registroSalida = registroSalida;
	}

	public BigDecimal getValorServicio() {
		return valorServicio;
	}

	public void setValorServicio(BigDecimal valorServicio) {
		this.valorServicio = valorServicio;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public VehiculoEntidad getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(VehiculoEntidad idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public TiqueteEntidad(Long idTiquete, Date registroIngreso, Date registroSalida, BigDecimal valorServicio,
			Boolean estado, VehiculoEntidad idVehiculo) {
		this.idTiquete = idTiquete;
		this.registroIngreso = registroIngreso;
		this.registroSalida = registroSalida;
		this.valorServicio = valorServicio;
		this.estado = estado;
		this.idVehiculo = idVehiculo;
	}
	
	

	
	
}