package aplicacion;

import dominio.modelo.VehiculoDTO;
import dominio.servicio.VigilanteServicio;
import infraestructura.persistencia.entidad.VehiculoEntidad;

public class ParqueaderoAplicacion {
	
	private VigilanteServicio vigilante;
	
	public VehiculoDTO registroVehiculo(VehiculoEntidad vehiculo) {
		return vigilante. registroVehiculo(vehiculo);
	}

	public List<Vehiculo> obtenerVehiculos(){
		return vigilante.obtenerVehiculos();
	}

	
	
}
