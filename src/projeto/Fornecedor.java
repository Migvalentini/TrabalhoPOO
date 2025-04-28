package projeto;

import java.util.Scanner;

public class Fornecedor {
	private static int ultimoCodigo = 0;
	private int codigo;
	private String nome;
	private String descricao;
	private String telefone;
	private String email;
	private Endereco endereco;
	private Produto produtos[];
	
	public Fornecedor(String nome, String descricao, String telefone, String email, Endereco endereco, Produto produtos[]) {
		this.codigo = ultimoCodigo++;
		this.nome = nome;
		this.descricao = descricao;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.produtos = produtos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Produto[] getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produtos[]) {
		this.produtos = produtos;
	}
	
    public void adicionarProduto(Produto produto) {
        if (this.produtos == null) {
            this.produtos = new Produto[100];
        }
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] == null) {
                produtos[i] = produto;
                break;
            }
        }
    }

	public static Fornecedor criarFornecedor(Scanner sc) {
        System.out.println("Nome do fornecedor:");
        String nome = sc.nextLine();
        System.out.println("Descrição:");
        String descricao = sc.nextLine();
        System.out.println("Telefone:");
        String telefone = sc.nextLine();
        System.out.println("Email:");
        String email = sc.nextLine();
        Endereco endereco = Endereco.criarEndereco(sc);
        
        return new Fornecedor(nome, descricao, telefone, email, endereco, null);
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

	    StringBuilder enderecoStr = new StringBuilder();
	    if (endereco != null) {
	        enderecoStr.append("\n    Rua: ").append(endereco.getRua());
	        enderecoStr.append("\n    Número: ").append(endereco.getNumero());
	        enderecoStr.append("\n    Complemento: ").append(endereco.getComplemento());
	        enderecoStr.append("\n    Bairro: ").append(endereco.getBairro());
	        enderecoStr.append("\n    CEP: ").append(endereco.getCep());
	        enderecoStr.append("\n    Cidade: ").append(endereco.getCidade());
	        enderecoStr.append("\n    Estado: ").append(endereco.getEstado());
	    } else {
	        enderecoStr.append("\n    Não informado");
	    }
	    
	    return "\nFornecedor:"
	         + "\n  Código: " + codigo
	         + "\n  Nome: " + nome
	         + "\n  Descrição: " + descricao
	         + "\n  Telefone: " + telefone
	         + "\n  Email: " + email
	         + "\n  Endereço:" + enderecoStr
	         + "\n  Produtos:" + produtosStr;
	}
}
