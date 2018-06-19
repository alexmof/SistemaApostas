import java.util.ArrayList;

public class Cenario {
	private String descricao;
	private boolean ocorreu;
	private int numeracao;
	private StatusCenario status;
	private ArrayList Aposta = new ArrayList();
	
	public Cenario(String descricao, int numeracao) {
		this.descricao = descricao;
		this.numeracao = numeracao;
		this.ocorreu = false;
		this.status = StatusCenario.NAO_FINALIZADO;
	}
	
	public String toString() {
		return (getNumeracao() + " - " + getDescricao() + " - " + getFinalizado());
	}

	public int getNumeracao() {
		return this.numeracao;
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	public String getFinalizado() {
		return status.getInfoStatus();
	}
	
	public void setStatus() {
		
	}
	
	public String finalizaCenario() {
		
	}
	
}
