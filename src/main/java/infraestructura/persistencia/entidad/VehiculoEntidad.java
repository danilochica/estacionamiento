package infraestructura.persistencia.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Vehiculo")
public class VehiculoEntidad implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column (name = "ID_VEHICULO", nullable = false)
	private Long idTransaccion;
	
	@Column (name = "PLACA", nullable = false)
	private String placa;
	
	@Column (name = "TIPO_VEHICULO", nullable = false)
	private String tipoVehiculo;
	
	@Column (name = "CILINDRAJE", nullable = true)
	private Integer cilindraje;

	public Long getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(Long idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public Integer getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
	}

	public VehiculoEntidad(String placa, String tipoVehiculo, Integer cilindraje) {
		
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
	}
	
	
	
	

}
