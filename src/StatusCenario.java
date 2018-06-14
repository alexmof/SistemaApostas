public enum StatusCenario {
	NAO_FINALIZADO("Não finalizado"), FINALIZADO_OCORREU("Finalizado (ocorreu)"), FINALIZADO_N_OCORREU("Finalizado (n ocorreu)");
	
	public String mensagem;
	
	StatusCenario(String mensagemex){
		mensagem = mensagemex;
	}
	public String retornoEnum() {
		return mensagem;
	}
}
