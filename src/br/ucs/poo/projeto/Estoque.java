package br.ucs.poo.projeto;

public class Estoque {
	private int quantidade;
	private double preco;
	
	public Estoque() {

	}
	
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
	    StringBuilder sb = new StringBuilder();
	    
	    sb.append("Estoque:");
	    sb.append("\n    Quantidade: ").append(quantidade);
	    sb.append("\n    Preço: R$ ").append(String.format("%.2f", preco));
	    
	    return sb.toString();
	}
	/*
	public String toStringTxt() {
	    return quantidade + ";" + preco;
	}

	public static Estoque fromString(String linha) {
	    String[] partes = linha.split(";");
	    int quantidade = Integer.parseInt(partes[0]);
	    double preco = Double.parseDouble(partes[1]);
	    return new Estoque(quantidade, preco);
	}
	*/
}
