package estacionamiento.infraestructura.controlador.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import estacionamiento.dominio.repositorio.IGestionParqueaderoRepositorio;
import estacionamiento.dominio.repositorio.IVehiculoRepositorio;
import estacionamiento.dominio.servicio.IngresarVehiculoServicio;

@Configuration
public class GestionParqueaderoBean {
	
	@Bean
	public IngresarVehiculoServicio ingresarVehiculoServicio (IGestionParqueaderoRepositorio gestionParqueaderoRepositorio,
			IVehiculoRepositorio vehiculoRepositorio) {
		return new IngresarVehiculoServicio(gestionParqueaderoRepositorio, vehiculoRepositorio);
	}

}
