package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import SistemaApostas.Controller;

public class ControllerTest {
	
	private Controller c = new Controller();
	
	@Test
	public void valorTotalDeApostasTest() {
		String esperado = "Erro na consulta do valor total de apostas: Cenario invalido";
		assertEquals(esperado, c.valorTotalDeApostas(0));
	}
}
