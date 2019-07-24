package unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.Mockito;

import dominio.modelo.VehiculoDTO;
import dominio.servicio.IngresarVehiculoServicio;
import infraestructura.persistencia.repositorio.IGestionParqueaderoJPA;
import infraestructura.persistencia.repositorio.IVehiculoJPA;
import testdatabuider.VehiculoTestDataBuilder;

public class VehiculoTestUnitario {
	
	private static final String PLACA_CON_LETRA_A = "AEQ99D";
	private static final String TIPO_VEHICULO_MOTO = "moto";
	private static final String TIPO_VEHICULO_CARRO = "carro";
	private static final int CILINDRAJE = 150;
	
	boolean resultado;
	
	
	@Test
	public void crearVehiculoTest() {
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA_CON_LETRA_A).conTipoVehiculo(TIPO_VEHICULO_MOTO).conCilindraje(CILINDRAJE);
		
		//Act
		VehiculoDTO vehiculo = vehiculoTestDataBuilder.build();
		
		//Assert
		assertEquals(PLACA_CON_LETRA_A, vehiculo.getPlaca());
		assertEquals(TIPO_VEHICULO_MOTO, vehiculo.getTipoVehiculo());
		assertEquals(CILINDRAJE, vehiculo.getCilindraje(),0);
		
	}
	
	@Test
	public void testVehiculoPlacaConLetraInicialIgualA() {
		//Arrange 
		String placaRegistrada = "ASQ523";
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conPlaca(placaRegistrada);
		VehiculoDTO vehiculoTest = vehiculoBuilder.build();
		IngresarVehiculoServicio servicio = new IngresarVehiculoServicio();
		
		//Act
		resultado = servicio.esLetraInicialDeRestriccion(vehiculoTest.getPlaca());
		
		//Assert
		assertTrue(resultado);
		
	}
	
	@Test
	public void testVehiculoPlacaConLetraInicialDiferente() {
		//Arrange 
		String placaRegistrada = "KSQ523";
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conPlaca(placaRegistrada);
		VehiculoDTO vehiculoTest = vehiculoBuilder.build();
		IngresarVehiculoServicio servicio = new IngresarVehiculoServicio();
		
		//Act
		resultado = servicio.esLetraInicialDeRestriccion(vehiculoTest.getPlaca());
		
		//Assert
		assertFalse(resultado);
	}
	
	
	@Test
	public void testHayDisponibilidadParqueoParaMoto() {
		
		//Arrange
		int cantidadMotosParqueadas = 8;
		IngresarVehiculoServicio servicio = new IngresarVehiculoServicio();
		IngresarVehiculoServicio spyServicio = Mockito.spy(servicio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_MOTO);
		VehiculoDTO vehiculoTest = vehiculoBuilder.build();
		Mockito.doReturn(cantidadMotosParqueadas).when(spyServicio).cantidadCeldasOcupadasPorTipoVehiculo(TIPO_VEHICULO_MOTO);
		
		//Act
		resultado = spyServicio.hayDisponibilidadParqueo(vehiculoTest);
		
		//Assert
		assertTrue(resultado);
	}
	
	@Test
	public void testNoHayDisponibilidadParqueoParaMoto() {
		
		//Arrange
		int cantidadMotosParqueadas = 22;
		IngresarVehiculoServicio servicio = new IngresarVehiculoServicio();
		IngresarVehiculoServicio spyServicio = Mockito.spy(servicio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_CARRO);
		VehiculoDTO vehiculoTest = vehiculoBuilder.build();
		Mockito.doReturn(cantidadMotosParqueadas).when(spyServicio).cantidadCeldasOcupadasPorTipoVehiculo(TIPO_VEHICULO_CARRO);
		
		//Act
		resultado = spyServicio.hayDisponibilidadParqueo(vehiculoTest);
		
		//Assert
		assertFalse(resultado);
	}
	
	
	@Test
	public void testHayDisponibilidadParqueoParaCarro() {
		
		//Arrange
		int cantidadCarrosParqueados = 15;
		IngresarVehiculoServicio servicio = new IngresarVehiculoServicio();
		IngresarVehiculoServicio spyServicio = Mockito.spy(servicio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_CARRO);
		VehiculoDTO vehiculoTest = vehiculoBuilder.build();
		Mockito.doReturn(cantidadCarrosParqueados).when(spyServicio).cantidadCeldasOcupadasPorTipoVehiculo(TIPO_VEHICULO_CARRO);
		
		//Act
		resultado = spyServicio.hayDisponibilidadParqueo(vehiculoTest);
		
		//Assert
		assertFalse(resultado);
	}
	
	@Test
	public void testNoHayDisponibilidadParqueoParaCarro() {
		
		//Arrange
		int cantidadCarrosParqueados = 22;
		IngresarVehiculoServicio servicio = new IngresarVehiculoServicio();
		IngresarVehiculoServicio spyServicio = Mockito.spy(servicio);
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_CARRO);
		VehiculoDTO vehiculoTest = vehiculoBuilder.build();
		Mockito.doReturn(cantidadCarrosParqueados).when(spyServicio).cantidadCeldasOcupadasPorTipoVehiculo(TIPO_VEHICULO_CARRO);
		
		//Act
		resultado = spyServicio.hayDisponibilidadParqueo(vehiculoTest);
		
		//Assert
		assertFalse(resultado);
	}
	/*
	@Test(expected = ExcepcionPlacaIniciaConA.class)
	public void testRegistrarVehiculoConLetraInicialA() {
		
		IGestionParqueaderoRepositorio gestionParqueaderoRepositorio = mock(IGestionParqueaderoRepositorio.class);
		IVehiculoRepositorio vehiculoRepositorio = mock(IVehiculoRepositorio.class);
		
		IngresarVehiculoServicio servicio = new IngresarVehiculoServicio(gestionParqueaderoRepositorio, vehiculoRepositorio);
		
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_MOTO).conPlaca(PLACA_CON_LETRA_A);
		VehiculoDTO vehiculoTest = vehiculoBuilder.build();
		
		servicio.registrarVehiculo(vehiculoTest);
		
	}*/
	
	
	@Test()
	public void testCuandoElRegistroDelVehiculoEsExitoso() {
		
		IGestionParqueaderoJPA gestionParqueaderoRepositorio = mock(IGestionParqueaderoJPA.class);
		IVehiculoJPA vehiculoRepositorio = mock(IVehiculoJPA.class);
		
		IngresarVehiculoServicio servicio = new IngresarVehiculoServicio(gestionParqueaderoRepositorio, vehiculoRepositorio);
		
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_MOTO).conPlaca("KEQ99D");
		VehiculoDTO vehiculoTest = vehiculoBuilder.build();
		
		servicio.registrarVehiculo(vehiculoTest);
		
	}
	
	
}
