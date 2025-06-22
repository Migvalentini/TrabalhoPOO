package trabalho;

public class Endereco {
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	
	public Endereco() {

	}
	
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

	@Override
	public String toString() {
	    return "  Endereço {" +
	           "Rua: " + rua +
	           " Número: " + numero +
	           " Complemento: " + complemento +
	           " Bairro: " + bairro +
	           " CEP: " + cep +
	           " Cidade: " + cidade +
	           " Estado: " + estado +
	           "}";
	}
	
	/*
	public String toStringTxt() {
        return rua + "," + numero + "," + complemento + "," + bairro + "," + cep + "," + cidade + "," + estado;
    }

	public static Endereco fromString(String texto) {
        String[] partes = texto.split(",");
        return new Endereco(partes[0], partes[1], partes[2], partes[3], partes[4], partes[5], partes[6]);
    }
    */
}
