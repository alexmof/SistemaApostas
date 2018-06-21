package SistemaApostas;

public enum PrevisaoApostador {
	VAI_ACONTECER("VAI ACONTECER"),N_VAI_ACONTECER("N VAI ACONTECER");
	
	private String mensagem;
	
	PrevisaoApostador(String prev){
		this.mensagem = prev;
	}
	
	public String getPrevisaoApostador() {
		return mensagem;
	}
}
