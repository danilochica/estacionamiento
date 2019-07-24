package infraestructura.controlador.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import dominio.servicio.IngresarVehiculoServicio;
import infraestructura.persistencia.repositorio.IGestionParqueaderoRepositorio;
import infraestructura.persistencia.repositorio.IVehiculoRepositorio;

@Repository
public class GestionParqueaderoBean {
	

	@Bean
	public IngresarVehiculoServicio vigilanteServicio(IGestionParqueaderoRepositorio gestionParqueaderoRepositorio,IVehiculoRepositorio vehiculoRepositorio) {
		return new IngresarVehiculoServicio(gestionParqueaderoRepositorio,vehiculoRepositorio );
	}
	

}
