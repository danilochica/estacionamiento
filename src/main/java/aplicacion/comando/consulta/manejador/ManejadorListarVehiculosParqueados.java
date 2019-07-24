package aplicacion.comando.consulta.manejador;

import java.util.List;

import org.springframework.stereotype.Component;

import infraestructura.persistencia.entidad.GestionParqueaderoEntidad;
import infraestructura.persistencia.repositorio.IGestionParqueaderoJPA;

@Component
public class ManejadorListarVehiculosParqueados {
	
	private IGestionParqueaderoJPA gestionParqueadero;
	
	public ManejadorListarVehiculosParqueados(IGestionParqueaderoJPA gestionParqueadero) {
		super();
		this.gestionParqueadero = gestionParqueadero;
	}
	
	public List<GestionParqueaderoEntidad> ejecutarConsulta(){
		return this.gestionParqueadero.findByEstado(true);
	}

}
