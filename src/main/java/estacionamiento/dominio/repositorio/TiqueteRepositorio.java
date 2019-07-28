package estacionamiento.dominio.repositorio;

import java.util.List;

import estacionamiento.dominio.modelo.Tiquete;


public interface TiqueteRepositorio {

	Tiquete registarIngresoVehiculoAlParqueadero(Tiquete gestionParqueaderoDTO);
	
	int contarMotosParqueadas();
	
	int contarCarrosParqueados();
	
	List<Tiquete> listaVehiculosParqueados();
	
	Tiquete consultarVehiculoParqueadoPorPlaca(String placa);

}
