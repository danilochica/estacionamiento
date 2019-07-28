package estacionamiento.infraestructura.persistencia.builder;

import estacionamiento.dominio.modelo.Vehiculo;
import estacionamiento.infraestructura.persistencia.entidad.VehiculoEntidad;

public final class VehiculoBuilder {

	public static Vehiculo convertirAModelo (VehiculoEntidad vehiculoEntidad) {
		Vehiculo vehiculoDto = new Vehiculo(vehiculoEntidad.getIdVehiculo(), vehiculoEntidad.getPlaca(), vehiculoEntidad.getTipoVehiculo(), vehiculoEntidad.getCilindraje());
		return vehiculoDto;
	}
	
	public static VehiculoEntidad convertirAEntidad(Vehiculo vehiculoDTO) {
		VehiculoEntidad vehiculoEntidad = new VehiculoEntidad(vehiculoDTO.getIdVehiculo(), vehiculoDTO.getTipoVehiculo(), vehiculoDTO.getCilindraje(), vehiculoDTO.getPlaca());
		return vehiculoEntidad;
		
	}
	
	
	
}
