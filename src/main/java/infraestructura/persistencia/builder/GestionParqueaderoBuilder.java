package infraestructura.persistencia.builder;

import dominio.modelo.GestionParqueaderoDTO;
import dominio.modelo.VehiculoDTO;
import infraestructura.persistencia.entidad.GestionParqueaderoEntidad;
import infraestructura.persistencia.entidad.VehiculoEntidad;

public final class GestionParqueaderoBuilder {
	
	public static  GestionParqueaderoDTO convertirAModelo (GestionParqueaderoEntidad parqueaderoEntidad) {
		VehiculoDTO vehiculoDTO = VehiculoBuilder.convertirAModelo(parqueaderoEntidad.getVehiculo());
		GestionParqueaderoDTO parquederoDTO = new GestionParqueaderoDTO(parqueaderoEntidad.getIdTransaccion(), parqueaderoEntidad.getRegistroIngreso(), parqueaderoEntidad.getRegistroSalida(), parqueaderoEntidad.getValorServicio(), parqueaderoEntidad.getEstado(), vehiculoDTO);
		return parquederoDTO;
	}
	
	public static GestionParqueaderoEntidad convertirAEntidad(GestionParqueaderoDTO parqueaderoDTO) {
		VehiculoEntidad vehiculoEntidad = VehiculoBuilder.convertirAEntidad(parqueaderoDTO.getVehiculo());
		GestionParqueaderoEntidad parqueaderoEntidad = new GestionParqueaderoEntidad(parqueaderoDTO.getIdTransaccion(), parqueaderoDTO.getFechaIngreso(), parqueaderoDTO.getFechaSalida(), parqueaderoDTO.getValorServicio(), parqueaderoDTO.getEstadoRegistro(), vehiculoEntidad);
		return parqueaderoEntidad;
	}
	

}
