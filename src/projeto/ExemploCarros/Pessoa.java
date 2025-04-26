package projeto.ExemploCarros;

public class Pessoa {
	
	private String nome;
	private float peso;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, float peso) {
		this.nome = nome;
		this.peso = peso;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	

}
