public class Aposta {
	private String nomeApostador;
	private float valorAposta;
	private String previsao;
	
	public Aposta(String nomeApostador, float valorAposta, String previsao) {
		this.nomeApostador = nomeApostador;
		this.valorAposta = valorAposta;
		this.previsao = previsao;
	}
	
	@Override
	public String toString() {
		return (getNomeApostador() + " - " + getValorAposta() + " - " + getPrevisao());
	}

	private String getPrevisao() {
		return this.previsao;
	}

	private float getValorAposta() {
		return this.valorAposta;
	}

	private String getNomeApostador() {
		return this.nomeApostador;
	}
}