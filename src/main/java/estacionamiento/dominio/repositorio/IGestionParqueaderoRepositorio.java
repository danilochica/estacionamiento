package estacionamiento.dominio.repositorio;

public interface IGestionParqueaderoRepositorio {
	
	Long cantidadCeldasOcupadasPorTipoVehiculo(String tipoVehiculo);
}
