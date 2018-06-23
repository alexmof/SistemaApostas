package SistemaApostas;

import java.util.ArrayList;

public class Controller {
	private int caixa;
	private double taxa;
	private int numCenario = 0;
	private ArrayList<Cenario> listaCenarios = new ArrayList<Cenario>();
	
	//INICIALIZACAO DO SISTEMA
	
	public void inicializaSistema(int caixa, double taxa) {
		validadorCaixa(caixa);
		validadorTaxa(taxa);		
		this.caixa = caixa;
		this.taxa = taxa;
	}

	private void validadorCaixa(int caixa) {
		if (caixa < 0) {
			throw new RuntimeException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
	}

	private void validadorTaxa(double taxa) {
		if (taxa < 0) {
			throw new RuntimeException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
	}

	public int getCaixa() {
		return this.caixa;
	}
	
	public void setCaixa(int novoValor) {
		this.caixa = novoValor;
	}
	
	//CENARIOS
	
	public int cadastraCenario(String descricao) {
		this.numCenario ++;
		Cenario cenario = new Cenario(descricao, numCenario);
		listaCenarios.add(cenario);
		return this.numCenario;
	}

	public String exibirCenario(int cenario) {
		validadorCenario(cenario);
		return listaCenarios.get(cenario - 1).toString();
	}

	private void validadorCenario(int cenario) {
		if (cenario < 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		}
		if (cenario > listaCenarios.size()) {
			throw new IndexOutOfBoundsException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
	}
	
	public String exibirCenarios() {
		String lista = "";
		if (listaCenarios.size() == 0) {
			return ("Nao ha cenarios cadastrados");
		} else {
			for(Cenario cen : listaCenarios) {
				lista += cen.toString();
			}
		}
		return lista;
	}

	public int cadastraCenario(String descricao, int bonus) {
		
		setCaixa(getCaixa() - bonus);
		return 0;
	}
	
	//APOSTAS
	
	public void cadastraAposta(int cenario, String apostador, int valor, String previsao) {
		String mensagemDeErro = "Erro no cadastro de aposta: ";
		validadorNumCenario(cenario, mensagemDeErro);
		validadorPrevisao(previsao);
		if (previsao.equals("N VAI ACONTECER")) {
			listaCenarios.get(cenario - 1).cadastraAposta(apostador, valor, PrevisaoApostador.N_VAI_ACONTECER);
		} else {
			listaCenarios.get(cenario - 1).cadastraAposta(apostador, valor, PrevisaoApostador.VAI_ACONTECER);
		}
	}


	public int valorTotalDeApostas(int cenario) {
		String mensagemDeErro = "Erro na consulta do valor total de apostas: ";
		validadorNumCenario(cenario, mensagemDeErro);
		return listaCenarios.get(cenario - 1).valorTotalDeApostas();
	}

	public int totalDeApostas(int cenario) {
		return listaCenarios.get(cenario - 1).totalDeApostas();
	}

	public String exibeApostas(int cenario) {
		return listaCenarios.get(cenario).exibeApostas();
	}
	
	  //Validadores aposta
	
	private void validadorNumCenario(int cenario, String mensagemDeErro) {
		if (cenario <= 0) {
			throw new IllegalArgumentException(mensagemDeErro + "Cenario invalido");
		} 
		if (cenario > listaCenarios.size()) {
			throw new IllegalArgumentException(mensagemDeErro  + "Cenario nao cadastrado");
		}
	}
	
	private void validadorPrevisao(String previsao) {
		if (previsao.equals(null)) {
			throw new NullPointerException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}
		if (previsao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}
		if (!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}
	}
	
	//ENCERRAR APOSTAS
	
	public void fecharAposta(int cenario, boolean ocorreu) {
		listaCenarios.get(cenario).finalizaCenario(ocorreu);
	}
	
	public int getCaixaCenario(int cenario) {
		double caixaCenario = Math.floor(listaCenarios.get(cenario).valorApostasPerdedoras() * this.taxa);
		int caixaCenario2 = (int) caixaCenario;
		return caixaCenario2;
	}
	
	public int getTotalRateioCenario(int cenario) {
		return 0;
	}

}
