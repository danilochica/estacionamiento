package estacionamiento.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import org.junit.Test;
import org.mockito.Mock;

import estacionamiento.dominio.modelo.Vehiculo;
import estacionamiento.dominio.repositorio.TiqueteRepositorio;
import estacionamiento.dominio.repositorio.VehiculoRepositorio;
import estacionamiento.dominio.servicio.CalendarioServicio;
import estacionamiento.dominio.servicio.ParqueaderoServicio;
import estacionamiento.testdatabuider.VehiculoTestDataBuilder;

public class ServicioParqueaderoTestUnitaria {
	
	private static final String PLACA_CON_LETRA_A = "AEQ99D";
	private static final String TIPO_VEHICULO_MOTO = "Moto";
	private static final String TIPO_VEHICULO_CARRO = "Carro";
	private static final int CILINDRAJE = 150;
	
	boolean resultado;
	@Mock
	TiqueteRepositorio tiqueteRepositorio = mock(TiqueteRepositorio.class);
	
	@Mock
	VehiculoRepositorio vehiculoRepositorio = mock(VehiculoRepositorio.class);
	
	@Test
	public void crearVehiculoTest() {
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA_CON_LETRA_A).conTipoVehiculo(TIPO_VEHICULO_MOTO).conCilindraje(CILINDRAJE);
		
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		
		assertEquals(PLACA_CON_LETRA_A, vehiculo.getPlaca());
		assertEquals(TIPO_VEHICULO_MOTO, vehiculo.getTipoVehiculo());
		assertEquals(CILINDRAJE, vehiculo.getCilindraje(),0);
		
	}
	
	@Test
	public void testVehiculoPlacaConLetraInicialIgualA() {

		String placaRegistrada = "ASQ523";
		ParqueaderoServicio servicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio);
		
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conPlaca(placaRegistrada);
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		
		resultado = servicio.esLetraInicialDeRestriccion(vehiculoTest.getPlaca());
		
		assertTrue(resultado);
		
	}
	
	@Test
	public void testVehiculoPlacaConLetraInicialDiferente() {
		
		String placaRegistrada = "KSQ523";
		ParqueaderoServicio servicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conPlaca(placaRegistrada);
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		
		
		resultado = servicio.esLetraInicialDeRestriccion(vehiculoTest.getPlaca());
		
		assertFalse(resultado);
	}

	
	@Test
	public void testHayDisponibilidadParqueoParaCarro() {

		
		ParqueaderoServicio servicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_CARRO).conPlaca("DMS125");
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		when(servicio.cantidadCeldasOcupadasPorTipoVehiculo(TIPO_VEHICULO_CARRO)).thenReturn(15);

		resultado = servicio.hayDisponibilidadParqueo(vehiculoTest);

		assertTrue(resultado);
	}
	
	@Test
	public void testNoHayDisponibilidadParqueoParaCarro() {

		ParqueaderoServicio servicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_CARRO).conPlaca("DMS125");
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		when(servicio.cantidadCeldasOcupadasPorTipoVehiculo(TIPO_VEHICULO_CARRO)).thenReturn(22);

		resultado = servicio.hayDisponibilidadParqueo(vehiculoTest);

		assertFalse(resultado);
	}
	
	@Test
	public void testNoHayDisponibilidadParqueoParaMoto() {
		
		ParqueaderoServicio servicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_MOTO).conPlaca("ASD12D");
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		when(servicio.cantidadCeldasOcupadasPorTipoVehiculo(TIPO_VEHICULO_MOTO)).thenReturn(22);

		resultado = servicio.hayDisponibilidadParqueo(vehiculoTest);

		assertFalse(resultado);
	}
	
	
	@Test
	public void testNoPuedeIngresarPorDiaHabil() {
		
		int diaDeLaSemanaDomingo = 0;
		String placaVehiculo = "ASD12D";
		CalendarioServicio calendarioServicio =mock(CalendarioServicio.class);
		ParqueaderoServicio servicioConCalendario = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_MOTO).conPlaca(placaVehiculo);
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		
		when(calendarioServicio.diaDeLaSemana()).thenReturn(diaDeLaSemanaDomingo);
		
		try {
			servicioConCalendario.registrarIngresoVehiculoAlParqueadero(vehiculoTest);
		} catch (Exception e) {
			assertEquals(ParqueaderoServicio.PLACA_INICIA_CON_A , e.getMessage());
		}
		
	}
	
	@Test
	public void testNoPuedeIngresarMotoPorNoDisponibilidadDeCeldas() {
		
		int cantidadMotosParqueadas = 10;
		String placaVehiculo = "MSD12D";
		ParqueaderoServicio servicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_MOTO).conPlaca(placaVehiculo);
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		
		when(servicio.cantidadCeldasOcupadasPorTipoVehiculo(TIPO_VEHICULO_MOTO)).thenReturn(cantidadMotosParqueadas);
		
		try {
			servicio.registrarIngresoVehiculoAlParqueadero(vehiculoTest);
		} catch (Exception e) {
			assertEquals(ParqueaderoServicio.NO_HAY_CELDAS_DISPONIBLES , e.getMessage());
		}
		
	}
	
}
