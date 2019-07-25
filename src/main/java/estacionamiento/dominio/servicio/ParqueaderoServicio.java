package estacionamiento.dominio.servicio;


import java.util.Calendar;
import java.util.Date;

import estacionamiento.dominio.excepcion.ExcepcionPlacaIniciaConA;
import estacionamiento.dominio.excepcion.ExcepecionNoHayCeldasDisponibles;
import estacionamiento.dominio.modelo.GestionParqueaderoDTO;
import estacionamiento.dominio.modelo.VehiculoDTO;
import estacionamiento.dominio.repositorio.IGestionParqueaderoRepositorio;
import estacionamiento.dominio.repositorio.IVehiculoRepositorio;

public class ParqueaderoServicio {
	
	public static final int CILINDRAJE_PARA_CALCULAR_RECARGO = 500;
	public static final String LETRA_INICIAL_PLACA= "A";
	public static final String MOTO= "Moto";
	public static final String CARRO = "Carro";
	public static final int CAPACIDAD_MAXIMA_DE_CARROS = 20;
	public static final int CAPACIDAD_MAXIMA_DE_MOTOS = 10;
	
	public static final String PLACA_INICIA_CON_A = "No puede ingresar porque no esta en un dia habil";
	public static final String NO_HAY_CELDAS_DISPONIBLES ="No hay celdas disponibles";
	public static final String PARQUEO_EXITOSO ="Registro exitoso";
	
	
	IGestionParqueaderoRepositorio gestionParqueaderoRepositorio;
	IVehiculoRepositorio vehiculoRepositorio;
	
	public ParqueaderoServicio() {
		
	}
	
	public ParqueaderoServicio(IGestionParqueaderoRepositorio gestionParqueaderoRepositorio,
			IVehiculoRepositorio vehiculoRepositorio) {
		this.gestionParqueaderoRepositorio = gestionParqueaderoRepositorio;
		this.vehiculoRepositorio = vehiculoRepositorio;
	}

	public boolean hayDisponibilidadParqueo(VehiculoDTO vehiculoDTO) {
		boolean hayCeldas;
		int cantidadVehiculosParqueados = cantidadCeldasOcupadasPorTipoVehiculo(vehiculoDTO.getTipoVehiculo());
		hayCeldas = vehiculoDTO.esCarro() ? 
				cantidadVehiculosParqueados<CAPACIDAD_MAXIMA_DE_CARROS : cantidadVehiculosParqueados<CAPACIDAD_MAXIMA_DE_MOTOS;
		return hayCeldas;
	}
	
	public boolean esDiaHabilParaPlacaConLetraInicialA() {
		Calendar fechaActual =  Calendar.getInstance();
		return(fechaActual.get(Calendar.DAY_OF_WEEK) <= 2);
	}
	
	public int cantidadCeldasOcupadasPorTipoVehiculo(String tipoVehiculo) {
		return tipoVehiculo.equals(MOTO) ? gestionParqueaderoRepositorio.contarMotosParqueadas() : gestionParqueaderoRepositorio.contarCarrosParqueados();
	}
	
	public boolean esLetraInicialDeRestriccion(String placa) {
		char letraInicial = Character.toUpperCase(placa.charAt(0));
		return String.valueOf(letraInicial).equals(LETRA_INICIAL_PLACA);
	}
	
	public Date obtenerfechaAtual() {		
		
		Date fechaActual=new Date();
	    Calendar calendario= Calendar.getInstance();
	    calendario.setTime(fechaActual);	    
	    return calendario.getTime();
	}
	
	public VehiculoDTO registrarVehiculo(VehiculoDTO vehiculoDTO) {
		
		if(esLetraInicialDeRestriccion(vehiculoDTO.getPlaca()) && !esDiaHabilParaPlacaConLetraInicialA()){
			throw new ExcepcionPlacaIniciaConA(PLACA_INICIA_CON_A);
		}
		
		if(!hayDisponibilidadParqueo(vehiculoDTO)) {
			throw new ExcepecionNoHayCeldasDisponibles(NO_HAY_CELDAS_DISPONIBLES);
		}
		
		VehiculoDTO vehiculoGuardado = vehiculoRepositorio.registrarVehiculoEnElSistema(vehiculoDTO);
		return vehiculoGuardado;
		
	}
	
	
	
	public GestionParqueaderoDTO registarIngresoAlParqueadero(VehiculoDTO vehiculoDTO) {
		
		GestionParqueaderoDTO gestionParqueaderoDTO = new GestionParqueaderoDTO(obtenerfechaAtual(), true, vehiculoDTO);
		GestionParqueaderoDTO registroAlmacenado = gestionParqueaderoRepositorio.registarIngresoVehiculoAlParqueadero(gestionParqueaderoDTO);
		
		return registroAlmacenado;
		
	}
	
	
}