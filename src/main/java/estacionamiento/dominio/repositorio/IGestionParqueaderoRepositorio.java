package estacionamiento.dominio.repositorio;

import estacionamiento.dominio.modelo.GestionParqueaderoDTO;


public interface IGestionParqueaderoRepositorio {

	GestionParqueaderoDTO registarIngresoVehiculoAlParqueadero(GestionParqueaderoDTO gestionParqueaderoDTO);
	
	int contarMotosParqueadas();
	
	int contarCarrosParqueados();

}
