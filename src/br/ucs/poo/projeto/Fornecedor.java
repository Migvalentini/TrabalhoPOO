package br.ucs.poo.projeto;

import java.util.ArrayList;

public class Fornecedor extends Pessoa {
	private static int ultimoCodigo = 0;
	private int codigo;
	private String descricao;
	private ArrayList<Produto> produtos = new ArrayList<>();

	
	public Fornecedor(String nome, String descricao, String telefone, String email, Endereco endereco, ArrayList<Produto> produtos) {
        super(nome, telefone, email, endereco);
        this.codigo = ultimoCodigo++;
        this.descricao = descricao;
        this.produtos = produtos;
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

	/*
    @Override
    public String toStringTxt() {
        return super.toStringTxt() + ";" + descricao;
    }

    public static Fornecedor fromString(String texto) {
        String[] partes = texto.split(";", 5);
        Pessoa pessoa = Pessoa.fromString(partes[0] + ";" + partes[1] + ";" + partes[2] + ";" + partes[3]);
        String descricao = partes[4];
        return new Fornecedor(pessoa.getNome(), descricao, pessoa.getTelefone(), pessoa.getEmail(), pessoa.getEndereco(), null);
    }
    */
}
