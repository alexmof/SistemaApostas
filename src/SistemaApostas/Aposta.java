package SistemaApostas;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Aposta {
	private String nomeApostador;
	private int valorAposta;
	private PrevisaoApostador previsao;
	
	public Aposta(String nomeApostador, int valorAposta, PrevisaoApostador previsao) {
		validadorApostador(nomeApostador);
		validadorValorAposta(valorAposta);
		this.nomeApostador = nomeApostador;
		this.valorAposta = valorAposta;
		this.previsao = previsao;
	}

	@Override
	public String toString() {
		return (getNomeApostador() + " - " + getValorAposta() + " - " + getPrevisaoString());
	}

	public String getPrevisaoString() {
		return this.previsao.getPrevisaoApostador();
	}
	
	public PrevisaoApostador getPrevisao() {
		return this.previsao;
	}

	public int getValorAposta() {
		return this.valorAposta;
	}

	public String getNomeApostador() {
		return this.nomeApostador;
	}
	
	// MÉTODOS VALIDADORES
	
	private void validadorApostador(String nomeApostador) {
		if (nomeApostador.equals(null)) {
			throw new NullPointerException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		if (nomeApostador.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
	}
		
	private void validadorValorAposta(int valorAposta) {
		if (valorAposta <= 0 ) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
	}
	
	/*private void validadorPrevisao(PrevisaoApostador previsao) {
		if (!previsao.toString().equals("VAI ACONTECER") && !previsao.toString().equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}
	}*/
}