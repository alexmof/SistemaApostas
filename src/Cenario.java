import java.util.ArrayList;

public class Cenario {
	private String descricao;
	private boolean ocorreu;
	private int numeracao;
	private StatusCenario finalizado;
	private ArrayList Aposta = new ArrayList();
	
	public Cenario(String descricao, int numeracao) {
		this.descricao = descricao;
		this.numeracao = numeracao; //CRIAR UM CONTADOR STATIC DA CLASSE
		this.ocorreu = false;
		this.finalizado = StatusCenario.NAO_FINALIZADO;
	}
	
	public String toString() {
		return (getNumeracao() + " - " + getDescricao() + " - " + getEstado());
	}

	public int getNumeracao() {
		return this.numeracao;
	}

	/*private String getEstado() {
		if (this.finalizado == true) {
			if(this.ocorreu == true) {
				return ("Finalizado (ocorreu)");
			} else {
				return ("Finalizado (n ocorreu)");
			}
		} else {
			return ("Não finalizado");
		}
	}*/

	public String getDescricao() {
		return this.descricao;
	}
	
	public String getFinalizado() {
		return StatusCenario.retornoEnum();
	}
}
