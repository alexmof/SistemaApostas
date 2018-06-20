package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import SistemaApostas.Aposta;
import SistemaApostas.PrevisaoApostador;

public class ApostaTest {
	
	private	Aposta apostaBasica;
	
	@Before
	public void init() {
		apostaBasica = new Aposta("Alex Micaela", 1000, PrevisaoApostador.VAI_ACONTECER);
	}
	
	@Test
	public void toStringTest() {
		String esperado = "Alex Micaela - 1000 - VAI ACONTECER";
		assertEquals(esperado, apostaBasica.toString());
	}
	
	@Test
	public void getPrevisaoStringTest() {
		String esperado = "VAI ACONTECER";
		assertEquals(esperado, apostaBasica.getPrevisaoString());
	}
	
	@Test
	public void getPrevisaoTest() {
		PrevisaoApostador esperado = PrevisaoApostador.VAI_ACONTECER;
		assertEquals(esperado, apostaBasica.getPrevisao());
	}
	
	@Test
	public void getValorApostaTest() {
		int esperado = 1000;
		assertEquals(esperado, apostaBasica.getValorAposta());
	}
	
	@Test
	public void getNomeApostadorTest() {
		String esperado = "Alex Micaela";
		assertEquals(esperado, apostaBasica.getNomeApostador());
	}
}
