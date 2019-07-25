package estacionamiento.dominio.repositorio;

import estacionamiento.dominio.modelo.GestionParqueaderoDTO;


public interface IGestionParqueaderoRepositorio {
	
	Long cantidadCeldasOcupadasPorTipoVehiculo(String tipoVehiculo);
	
	GestionParqueaderoDTO registarIngresoVehiculoAlParqueadero(GestionParqueaderoDTO gestionParqueaderoDTO);
}
