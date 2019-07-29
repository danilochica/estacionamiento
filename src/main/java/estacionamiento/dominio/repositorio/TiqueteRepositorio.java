package estacionamiento.dominio.repositorio;

import java.util.List;

import estacionamiento.dominio.modelo.Tiquete;


public interface TiqueteRepositorio {

	Tiquete registarIngresoVehiculoAlParqueadero(Tiquete tiquete);
	
	Tiquete regitrarSalidaVehiculoDelParqueadero(Tiquete tiquete);
	
	int contarMotosParqueadas();
	
	int contarCarrosParqueados();
	
	List<Tiquete> listaVehiculosParqueados();
	
	Tiquete consultarVehiculoParqueadoPorPlaca(String placa);

}
