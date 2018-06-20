public enum StatusCenario {
	NAO_FINALIZADO("Nao finalizado"), FINALIZADO_OCORREU("Finalizado (ocorreu)"), FINALIZADO_N_OCORREU("Finalizado (n ocorreu)");
	
	private final String mensagem;
	
	StatusCenario(String mensagemex){
		this.mensagem = mensagemex;
	}
	
	public String toString() {
		return mensagem;
	}
}
