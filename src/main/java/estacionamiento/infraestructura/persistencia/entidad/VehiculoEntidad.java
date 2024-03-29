package estacionamiento.infraestructura.persistencia.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "VEHICULO")
public class VehiculoEntidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VEHICULO",unique = true, nullable = false)
	private long idVehiculo;
	
	@Column(name = "TIPO_VEHICULO", nullable = false)
	private String tipoVehiculo;
	
	@Column(name = "CILINDRAJE", nullable = true)
	private int cilindraje;
	
	@Column(name = "PLACA", nullable = false)
	private String placa;
	
	
	public long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public VehiculoEntidad(long idVehiculo, String tipoVehiculo, int cilindraje, String placa) {
		this.idVehiculo = idVehiculo;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.placa = placa;
	}

	public VehiculoEntidad() {
	}
	
	
	
	
}
