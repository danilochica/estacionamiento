package estacionamiento.infraestructura.controlador.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import estacionamiento.dominio.repositorio.IGestionParqueaderoRepositorio;
import estacionamiento.dominio.repositorio.IVehiculoRepositorio;
import estacionamiento.dominio.servicio.ParqueaderoServicio;

@Configuration
public class GestionParqueaderoBean {
	
	@Bean
	public ParqueaderoServicio ingresarVehiculoServicio (IGestionParqueaderoRepositorio gestionParqueaderoRepositorio,
			IVehiculoRepositorio vehiculoRepositorio) {
		return new ParqueaderoServicio(gestionParqueaderoRepositorio, vehiculoRepositorio);
	}

}
