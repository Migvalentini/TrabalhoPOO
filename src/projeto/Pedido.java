package projeto;

import java.sql.Date;

public class Pedido {
	private static int ultimoCodigo = 0;
	private int codigo;
	private int idCliente;
	private int numero;
	private Date dataPedido;
	private Date dataEntrega;
	private TipoPedido situacao;
	
	public Pedido(int idCliente, int numero, Date dataPedido, Date dataEntrega, TipoPedido situacao) {
		this.codigo = ultimoCodigo++;
		this.idCliente = idCliente;
		this.numero = numero;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.situacao = situacao;
	}

	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

	public TipoPedido getSituacao() {
		return situacao;
	}

	public void setSituacao(TipoPedido situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "Pedido:\nCódigo=" + codigo + " Número=" + numero + " DataPedido=" + dataPedido + " DataEntrega="
				+ dataEntrega + " Situação=" + situacao;
	}
	
	
}
