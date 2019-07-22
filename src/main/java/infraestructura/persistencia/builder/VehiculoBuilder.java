package infraestructura.persistencia.builder;

import dominio.modelo.VehiculoDTO;
import infraestructura.persistencia.entidad.VehiculoEntidad;

public final class VehiculoBuilder {

	public static VehiculoDTO convertirAModelo (VehiculoEntidad vehiculoEntidad) {
		VehiculoDTO vehiculoDto = new VehiculoDTO(vehiculoEntidad.getPlaca(), vehiculoEntidad.getTipoVehiculo(), vehiculoEntidad.getCilindraje());
		return vehiculoDto;
	}
	
	public static VehiculoEntidad convertirAEntidad(VehiculoDTO vehiculoDTO) {
		VehiculoEntidad vehiculoEntidad = new VehiculoEntidad(vehiculoDTO.getPlaca(), vehiculoDTO.getTipoVehiculo(), vehiculoDTO.getCilindraje());
		return vehiculoEntidad;
		
	}
	
	
	
}
