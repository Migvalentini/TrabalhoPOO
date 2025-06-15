package br.ucs.poo.projeto;

public class ItemPedido {
	private static int ultimoCodigo = 0;
	private int codigo;
	private int quantidade;
	private double preco;
	
	public ItemPedido(int quantidade, double preco) {
		this.codigo = ultimoCodigo++;
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
		return "ItemPedido:\nCódigo=" + codigo + " Quantidade=" + quantidade + " Preço=" + preco;
	}
	
	
}
