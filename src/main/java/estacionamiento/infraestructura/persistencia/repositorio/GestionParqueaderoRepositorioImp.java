package estacionamiento.infraestructura.persistencia.repositorio;

import org.springframework.stereotype.Repository;

import estacionamiento.dominio.modelo.GestionParqueaderoDTO;
import estacionamiento.dominio.repositorio.IGestionParqueaderoRepositorio;
import estacionamiento.infraestructura.persistencia.builder.GestionParqueaderoBuilder;
import estacionamiento.infraestructura.persistencia.entidad.GestionParqueaderoEntidad;

@Repository
public class GestionParqueaderoRepositorioImp implements IGestionParqueaderoRepositorio{

	IGestionParqueaderoJPA repositorioJPA;
	
	public GestionParqueaderoRepositorioImp(IGestionParqueaderoJPA repositorioJPA) {
		this.repositorioJPA = repositorioJPA;
	}

	@Override
	public Long cantidadCeldasOcupadasPorTipoVehiculo(String tipoVehiculo) {
		return new Long(0); //repositorioJPA.contarVehiculosParqueados(tipoVehiculo);
	}

	@Override
	public GestionParqueaderoDTO registarIngresoVehiculoAlParqueadero(GestionParqueaderoDTO gestionParqueaderoDTO) {
	
		GestionParqueaderoEntidad gestionParqueadero = GestionParqueaderoBuilder.convertirAEntidad(gestionParqueaderoDTO);
		GestionParqueaderoEntidad registroAlmacenado =  repositorioJPA.save(gestionParqueadero);
		return GestionParqueaderoBuilder.convertirAModelo(registroAlmacenado);
		
	}

}
