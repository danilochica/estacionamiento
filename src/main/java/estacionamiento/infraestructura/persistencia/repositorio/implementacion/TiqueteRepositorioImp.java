package estacionamiento.infraestructura.persistencia.repositorio.implementacion;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import estacionamiento.dominio.modelo.Tiquete;
import estacionamiento.dominio.repositorio.TiqueteRepositorio;
import estacionamiento.infraestructura.persistencia.builder.TiqueteBuilder;
import estacionamiento.infraestructura.persistencia.entidad.TiqueteEntidad;
import estacionamiento.infraestructura.persistencia.repositorio.ITiqueteJPA;

@Repository
public class TiqueteRepositorioImp implements TiqueteRepositorio{

	ITiqueteJPA repositorioJPA;
	
	public TiqueteRepositorioImp(ITiqueteJPA repositorioJPA) {
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
	public Tiquete registarIngresoVehiculoAlParqueadero(Tiquete tiquete) {
		TiqueteEntidad tiqueteEntidad = TiqueteBuilder.convertirAEntidad(tiquete);
		TiqueteEntidad registroAlmacenado =  repositorioJPA.save(tiqueteEntidad);
		return TiqueteBuilder.convertirAModelo(registroAlmacenado);
	}

	@Override
	public Tiquete consultarVehiculoParqueadoPorPlaca(String placa) {
		TiqueteEntidad resultadoConsulta = repositorioJPA.consultarVehiculoParqueadoPorPlaca(placa);
		return TiqueteBuilder.convertirAModelo(resultadoConsulta);
	}

	@Override
	public List<Tiquete> listaVehiculosParqueados() {
		List<TiqueteEntidad> resultadoConsulta = repositorioJPA.vehiculosParqueados();
		List<Tiquete> vehiculosParqueados = 
				resultadoConsulta.stream().map(TiqueteBuilder::convertirAModelo).collect(Collectors.toList());
		return vehiculosParqueados;
	}

}
