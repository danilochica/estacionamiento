package estacionamiento.dominio.repositorio;

import estacionamiento.dominio.modelo.GestionParqueaderoDTO;


public interface IGestionParqueaderoRepositorio {
	
	Long cantidadCeldasOcupadasPorTipoVehiculo(String tipoVehiculo);
	
	void registarIngresoVehiculoAlParqueadero(GestionParqueaderoDTO gestionParqueaderoDTO);
}
