package aplicacion.comando.consulta.manejador;

import java.util.Collection;

import org.springframework.stereotype.Component;

import dominio.modelo.GestionParqueaderoDTO;
import dominio.puerto.dao.GestionParqueaderoDAO;

@Component
public class ManejadorListarVehiculosParqueados {
	
	private final GestionParqueaderoDAO gestionParqueaderoDAO;
	
	public ManejadorListarVehiculosParqueados(GestionParqueaderoDAO gestionParqueaderoDAO) {
		this.gestionParqueaderoDAO = gestionParqueaderoDAO;
	}
	
	public Collection<GestionParqueaderoDTO> ejecutarConsulta(){
		return this.gestionParqueaderoDAO.listarVehiculosParqueados();
	}

}
