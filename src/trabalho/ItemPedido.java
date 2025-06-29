package trabalho;

public class ItemPedido {
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
	    return "ItemPedido" + 
	           " | Produto: " + (produto != null ? produto.getNome() : "sem produto") +
	           ", Quantidade: " + quantidade + 
	           ", Preço unitário: R$ " + String.format("%.2f", preco) + "\n";
	}

}
