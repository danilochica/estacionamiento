package estacionamiento.integracion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import estacionamiento.EstacionamientoApplication;
import estacionamiento.dominio.modelo.Vehiculo;
import estacionamiento.testdatabuider.VehiculoTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EstacionamientoApplication.class)
@AutoConfigureMockMvc
public class ServicioParqueaderoTestIntegracion {
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testCuandoSeAlmacenaUnVehiculo() throws Exception {
		
		String placaRegistrada = "ZZZ999";
		String tipoVehiculo= "Carro";
		int cilindraje = 400;
		VehiculoTestDataBuilder vehiculoBuilder = new VehiculoTestDataBuilder().conPlaca(placaRegistrada).conTipoVehiculo(tipoVehiculo).conCilindraje(cilindraje);
		Vehiculo vehiculoTest = vehiculoBuilder.build();
		
		mockMvc.perform(post("/parqueadero")
				.content(new ObjectMapper().writeValueAsString(vehiculoTest))
				.contentType(MediaType.APPLICATION_JSON))				
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.vehiculo.placa").value(placaRegistrada));
	}
	
	@Test
	public void testObtenerVehiculosParqueados() throws Exception {
		
		mockMvc.perform(get("/parqueadero")
				.contentType(MediaType.APPLICATION_JSON))				
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
	}
	
	
	@Test
	public void testSalidaParqueadero() throws Exception {
		String placaRegistrada = "AAA003";
		
		mockMvc.perform(put("/parqueadero/registrarSalida/{placa}", placaRegistrada))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.estadoRegistro").value(false))
			.andExpect(jsonPath("$.valorServicio").isNotEmpty())
			.andExpect(jsonPath("$.fechaSalida").isNotEmpty());
			
	}


	
}
