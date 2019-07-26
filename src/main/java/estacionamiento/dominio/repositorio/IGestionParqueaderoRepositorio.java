package estacionamiento.dominio.repositorio;

import java.util.List;

import estacionamiento.dominio.modelo.GestionParqueaderoDTO;


public interface IGestionParqueaderoRepositorio {

	GestionParqueaderoDTO registarIngresoVehiculoAlParqueadero(GestionParqueaderoDTO gestionParqueaderoDTO);
	
	int contarMotosParqueadas();
	
	int contarCarrosParqueados();
	
	List<GestionParqueaderoDTO> listaVehiculosParqueados(boolean estado);

}
