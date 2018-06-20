package SistemaApostas;

public class Aposta {
	private String nomeApostador;
	private int valorAposta;
	private PrevisaoApostador previsao;
	
	public Aposta(String nomeApostador, int valorAposta, PrevisaoApostador previsao) {
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
}