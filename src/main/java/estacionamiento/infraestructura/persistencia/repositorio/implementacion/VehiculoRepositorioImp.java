package estacionamiento.infraestructura.persistencia.repositorio.implementacion;

import org.springframework.stereotype.Repository;

import estacionamiento.dominio.modelo.Vehiculo;
import estacionamiento.dominio.repositorio.VehiculoRepositorio;
import estacionamiento.infraestructura.persistencia.builder.VehiculoBuilder;
import estacionamiento.infraestructura.persistencia.entidad.VehiculoEntidad;
import estacionamiento.infraestructura.persistencia.repositorio.IVehiculoJPA;

@Repository
public class VehiculoRepositorioImp implements VehiculoRepositorio {

	IVehiculoJPA repositorioJPA;

	public VehiculoRepositorioImp(IVehiculoJPA repositorioJPA) {
		this.repositorioJPA = repositorioJPA;
	}

	@Override
	public Vehiculo registrarVehiculoEnElSistema(Vehiculo vehiculoDTO) {
		
		VehiculoEntidad vehiculoEntidad = VehiculoBuilder.convertirAEntidad(vehiculoDTO);
		VehiculoEntidad vehiculoAlmacenado = repositorioJPA.save(vehiculoEntidad);
		
		return VehiculoBuilder.convertirAModelo(vehiculoAlmacenado);
		
	}



}
