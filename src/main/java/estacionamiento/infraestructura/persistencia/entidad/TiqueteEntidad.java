package estacionamiento.infraestructura.persistencia.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name = "TIQUETE")
public class TiqueteEntidad implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column (name = "ID_TIQUETE", unique = true, nullable = false)
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
	
	public TiqueteEntidad(Long idTiquete, Date registroIngreso, Date registroSalida, BigDecimal valorServicio,
			Boolean estado, VehiculoEntidad idVehiculo) {
		this.idTiquete = idTiquete;
		this.registroIngreso = registroIngreso;
		this.registroSalida = registroSalida;
		this.valorServicio = valorServicio;
		this.estado = estado;
		this.idVehiculo = idVehiculo;
	}

	public Long getIdTiquete() {
		return idTiquete;
	}
	
	public Date getRegistroIngreso() {
		return registroIngreso;
	}

	public Date getRegistroSalida() {
		return registroSalida;
	}

	public BigDecimal getValorServicio() {
		return valorServicio;
	}

	public Boolean getEstado() {
		return estado;
	}

	public VehiculoEntidad getIdVehiculo() {
		return idVehiculo;
	}

	public TiqueteEntidad() {
	}
	
	
	
}