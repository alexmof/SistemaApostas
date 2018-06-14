public class Sistema {
	private int caixa;
	private double taxa;
	
	public Sistema(int caixa, double taxa) {
		this.caixa = caixa;
		this.taxa = taxa;
	}
	
	public int getCaixa() {
		return this.caixa;
	}
	
	public double getTaxa() {
		return this.taxa;
	}
}
