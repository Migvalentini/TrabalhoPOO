package br.ucs.poo.projeto.menu;

import java.util.Scanner;

public class Endereco {
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	
	public Endereco(String rua, String numero, String complemento, String bairro, String cep, String cidade, String estado) {
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public static Endereco criarEndereco(Scanner sc) {
		try {			
			System.out.println("Rua:");
			String rua = sc.nextLine();
			System.out.println("Número:");
			String numero = sc.nextLine();
			System.out.println("Complemento:");
			String complemento = sc.nextLine();
			System.out.println("Bairro:");
			String bairro = sc.nextLine();
			System.out.println("CEP:");
			String cep = sc.nextLine();
			System.out.println("Cidade:");
			String cidade = sc.nextLine();
			System.out.println("Estado:");
			String estado = sc.nextLine();
			
			return new Endereco(rua, numero, complemento, bairro, cep, cidade, estado);
		} catch(Exception ex) {
			System.out.println("Erro ao cadastrar endereço: " + ex);
			return null;
		}
    }

	@Override
	public String toString() {
	    return "Endereço {" +
	           "\n  Rua: " + rua +
	           "\n  Número: " + numero +
	           "\n  Complemento: " + complemento +
	           "\n  Bairro: " + bairro +
	           "\n  CEP: " + cep +
	           "\n  Cidade: " + cidade +
	           "\n  Estado: " + estado +
	           "\n}";
	}
	
	public String toStringTxt() {
        return rua + "," + numero + "," + complemento + "," + bairro + "," + cep + "," + cidade + "," + estado;
    }

	public static Endereco fromString(String texto) {
        String[] partes = texto.split(",");
        return new Endereco(partes[0], partes[1], partes[2], partes[3], partes[4], partes[5], partes[6]);
    }
}
