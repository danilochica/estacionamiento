package dominio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dominio.modelo.VehiculoDTO;
import dominio.servicio.VigilanteServicio;
import testdatabuider.VehiculoTestDataBuilder;

public class VehiculoTest {
	
	private static final String PLACA = "KEQ99D";
	private static final String TIPO_VEHICULO = "Moto";
	private static final int CILINDRAJE = 150;
	
	
	@Test
	public void crearVehiculoTest() {
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA).conTipoVehiculo(TIPO_VEHICULO).conCilindraje(CILINDRAJE);
		
		//Act
		VehiculoDTO vehiculo = vehiculoTestDataBuilder.build();
		
		//Assert
		assertEquals(PLACA, vehiculo.getPlaca());
		assertEquals(TIPO_VEHICULO, vehiculo.getTipoVehiculo());
		assertEquals(CILINDRAJE, vehiculo.getCilindraje(),0);
		
	}
	
	@Test
	public void testVehiculoPlacaConLetraInicialIgualA() {
		//Arrange 
		String placaRegistrada = "ASQ523";
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conPlaca(placaRegistrada);
		VehiculoDTO vehiculoTest = vehiculoBuilder.build();
		VigilanteServicio servicio = new VigilanteServicio();
		
		//Act
		boolean result = servicio.verificarLetraInicialPlaca(vehiculoTest);
		
		//Assert
		assertFalse(result);
		
	}
	
	@Test
	public void testVehiculoPlacaConLetraInicialDiferente() {
		//Arrange 
		String placaRegistrada = "KSQ523";
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conPlaca(placaRegistrada);
		VehiculoDTO vehiculoTest = vehiculoBuilder.build();
		VigilanteServicio servicio = new VigilanteServicio();
		
		//Act
		boolean result = servicio.verificarLetraInicialPlaca(vehiculoTest);
		
		//Assert
		assertTrue(result);
	}
	
	

}
