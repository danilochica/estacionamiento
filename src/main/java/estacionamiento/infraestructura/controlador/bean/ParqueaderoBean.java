package estacionamiento.infraestructura.controlador.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import estacionamiento.dominio.repositorio.TiqueteRepositorio;
import estacionamiento.dominio.repositorio.VehiculoRepositorio;
import estacionamiento.dominio.servicio.ParqueaderoServicio;

@Configuration
public class ParqueaderoBean {
	
	@Bean
	public ParqueaderoServicio parqueaderoServicio (TiqueteRepositorio tiqueteRepositorio,
			VehiculoRepositorio vehiculoRepositorio) {
		return new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio);
	}


}
