package infraestructura.persistencia.repositorio;

import dominio.repositorio.IGestionParqueaderoRepositorio;

public class GestionParqueaderoRepositorioImp implements IGestionParqueaderoRepositorio{

	

	IGestionParqueaderoJPA repositorioJPA;
	
	public GestionParqueaderoRepositorioImp(IGestionParqueaderoJPA repositorioJPA) {
		this.repositorioJPA = repositorioJPA;
	}

	@Override
	public Long cantidadCeldasOcupadasPorTipoVehiculo(String tipoVehiculo) {
		return repositorioJPA.contarVehiculosParqueados(tipoVehiculo);
	}

}
