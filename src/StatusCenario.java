public enum StatusCenario {
	NAO_FINALIZADO("Não finalizado"), FINALIZADO_OCORREU("Finalizado (ocorreu)"), FINALIZADO_N_OCORREU("Finalizado (n ocorreu)");
	
	private final String mensagem;
	
	StatusCenario(String mensagemex){
		this.mensagem = mensagemex;
	}
	
	public String getInfoStatus() {
		return mensagem;
	}
}
