import easyaccept.EasyAccept;

public class Facade {
	public static void main(String[] args) {
		args = new String[] {"Facade", "acceptance_test/us2_test.txt"};
		EasyAccept.main(args);
	}
	
	Controller controller = new Controller();

	//INICIALIZAÇÃO DO SISTEMA
	
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
	
	public String exibirCenario(int cenario) {
		return controller.exibirCenario(cenario);
	}
	
	public String exibirCenarios() {
		return controller.exibirCenarios();
	}
	
	//APOSTAS
	
	public void cadastraAposta(int cenario, String apostador, int valor, PrevisaoApostador previsao) {
		controller.cadastraAposta(cenario, apostador, valor, previsao);
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
	
	//ENCERRAR APOSTAS
	
	public void fecharAposta(int cenario, boolean ocorreu) {
		controller.fecharAposta(cenario, ocorreu);
	}
	
	public int getCaixaCenario(int cenario) {           //FINALIZAR
		return controller.getCaixaCenario(cenario);
	}
	
	public int getTotalRateioCenario(int cenario) {     //FINALIZAR
		return 0;
	}
}

