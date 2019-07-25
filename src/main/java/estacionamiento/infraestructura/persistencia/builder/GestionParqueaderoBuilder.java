
package estacionamiento.infraestructura.persistencia.builder;

import estacionamiento.dominio.modelo.GestionParqueaderoDTO;
import estacionamiento.dominio.modelo.VehiculoDTO;
import estacionamiento.infraestructura.persistencia.entidad.GestionParqueaderoEntidad;
import estacionamiento.infraestructura.persistencia.entidad.VehiculoEntidad;

public final class GestionParqueaderoBuilder {
	
	public static  GestionParqueaderoDTO convertirAModelo(GestionParqueaderoEntidad parqueaderoEntidad) {
		VehiculoDTO vehiculoDTO = VehiculoBuilder.convertirAModelo(parqueaderoEntidad.getIdVehiculo());
		GestionParqueaderoDTO parquederoDTO = new GestionParqueaderoDTO(parqueaderoEntidad.getIdTransaccion(), parqueaderoEntidad.getRegistroIngreso(), parqueaderoEntidad.getRegistroSalida(),  parqueaderoEntidad.getValorServicio(), parqueaderoEntidad.getEstado(),vehiculoDTO);
		return parquederoDTO;
	}
	
	public static GestionParqueaderoEntidad convertirAEntidad(GestionParqueaderoDTO parqueaderoDTO) {
		VehiculoEntidad vehiculoEntidad = VehiculoBuilder.convertirAEntidad(parqueaderoDTO.getVehiculo());
		
		GestionParqueaderoEntidad parqueaderoEntidad = new GestionParqueaderoEntidad(parqueaderoDTO.getIdTransaccion(), parqueaderoDTO.getFechaIngreso(), parqueaderoDTO.getFechaSalida(), parqueaderoDTO.getValorServicio(), parqueaderoDTO.getEstadoRegistro(), vehiculoEntidad);
		return parqueaderoEntidad;
	}
	

}