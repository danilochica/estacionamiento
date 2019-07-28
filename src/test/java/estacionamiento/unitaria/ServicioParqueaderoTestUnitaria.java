package estacionamiento.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import org.junit.Test;

import estacionamiento.dominio.modelo.Vehiculo;
import estacionamiento.dominio.repositorio.TiqueteRepositorio;
import estacionamiento.dominio.repositorio.VehiculoRepositorio;
import estacionamiento.dominio.servicio.ParqueaderoServicio;
import estacionamiento.testdatabuider.VehiculoTestDataBuilder;

public class ServicioParqueaderoTestUnitaria {
	
	private static final String PLACA_CON_LETRA_A = "AEQ99D";
	private static final String TIPO_VEHICULO_MOTO = "Moto";
	private static final String TIPO_VEHICULO_CARRO = "Carro";
	private static final int CILINDRAJE = 150;
	
	boolean resultado;
	
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
		TiqueteRepositorio tiqueteRepositorio = mock(TiqueteRepositorio.class);
		VehiculoRepositorio vehiculoRepositorio = mock(VehiculoRepositorio.class);
		ParqueaderoServicio servicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio);
		
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conPlaca(placaRegistrada);
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		
		resultado = servicio.esLetraInicialDeRestriccion(vehiculoTest.getPlaca());
		
		assertTrue(resultado);
		
	}
	
	@Test
	public void testVehiculoPlacaConLetraInicialDiferente() {
		
		String placaRegistrada = "KSQ523";
		TiqueteRepositorio tiqueteRepositorio = mock(TiqueteRepositorio.class);
		VehiculoRepositorio vehiculoRepositorio = mock(VehiculoRepositorio.class);
		ParqueaderoServicio servicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conPlaca(placaRegistrada);
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		
		
		resultado = servicio.esLetraInicialDeRestriccion(vehiculoTest.getPlaca());
		
		assertFalse(resultado);
	}

	
	@Test
	public void testHayDisponibilidadParqueoParaCarro() {

		TiqueteRepositorio tiqueteRepositorio = mock(TiqueteRepositorio.class);
		VehiculoRepositorio vehiculoRepositorio = mock(VehiculoRepositorio.class);
		ParqueaderoServicio servicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_CARRO).conPlaca("DMS125");
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		when(servicio.cantidadCeldasOcupadasPorTipoVehiculo(TIPO_VEHICULO_CARRO)).thenReturn(15);

		resultado = servicio.hayDisponibilidadParqueo(vehiculoTest);

		assertTrue(resultado);
	}
	
	@Test
	public void testNoHayDisponibilidadParqueoParaCarro() {
		
		TiqueteRepositorio tiqueteRepositorio = mock(TiqueteRepositorio.class);
		VehiculoRepositorio vehiculoRepositorio = mock(VehiculoRepositorio.class);
		ParqueaderoServicio servicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_CARRO).conPlaca("DMS125");
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		when(servicio.cantidadCeldasOcupadasPorTipoVehiculo(TIPO_VEHICULO_CARRO)).thenReturn(22);

		resultado = servicio.hayDisponibilidadParqueo(vehiculoTest);

		assertFalse(resultado);
	}
	
	@Test
	public void testNoHayDisponibilidadParqueoParaMoto() {
		
		TiqueteRepositorio tiqueteRepositorio = mock(TiqueteRepositorio.class);
		VehiculoRepositorio vehiculoRepositorio = mock(VehiculoRepositorio.class);
		ParqueaderoServicio servicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_MOTO).conPlaca("ASD12D");
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		when(servicio.cantidadCeldasOcupadasPorTipoVehiculo(TIPO_VEHICULO_MOTO)).thenReturn(22);

		resultado = servicio.hayDisponibilidadParqueo(vehiculoTest);

		assertFalse(resultado);
	}
	
	
	@Test()
	public void testCuandoElRegistroDelVehiculoEsExitoso() {
		
		
		TiqueteRepositorio tiqueteRepositorio = mock(TiqueteRepositorio.class);
		VehiculoRepositorio vehiculoRepositorio = mock(VehiculoRepositorio.class);
		ParqueaderoServicio servicio = new ParqueaderoServicio(tiqueteRepositorio, vehiculoRepositorio);
		
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_MOTO).conPlaca("KEQ99D");
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		
		servicio.registrarIngresoVehiculoAlParqueadero(vehiculoTest);
		
	}
	
}
