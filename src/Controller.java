import java.util.ArrayList;

public class Controller {
	private int caixa;
	private double taxa;
	private int numCenario = 0;
	private ArrayList<Cenario> listaCenarios = new ArrayList<Cenario>();
	
	//INICIALIZACAO DO SISTEMA
	
	public void inicializaSistema(int caixa, double taxa) {
		this.caixa = caixa;
		this.taxa = taxa;
	}

	public int getCaixa() {
		return this.caixa;
	}

	
	
	//CENARIOS
	
	public int cadastraCenario(String descricao) {
		this.numCenario ++;
		Cenario cenario = new Cenario(descricao, numCenario);
		listaCenarios.add(cenario);
		return this.numCenario;
	}

	public String exibirCenario(int cenario) {
		return listaCenarios.get(cenario - 1).toString();
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

	//APOSTAS
	
	public void cadastraAposta(int cenario, String apostador, int valor, String previsao) {
		listaCenarios.get(cenario).cadastraAposta(apostador, valor, previsao);
	}

	public int valorTotalDeApostas(int cenario) {
		return listaCenarios.get(cenario - 1).valorTotalDeApostas();
	}

	public int totalDeApostas(int cenario) {
		return listaCenarios.get(cenario).totalDeApostas();
	}

	public String exibeApostas(int cenario) {
		return listaCenarios.get(cenario).exibeApostas();
	}
	
	//ENCERRAR APOSTAS
	
public void fecharAposta(int cenario, boolean ocorreu) {
		listaCenarios.get(cenario).finalizaCenario(ocorreu);
	}
	
	public int getCaixaCenario(int cenario) {
		return 0;
	}
	
	public int getTotalRateioCenario(int cenario) {
		return 0;
	}
}
