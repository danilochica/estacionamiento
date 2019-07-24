package dominio.modelo;

public class VehiculoDTO {

	private String placa;
	private String tipoVehiculo;
	private Integer cilindraje;
	
	public VehiculoDTO() {
	}
	
	public VehiculoDTO(String placa, String tipoVehiculo, Integer cilindraje) {
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
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
	


}
