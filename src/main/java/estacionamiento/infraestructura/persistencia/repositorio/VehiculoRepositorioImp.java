package estacionamiento.infraestructura.persistencia.repositorio;

import org.springframework.stereotype.Repository;

import estacionamiento.dominio.modelo.VehiculoDTO;
import estacionamiento.dominio.repositorio.IVehiculoRepositorio;
import estacionamiento.infraestructura.persistencia.builder.VehiculoBuilder;
import estacionamiento.infraestructura.persistencia.entidad.VehiculoEntidad;

@Repository
public class VehiculoRepositorioImp implements IVehiculoRepositorio {

	IVehiculoJPA repositorioJPA;

	public VehiculoRepositorioImp(IVehiculoJPA repositorioJPA) {
		this.repositorioJPA = repositorioJPA;
	}

	@Override
	public void registrarVehiculoEnElSistema(VehiculoDTO vehiculoDTO) {
		
		VehiculoEntidad vehiculoEntidad = VehiculoBuilder.convertirAEntidad(vehiculoDTO);
		repositorioJPA.save(vehiculoEntidad);
		
		
	}



}
