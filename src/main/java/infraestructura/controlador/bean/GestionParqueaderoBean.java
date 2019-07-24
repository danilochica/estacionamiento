package infraestructura.controlador.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import dominio.servicio.IngresarVehiculoServicio;
import infraestructura.persistencia.repositorio.IGestionParqueaderoJPA;
import infraestructura.persistencia.repositorio.IVehiculoJPA;

@Repository
public class GestionParqueaderoBean {
	

	@Bean
	public IngresarVehiculoServicio vigilanteServicio(IGestionParqueaderoJPA gestionParqueaderoRepositorio,IVehiculoJPA vehiculoRepositorio) {
		return new IngresarVehiculoServicio(gestionParqueaderoRepositorio,vehiculoRepositorio );
	}
	

}
