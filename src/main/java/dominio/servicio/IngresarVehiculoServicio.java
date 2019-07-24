package dominio.servicio;

import org.springframework.beans.factory.annotation.Autowired;

import dominio.excepcion.ExcepcionPlacaIniciaConA;
import dominio.excepcion.ExcepecionNoHayCeldasDisponibles;
import dominio.modelo.VehiculoDTO;
import dominio.repositorio.IVigilanteRepositorio;
import infraestructura.persistencia.builder.VehiculoBuilder;
import infraestructura.persistencia.repositorio.IGestionParqueaderoRepositorio;
import infraestructura.persistencia.repositorio.IVehiculoRepositorio;

public class IngresarVehiculoServicio {
	
	public static final int CILINDRAJE_PARA_CALCULAR_RECARGO = 500;
	public static final String LETRA_INICIAL_PLACA= "A";
	public static final String MOTO= "moto";
	public static final String CARRO = "carro";
	public static final int CAPACIDAD_MAXIMA_DE_CARROS = 20;
	public static final int CAPACIDAD_MAXIMA_DE_MOTOS = 10;
	
	public static final String PLACA_INICIA_CON_A = "No puede ingresar porque no está en un día hábil";
	public static final String NO_HAY_CELDAS_DISPONIBLES ="No hay celdas disponibles";
	public static final String PARQUEO_EXITOSO ="Registro exitoso";
	
	
	IGestionParqueaderoRepositorio gestionParqueaderoRepositorio;
	IVehiculoRepositorio vehiculoRepositorio;
	IVigilanteRepositorio vigilanteRepositorio;
	
	@Autowired
	private CalendarioServicio calendarioServicio;
	
	public IngresarVehiculoServicio(IGestionParqueaderoRepositorio gestionParqueaderoRepositorio,
			IVehiculoRepositorio vehiculoRepositorio) {
		this.gestionParqueaderoRepositorio = gestionParqueaderoRepositorio;
		this.vehiculoRepositorio = vehiculoRepositorio;
	}
	
	public IngresarVehiculoServicio() {
		
	}

	
	public boolean hayDisponibilidadParqueo(VehiculoDTO vehiculoDTO) {
		boolean hayCeldas;
		int cantidadVehiculosParqueados = cantidadCeldasOcupadasPorTipoVehiculo(vehiculoDTO.getTipoVehiculo());
		hayCeldas = vehiculoDTO.esCarro() ? 
				cantidadVehiculosParqueados<CAPACIDAD_MAXIMA_DE_CARROS : cantidadVehiculosParqueados<CAPACIDAD_MAXIMA_DE_MOTOS;
		return hayCeldas;
	}
	
	public int cantidadCeldasOcupadasPorTipoVehiculo(String tipoVehiculo) {
		return gestionParqueaderoRepositorio.obtenerVehiculosParqueadosPorTipo(tipoVehiculo);
	}
	
	public boolean esLetraInicialDeRestriccion(String placa) {
		char letraInicial = Character.toUpperCase(placa.charAt(0));
		return String.valueOf(letraInicial).equals(LETRA_INICIAL_PLACA);
	}
	
	public void registrarVehiculo(VehiculoDTO vehiculoDTO) {
		if(esLetraInicialDeRestriccion(vehiculoDTO.getPlaca()) && !calendarioServicio.esDiaHabilParaPlacaConLetraInicialA()){
			throw new ExcepcionPlacaIniciaConA(PLACA_INICIA_CON_A);
			
		}
		
		if(!hayDisponibilidadParqueo(vehiculoDTO)) {
			throw new ExcepecionNoHayCeldasDisponibles(NO_HAY_CELDAS_DISPONIBLES);
		}
		
		//mandar el dto para infraestructura
		VehiculoBuilder.convertirAEntidad(vehiculoDTO);
		
	}
	
	
	
}
