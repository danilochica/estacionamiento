package estacionamiento.infraestructura.persistencia.repositorio.implementacion;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import estacionamiento.dominio.modelo.GestionParqueaderoDTO;
import estacionamiento.dominio.repositorio.IGestionParqueaderoRepositorio;
import estacionamiento.infraestructura.persistencia.builder.GestionParqueaderoBuilder;
import estacionamiento.infraestructura.persistencia.entidad.GestionParqueaderoEntidad;
import estacionamiento.infraestructura.persistencia.repositorio.IGestionParqueaderoJPA;

@Repository
public class GestionParqueaderoRepositorioImp implements IGestionParqueaderoRepositorio{

	IGestionParqueaderoJPA repositorioJPA;
	
	public GestionParqueaderoRepositorioImp(IGestionParqueaderoJPA repositorioJPA) {
		this.repositorioJPA = repositorioJPA;
	}
	

	@Override
	public int contarMotosParqueadas() {
		return repositorioJPA.contarMotosParqueadas();
	}

	@Override
	public int contarCarrosParqueados() {
		return repositorioJPA.contarCarrosParqueados();
	}
	
	@Override
	public GestionParqueaderoDTO registarIngresoVehiculoAlParqueadero(GestionParqueaderoDTO gestionParqueaderoDTO) {
	
		GestionParqueaderoEntidad gestionParqueadero = GestionParqueaderoBuilder.convertirAEntidad(gestionParqueaderoDTO);
		GestionParqueaderoEntidad registroAlmacenado =  repositorioJPA.save(gestionParqueadero);
		return GestionParqueaderoBuilder.convertirAModelo(registroAlmacenado);
	}

	@Override
	public List<GestionParqueaderoDTO> listaVehiculosParqueados(boolean estado) {
		List<GestionParqueaderoEntidad> resultadoConsulta = repositorioJPA.findByEstado(estado);
		List<GestionParqueaderoDTO> vehiculosParqueados = 
				resultadoConsulta.stream().map(GestionParqueaderoBuilder::convertirAModelo).collect(Collectors.toList());
		return vehiculosParqueados;
	}

}
