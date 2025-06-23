package trabalho;

import java.util.ArrayList;
import java.util.Objects;

public class Fornecedor extends Pessoa implements Comparable<Fornecedor> {
	private static int ultimoCodigo = 0;
	private int codigo;
	private String descricao;
	private ArrayList<Produto> produtos = new ArrayList<>();
	
	public Fornecedor() {

	}

	public Fornecedor(String nome, String descricao, String telefone, String email, Endereco endereco, ArrayList<Produto> produtos) {
        super(nome, telefone, email, endereco);
        this.codigo = ultimoCodigo++;
        this.descricao = descricao;
        this.produtos = produtos;
    }
	
	public static void setUltimoCodigo(int ultimoCodigo) {
        Fornecedor.ultimoCodigo = ultimoCodigo;
    }

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	
    public void adicionarProduto(Produto produto) {
        if (this.produtos == null) {
            this.produtos = new ArrayList<Produto>();
        }
        produtos.add(produto);
    }
    
    public void removerProduto(Produto produto) {
        if (produto == null || produtos == null) return;

        produtos.remove(produto);
    }
	
	@Override
    public String toString() {
        StringBuilder produtosStr = new StringBuilder();

        if (produtos != null) {
            for (Produto p : produtos) {
                if (p != null) {
                    produtosStr.append("\n    - ").append(p.toString());
                }
            }
        } else {
            produtosStr.append("\n    Nenhum produto cadastrado.");
        }

        return "\nFornecedor:" +
                "\n  Código: " + codigo +
                "\n " + super.toString() +
                "\n  Descrição: " + descricao +
                "\n  Produtos:" + produtosStr;
    }

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		return codigo == other.codigo;
	}

	@Override
	public int compareTo(Fornecedor o) {
		Fornecedor a= o;
		return this.codigo -a.codigo;
	}
}
