package projeto;

public class Estoque {
	private int quantidade;
	private double preco;
	
	public Estoque(int quantidade, double preco) {
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Quantidade=" + quantidade + " Preço=" + preco;
	}
	
	
}
