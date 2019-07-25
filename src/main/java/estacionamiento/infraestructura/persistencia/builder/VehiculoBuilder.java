package estacionamiento.infraestructura.persistencia.builder;

import estacionamiento.dominio.modelo.VehiculoDTO;
import estacionamiento.infraestructura.persistencia.entidad.VehiculoEntidad;

public final class VehiculoBuilder {

	public static VehiculoDTO convertirAModelo (VehiculoEntidad vehiculoEntidad) {
		VehiculoDTO vehiculoDto = new VehiculoDTO(vehiculoEntidad.getIdVehiculo(), vehiculoEntidad.getPlaca(), vehiculoEntidad.getTipoVehiculo(), vehiculoEntidad.getCilindraje());
		return vehiculoDto;
	}
	
	public static VehiculoEntidad convertirAEntidad(VehiculoDTO vehiculoDTO) {
		VehiculoEntidad vehiculoEntidad = new VehiculoEntidad(vehiculoDTO.getIdVehiculo(), vehiculoDTO.getTipoVehiculo(), vehiculoDTO.getCilindraje(), vehiculoDTO.getPlaca());
		return vehiculoEntidad;
		
	}
	
	
	
}
