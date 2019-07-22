package aplicacion;

import java.util.List;

import dominio.modelo.VehiculoDTO;
import dominio.servicio.VigilanteServicio;
import infraestructura.persistencia.entidad.VehiculoEntidad;

public class ParqueaderoAplicacion {
	
	private VigilanteServicio vigilante;
	
	public VehiculoDTO registroVehiculo(VehiculoEntidad vehiculo) {
		//return vigilante. registroVehiculo(vehiculo);
		return null;
	}

	public List<VehiculoDTO> obtenerVehiculos(){
		return null;
		//return vigilante.obtenerVehiculos();
	}

	
	
}
