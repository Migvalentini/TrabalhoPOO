package projeto;

import java.util.Arrays;
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
		return "Fornecedor:\nCódigo=" + codigo + " Nome=" + nome + " Descrição=" + descricao + " Telefone=" + telefone
				+ " Email=" + email + " Endereço=" + endereco + " Produtos=" + Arrays.toString(produtos);
	}
	
	
}
