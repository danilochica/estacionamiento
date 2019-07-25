package estacionamiento.dominio.modelo;

public class VehiculoDTO {
	
	private long idVehiculo;
	private String placa;
	private String tipoVehiculo;
	private Integer cilindraje;
	
	public VehiculoDTO() {
	}
	
	public VehiculoDTO(long idVehiculo, String placa, String tipoVehiculo, Integer cilindraje) {
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

	public boolean esCarro() {
		return tipoVehiculo.equals("Carro");
	}
	
	public boolean esMoto() {
		return tipoVehiculo.equals("Moto");
	}

	public void setIdVehiculo(long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public void setCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	

}
