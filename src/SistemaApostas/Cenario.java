package SistemaApostas;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cenario {
	private String descricao;
	private int numeracao;
	private StatusCenario status;
	private ArrayList<Aposta> listaApostas = new ArrayList<Aposta>();
	private int valorTotal; 
	
	public Cenario(String descricao, int numeracao) {
		validadorDescricao(descricao);
		validadorNumeracao(numeracao);
		this.descricao = descricao;
		this.numeracao = numeracao;
		this.status = StatusCenario.NAO_FINALIZADO;
	}
	
	private void validadorNumeracao(int numeracao) {
		if (numeracao < 0) {
			throw new RuntimeException("????");
		}
	}

	private void validadorDescricao(String descricao) {
		if (descricao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		if (descricao.equals(null)) {
			throw new NullPointerException("Erro no cadastro de cenario: Descricao nao pode ser nula");
		}
	}

	public String toString() {
		return (getNumeracao() + " - " + getDescricao() + " - " + getStatus());
	}

	public int getNumeracao() {
		return (this.numeracao - 1);
	}

	private String conversorCentReal(int qtdCentavos) {
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("R$ #,##");                                ///////////////
		df.setRoundingMode(RoundingMode.DOWN);
		return df.format(qtdCentavos/100);
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public StatusCenario getStatus() {
		return status;
	}
	
	public String getStatusString() {
		return status.toString();
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

	public void cadastraAposta(String apostador, int valor, PrevisaoApostador previsao) {
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

	public int valorApostasPerdedoras() {
		int valorApostas = 0;
		for(Aposta ap : listaApostas) {
			if (getStatus().equals(StatusCenario.FINALIZADO_OCORREU) && ap.getPrevisao() == PrevisaoApostador.N_VAI_ACONTECER) {
				valorApostas += ap.getValorAposta();
			}
		}
		return valorApostas;
	}
}
