package trabalho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Pedido {
	private static int ultimoCodigo = 0;
	private int codigo;
	private int idCliente;
	private Date dataPedido;
	private Date dataEntrega;
	private Date dataEnvio;
	private Date dataCancelamento;
	private TipoPedido situacao;
	private ArrayList<ItemPedido> itensPedido = new ArrayList<ItemPedido>();
	private double totalPedido;

	public Pedido() {
		
	}
	
	public Pedido(int idCliente, Date dataPedido, Date dataEntrega, Date dataEnvio, Date dataCancelamento, TipoPedido situacao, ItemPedido itemPedido, double totalPedido) {
		this.codigo = ultimoCodigo++;
		this.idCliente = idCliente;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.dataCancelamento = dataCancelamento;
		this.situacao = situacao;
		this.itensPedido = new ArrayList<>(Arrays.asList(itemPedido));
		this.totalPedido = totalPedido;
	}
	
	public static void setUltimoCodigo(int ultimoCodigo) {
        Pedido.ultimoCodigo = ultimoCodigo;
    }

	public void adicionarItem(ItemPedido itemPedido) {
		itensPedido.add(itemPedido);
    }

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Date getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(Date dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
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
	
	public double getTotalPedido() {
		return totalPedido;
	}
	
	public void setTotalPedido(double totalPedido) {
		this.totalPedido = totalPedido;
	}
	
	public void adicionarTotalPedido(double totalPedido) {
		this.totalPedido += totalPedido;
	}
	
	public void adicionarICMS() {
		this.totalPedido *= 1.17;
	}

	public void addItensPedido(ItemPedido item) {
		this.itensPedido.add(item);
	}

	@Override
	public String toString() {
	    return "Pedido #" + codigo + 
	           " | Cliente ID: " + idCliente + 
	           ", Data do Pedido: " + dataPedido + 
	           ", Entrega: " + (dataEntrega != null ? dataEntrega : "não entregue") +
	           ", Envio: " + (dataEnvio != null ? dataEnvio : "não enviado") +
	           ", Cancelamento: " + (dataCancelamento != null ? dataCancelamento : "não cancelado") +
	           ", Situação: " + situacao +
	           ", Total: R$ " + String.format("%.2f", totalPedido) + 
	           ", Itens:\n" + itensPedido;
	}
}
