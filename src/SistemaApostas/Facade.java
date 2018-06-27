package SistemaApostas;

import easyaccept.EasyAccept;

public class Facade {
	public static void main(String[] args) {
		args = new String[] {"SistemaApostas.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt", "acceptance_test/us3_test.txt", "acceptance_test/us4_test.txt", "acceptance_test/us5_test.txt", "acceptance_test/us6_test.txt"};
		EasyAccept.main(args);
	}
	
	private Controller controller = new Controller();

	//INICIALIZACAO DO SISTEMA
	
	public void inicializa(int caixa, double taxa) {
		controller.inicializaSistema(caixa, taxa);
	}
	
	public int getCaixa() {
		return controller.getCaixa();
	}
	
	//CENARIOS
	
	public int cadastrarCenario(String descricao) {
		return controller.cadastraCenario(descricao);
	}
	
	public int cadastrarCenario(String descricao, int bonus) {
		return controller.cadastrarCenario(descricao, bonus);
	}
	
	public String exibirCenario(int cenario) {
		return controller.exibirCenario(cenario);
	}
	
	public String exibirCenarios() {
		return controller.exibirCenarios();
	}
	
	//APOSTAS
	
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		controller.cadastraAposta(cenario, apostador, valor, previsao);
	}
	
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorSegurado, int custo) {
		return controller.cadastrarApostaSeguraValor(cenario, apostador, valor, previsao, valorSegurado, custo);
	}
	
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxaSegurada, int custo) {
		return controller.cadastrarApostaSeguraTaxa(cenario, apostador, valor, previsao, taxaSegurada
				, custo);
	}
	
	public int valorTotalDeApostas(int cenario) {
		return controller.valorTotalDeApostas(cenario);
	}
	
	public int totalDeApostas(int cenario) {
		return controller.totalDeApostas(cenario);
	}
	
	public String exibeApostas(int cenario) {
		return controller.exibeApostas(cenario);
	}
	
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		return controller.alterarSeguroValor(cenario, apostaAssegurada, valor);
	}
	
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		return controller.alterarSeguroTaxa(cenario, apostaAssegurada, taxa);
	}
	
	//ENCERRAR APOSTAS
	
	public void fecharAposta(int cenario, boolean ocorreu) {
		controller.fecharAposta(cenario, ocorreu);
	}
	
	public int getCaixaCenario(int cenario) {           //FINALIZAR
		return controller.getCaixaCenario(cenario);
	}
	
	public int getTotalRateioCenario(int cenario) {
		return controller.getTotalRateioCenario(cenario);
	}
}

