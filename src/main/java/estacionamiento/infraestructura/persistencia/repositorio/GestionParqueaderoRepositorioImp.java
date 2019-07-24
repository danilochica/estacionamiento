package estacionamiento.infraestructura.persistencia.repositorio;

import org.springframework.stereotype.Repository;

import estacionamiento.dominio.repositorio.IGestionParqueaderoRepositorio;

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

}
