package estacionamiento.dominio.modelo;

public class Vehiculo {
	
	private long idVehiculo;
	private String placa;
	private String tipoVehiculo;
	private Integer cilindraje;
	
	public Vehiculo() {
	}
	
	public Vehiculo(long idVehiculo, String placa, String tipoVehiculo, Integer cilindraje) {
		this.idVehiculo = idVehiculo;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
	}


	public long getIdVehiculo() {
		return idVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public Integer getCilindraje() {
		return cilindraje;
	}
	
	

}
