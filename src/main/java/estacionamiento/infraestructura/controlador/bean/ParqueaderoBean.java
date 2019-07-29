package estacionamiento.infraestructura.controlador.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import estacionamiento.dominio.repositorio.TiqueteRepositorio;
import estacionamiento.dominio.repositorio.VehiculoRepositorio;
import estacionamiento.dominio.servicio.CalendarioServicio;
import estacionamiento.dominio.servicio.ParqueaderoServicio;

@Configuration
public class ParqueaderoBean {
	
	@Bean
	public CalendarioServicio calendarioServicio() {
		return new CalendarioServicio(); 
	}
	
	@Bean
	public ParqueaderoServicio parqueaderoServicio (TiqueteRepositorio tiqueteRepositorio,
			VehiculoRepositorio vehiculoRepositorio, CalendarioServicio calendarioServicio) {
		return new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio, calendarioServicio );
	}
	
	


}
