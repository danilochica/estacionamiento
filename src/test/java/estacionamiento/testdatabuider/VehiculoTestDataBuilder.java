package estacionamiento.testdatabuider;

import estacionamiento.dominio.modelo.Vehiculo;

public class VehiculoTestDataBuilder {
	
	private long idVehiculo;
	private String placa;
	private String tipoVehiculo;
	private int cilindraje;

	public VehiculoTestDataBuilder conPlaca(String placa) {
		this.placa=placa;
		return this;
	}
	
	public VehiculoTestDataBuilder conIdVehiculo(long idVehiculo) {
		this.idVehiculo = idVehiculo;
		return this;
	}
	
	public VehiculoTestDataBuilder conTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}
	
	public VehiculoTestDataBuilder conCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public Vehiculo build() {
		return new Vehiculo(this.idVehiculo,this.placa, this.tipoVehiculo, this.cilindraje);
	}
	

}
