
package estacionamiento.infraestructura.persistencia.builder;

import estacionamiento.dominio.modelo.Tiquete;
import estacionamiento.dominio.modelo.Vehiculo;
import estacionamiento.infraestructura.persistencia.entidad.TiqueteEntidad;
import estacionamiento.infraestructura.persistencia.entidad.VehiculoEntidad;

public final class TiqueteBuilder {
	
	public static  Tiquete convertirAModelo(TiqueteEntidad tiqueteEntidad) {
		Vehiculo vehiculoDTO = VehiculoBuilder.convertirAModelo(tiqueteEntidad.getIdVehiculo());
		Tiquete tiquete = new Tiquete(tiqueteEntidad.getIdTiquete(), tiqueteEntidad.getRegistroIngreso(), tiqueteEntidad.getRegistroSalida(),  tiqueteEntidad.getValorServicio(), tiqueteEntidad.getEstado(),vehiculoDTO);
		return tiquete;
	}
	
	public static TiqueteEntidad convertirAEntidad(Tiquete tiquete) {
		VehiculoEntidad vehiculoEntidad = VehiculoBuilder.convertirAEntidad(tiquete.getVehiculo());
		
		TiqueteEntidad parqueaderoEntidad = new TiqueteEntidad(tiquete.getIdTiquete(), tiquete.getFechaIngreso(), tiquete.getFechaSalida(), tiquete.getValorServicio(), tiquete.getEstadoRegistro(), vehiculoEntidad);
		return parqueaderoEntidad;
	}
	

}