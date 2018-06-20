package tests;

import static org.junit.Assert.*;

import org.junit.*;

import SistemaApostas.Cenario;
import SistemaApostas.StatusCenario;

public class CenarioTest {
	
	private Cenario cenarioBasico;
	
	@Before
	public void init() {
		cenarioBasico = new Cenario("Vou passar em P2", 1);
	}
	
	@Test
	public void toStringTest() {
		String esperado = "1 - Vou passar em P2 - Nao finalizado";
		assertEquals(esperado, cenarioBasico.toString());
	}
	
	@Test
	public void getNumeracaoTest() {
		int esperado = 1;
		assertEquals(esperado, cenarioBasico.getNumeracao());
	}
	
	@Test
	public void getDescricaoTest() {
		String esperado = "Vou passar em P2";
		assertEquals(esperado, cenarioBasico.getDescricao());
	}
	
	@Test
	public void getStatusTest() {
		StatusCenario esperado = StatusCenario.NAO_FINALIZADO;
		assertEquals(esperado, cenarioBasico.getStatus());
	}
	
	@Test
	public void getStatusStringTest() {
		String esperado = "Nao finalizado";
		assertEquals(esperado, cenarioBasico.getStatusString());
	}
}
