package estacionamiento.dominio.modelo;


public enum VehiculoEnum {
	
	MOTO("Moto", 500,4000,10),
	CARRO("Carro", 1000,8000,20);
	
	private String tipoVehiculo;
	private int valorHora;
	private int valorDia;
	private int capacidadMaximaVehiculosParqueados;
	
	private VehiculoEnum(String tipoVehiculo, int valorHora, int valorDia, int capacidadMaximaVehiculosParqueados) {
		this.tipoVehiculo = tipoVehiculo;
		this.valorHora = valorHora;
		this.valorDia = valorDia;
		this.capacidadMaximaVehiculosParqueados = capacidadMaximaVehiculosParqueados;
	}
	
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	public int getValorHora() {
		return valorHora;
	}
	public int getValorDia() {
		return valorDia;
	}
	public int getCapacidadMaximaVehiculosParqueados() {
		return capacidadMaximaVehiculosParqueados;
	}
	
}
