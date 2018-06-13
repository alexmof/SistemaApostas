public class Cenario {
	private String descricao;
	private boolean ocorreu;
	private int numeracao;
	private boolean finalizado;
	
	public Cenario(String descricao) {
		this.descricao = descricao;
		this.numeracao = 0; //CRIAR UM CONTADOR STATIC DA CLASSE
		this.ocorreu = false;
		this.finalizado = false;
	}
	
	public String toString() {
		return (getNumeracao() + " - " + getDescricao() + " - " + getEstado());
	}

	private int getNumeracao() {
		return this.numeracao;
	}

	private String getEstado() {
		if (this.finalizado == true) {
			if(this.ocorreu == true) {
				return ("Finalizado (ocorreu)");
			} else {
				return ("Finalizado (n ocorreu)");
			}
		} else {
			return ("Não finalizado");
		}
	}

	private String getDescricao() {
		return this.descricao;
	}
}
