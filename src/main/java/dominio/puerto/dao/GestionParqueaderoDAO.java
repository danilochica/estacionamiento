package dominio.puerto.dao;

import java.util.List;

import dominio.modelo.GestionParqueaderoDTO;

public interface GestionParqueaderoDAO {
	
	List<GestionParqueaderoDTO> listarVehiculosParqueados();

}
