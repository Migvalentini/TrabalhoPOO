package projeto;

import java.sql.Date;

public class Pedido {
	private static int ultimoCodigo = 0;
	private int codigo;
	private int numero;
	private Date dataPedido;
	private Date dataEntrega;
	private String situacao;
	
	public Pedido(int numero, Date dataPedido, Date dataEntrega, String situacao) {
		this.codigo = ultimoCodigo++;
		this.numero = numero;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.situacao = situacao;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "Pedido:\nCódigo=" + codigo + " Número=" + numero + " DataPedido=" + dataPedido + " DataEntrega="
				+ dataEntrega + " Situação=" + situacao;
	}
	
	
}
