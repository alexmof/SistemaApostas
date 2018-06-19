import java.util.ArrayList;

public class Cenario {
	private String descricao;
	private boolean ocorreu;
	private int numeracao;
	private StatusCenario status;
	private ArrayList<Aposta> listaApostas = new ArrayList<Aposta>();
	private int valorTotal; 
	
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
	
	public void setStatus(StatusCenario status) {
		this.status = status;
	}
	
	public void finalizaCenario(boolean ocorreu) {
		if (ocorreu == true) {
			setStatus(StatusCenario.FINALIZADO_OCORREU);
		} else {
			setStatus(StatusCenario.FINALIZADO_N_OCORREU);
		}
	}
	
	public int valorTotalDeApostas() {
		for(Aposta ap : listaApostas) {
			this.valorTotal += ap.getValorAposta();
		}
		return valorTotal;
	}

	public void cadastraAposta(String apostador, int valor, String previsao) {
		Aposta aposta = new Aposta(apostador, valor, previsao);
		listaApostas.add(aposta);
	}

	public int totalDeApostas() {
		return listaApostas.size();
	}

	public String exibeApostas() {
		String stringTodasApostas = "";
		for(Aposta ap : listaApostas) {
			stringTodasApostas += ap.toString() + System.lineSeparator();
		}
		return stringTodasApostas;
	}
	
}
