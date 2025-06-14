package br.ucs.poo.projeto;

import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;

public class Pedido {
	private static int ultimoCodigo = 0;
	private int codigo;
	private int idCliente;
	private Date dataPedido;
	private Date dataEntrega;
	private TipoPedido situacao;
	private ArrayList<ItemPedido> itensPedido = new ArrayList<ItemPedido>();
	
	public Pedido(int idCliente, Date dataPedido, Date dataEntrega, TipoPedido situacao, ItemPedido itemPedido) {
		this.codigo = ultimoCodigo++;
		this.idCliente = idCliente;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.situacao = situacao;
		this.itensPedido = new ArrayList<>(Arrays.asList(itemPedido));
	}

	public void adicionarItem(ItemPedido itemPedido) {
		itensPedido.add(itemPedido);
    }

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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
	
	public ArrayList<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(ArrayList<ItemPedido> itensPedidos) {
		this.itensPedido = itensPedidos;
	}
	
	public void addItensPedido(ItemPedido item) {
		this.itensPedido.add(item);
	} 
	
	@Override
	public String toString() {
		return "Pedido [codigo=" + codigo + ", idCliente=" + idCliente + ", dataPedido=" + dataPedido + ", dataEntrega="
				+ dataEntrega + ", situacao=" + situacao + ", itensPedidos=" + itensPedido + "]";
	}

}
