package br.ucs.poo.projeto;

import java.util.Objects;

public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private String telefone;
    private String email;
    private Endereco endereco;
    
    public Pessoa() {
    	
	}

	public Pessoa(String nome, String telefone, String email, Endereco endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    @Override
    public String toString() {
        return " Nome=" + nome + ",\n  Telefone=" + telefone + ",\n  Email=" + email + ",\n  Endereco=" + endereco;
    }
    @Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(nome, other.nome);
	}
	
	public int compareTo(Pessoa o) {
		Pessoa a= o;

		return this.getNome().compareTo(a.getNome());
	}
	
	
	public int compareTo(Fornecedor o) {
		Fornecedor a= o;
		
		return this.getNome().compareTo(a.getNome());
	}

	public int compareTo(Cliente o) {
		return 0;
	}
	
	
    /*
    public String toStringTxt() {
        return nome + ";" + telefone + ";" + email + ";" + (endereco != null ? endereco.toStringTxt() : "");
    }

    public static Pessoa fromString(String linha) {
        String[] partes = linha.split(";", 4);
        String nome = partes[0];
        String telefone = partes[1];
        String email = partes[2];
        Endereco endereco = Endereco.fromString(partes[3]);
        return new Pessoa(nome, telefone, email, endereco);
    }
    */


	
}