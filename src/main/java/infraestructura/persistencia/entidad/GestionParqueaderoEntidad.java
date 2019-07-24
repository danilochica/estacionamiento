package infraestructura.persistencia.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "GestionParqueadero")
public class GestionParqueaderoEntidad implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column (name = "ID_TRANSACCION", nullable = false)
	private Long idTransaccion;
	
	@Column (name = "REGISTRO_INGRESO", nullable = false)
	private Date registroIngreso;
	
	@Column (name = "REGISTRO_SALIDA", nullable = false)
	private Date registroSalida;

	@Column (name = "VALOR_SERVICIO", nullable = false)
	private BigDecimal valorServicio;

	@Column (name = "ESTADO", nullable = false)
	private Boolean estado;
	
	@Column (name = "VEHICULO", nullable = false)
	private VehiculoEntidad vehiculo;

	public GestionParqueaderoEntidad() {
		
	}
	
	public GestionParqueaderoEntidad(Long idTransaccion, Date registroIngreso, Date registroSalida,
			BigDecimal valorServicio, Boolean estado, VehiculoEntidad vehiculo) {
		this.idTransaccion = idTransaccion;
		this.registroIngreso = registroIngreso;
		this.registroSalida = registroSalida;
		this.valorServicio = valorServicio;
		this.estado = estado;
		this.vehiculo = vehiculo;
	}

	public Long getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(Long idTransaccion) {
		this.idTransaccion = idTransaccion;
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

	public VehiculoEntidad getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoEntidad vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	
	
	
}
