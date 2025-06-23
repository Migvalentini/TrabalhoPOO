package trabalho;

public class ItemPedido {
	private int codigo;
	private Produto produto;
	private int quantidade;
	private double preco;
	
	public ItemPedido() {

	}
	
	public ItemPedido(Produto produto, int quantidade, double preco) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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
		return "ItemPedido [codigo=" + codigo + ", produto=" + produto + ", quantidade=" + quantidade + ", preco="
				+ preco + "]";
	}
}
