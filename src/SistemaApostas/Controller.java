package SistemaApostas;

import java.util.ArrayList;

public class Controller {
	private int caixa;
	private double taxa;
	private int numCenario = 0;
	private ArrayList<Cenario> listaCenarios = new ArrayList<Cenario>();

	// INICIALIZACAO DO SISTEMA

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

	// CENARIOS

	public int cadastraCenario(String descricao) {
		this.numCenario++;
		Cenario cenario = new Cenario(descricao, numCenario);
		listaCenarios.add(cenario);
		return this.numCenario;
	}

	public int cadastrarCenario(String descricao, int bonus) {
		String mensagemDeErro = "Erro no cadastro de cenario: ";
		validadorBonus(bonus, mensagemDeErro);
		this.numCenario++;
		setCaixa(getCaixa() - bonus);
		CenarioComBonus cenarioB = new CenarioComBonus(descricao, numCenario, bonus);
		listaCenarios.add(cenarioB);
		return this.numCenario;
	}

	public String exibirCenario(int cenario) {
		int cenarioIndex = cenario - 1;
		String mensagemDeErro = "Erro na consulta de cenario: ";
		validadorNumCenario(cenarioIndex, mensagemDeErro);
		return listaCenarios.get(cenarioIndex).toString();
	}

	public String exibirCenarios() {
		String lista = "";
		if (listaCenarios.size() == 0) {
			return ("Nao ha cenarios cadastrados");
		} else {
			for (Cenario cen : listaCenarios) {
				lista += cen.toString();
			}
		}
		return lista;
	}

	private void validadorBonus(int bonus, String mensagemDeErro) {
		if (bonus <= 0) {
			throw new IllegalArgumentException(mensagemDeErro + "Bonus invalido");
		}
	}

	// APOSTAS

	public void cadastraAposta(int cenario, String apostador, int valor, String previsao) {
		int cenarioIndex = cenario - 1;
		String mensagemDeErro = "Erro no cadastro de aposta: ";
		validadorNumCenario(cenarioIndex, mensagemDeErro);
		validadorPrevisao(previsao);
		if (previsao.equals("N VAI ACONTECER")) {
			listaCenarios.get(cenarioIndex).cadastraAposta(apostador, valor, PrevisaoApostador.N_VAI_ACONTECER);
		} else {
			listaCenarios.get(cenarioIndex).cadastraAposta(apostador, valor, PrevisaoApostador.VAI_ACONTECER);
		}
	}

	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorSegurado,
			int custo) {
		setCaixa(getCaixa() + custo);
		return 0;
	}

	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxaSegurada,
			int custo) {
		return 0;
	}

	public int valorTotalDeApostas(int cenario) {
		int cenarioIndex = cenario - 1;
		String mensagemDeErro = "Erro na consulta do valor total de apostas: ";
		validadorNumCenario(cenarioIndex, mensagemDeErro);
		return listaCenarios.get(cenarioIndex).valorTotalDeApostas();
	}

	public int totalDeApostas(int cenario) {
		int cenarioIndex = cenario - 1;
		String mensagemDeErro = "Erro na consulta do total de apostas: ";
		validadorNumCenario(cenarioIndex, mensagemDeErro);
		return listaCenarios.get(cenarioIndex).totalDeApostas();
	}

	public String exibeApostas(int cenario) {
		int cenarioIndex = cenario - 1;
		return listaCenarios.get(cenarioIndex).exibeApostas();
	}

	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		return 0;
	}

	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa2) {
		return 0;
	}

	// Validadores aposta

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

	// ENCERRAR APOSTAS

	public void fecharAposta(int cenario, boolean ocorreu) {
		int cenarioIndex = cenario - 1;
		String mensagemDeErro = "Erro ao fechar aposta: ";
		validadorNumCenario(cenarioIndex, mensagemDeErro);
		if (listaCenarios.get(cenarioIndex).getStatus() != StatusCenario.NAO_FINALIZADO) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");

		} else {
			listaCenarios.get(cenarioIndex).finalizaCenario(ocorreu);
		}
	}

	public int getCaixaCenario(int cenario) {
		int cenarioIndex = cenario - 1;
		String mensagemDeErro = "Erro na consulta do caixa do cenario: ";
		validadorNumCenario(cenarioIndex, mensagemDeErro);
		if (listaCenarios.get(cenarioIndex).getStatus() == StatusCenario.NAO_FINALIZADO) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}
		double caixaCenario = Math.floor(listaCenarios.get(cenarioIndex).valorApostasPerdedoras() * this.taxa);
		int caixaCenario2 = (int) caixaCenario;
		return caixaCenario2;
	}

	public int getTotalRateioCenario(int cenario) {
		int cenarioIndex = cenario - 1;
		String mensagemDeErro = "Erro na consulta do total de rateio do cenario: ";
		validadorNumCenario(cenarioIndex, mensagemDeErro);
		if (listaCenarios.get(cenarioIndex).getStatus() == StatusCenario.NAO_FINALIZADO) {
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
		return (listaCenarios.get(cenarioIndex).valorApostasPerdedoras()
				- (int) Math.floor(listaCenarios.get(cenarioIndex).valorApostasPerdedoras() * this.taxa));
	}

	// VALIDADOR UNIVERSAL
	private void validadorNumCenario(int cenario, String mensagemDeErro) {
		if (cenario < 0) {
			throw new IllegalArgumentException(mensagemDeErro + "Cenario invalido");
		}
		if (cenario >= listaCenarios.size()) {
			throw new IllegalArgumentException(mensagemDeErro + "Cenario nao cadastrado");
		}
	}
}
