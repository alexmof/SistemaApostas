package SistemaApostas;

public class CenarioComBonus extends Cenario {
	
	private int bonus;
	
	public CenarioComBonus(String descricao,int numeracao, int bonus) {
		super(descricao, numeracao);
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		return (getNumeracao() + " - " + getDescricao() + " - " + getStatusString() + " - " + getBonus());
	}

	private int getBonus() {
		return this.bonus;
	}
	
	private double getBonusReais() {
		getBonus();
		return 0;
	}
}
