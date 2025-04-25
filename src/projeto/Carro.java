package projeto;

public class Carro {

	private static final int CAPACIDADE_PASSAGEIROS = 5;
	private static final float CAPACIDADE_CARGA = 500f;
	
	private String nome;
	private Pessoa[] passageiros;
	private int quantosPassageiros;
	private float capacidadeCarga;
	private float carga;
	
	public Carro() {
		this.passageiros = new Pessoa[CAPACIDADE_PASSAGEIROS];
		this.quantosPassageiros = 0;
		this.capacidadeCarga = CAPACIDADE_CARGA;
		this.carga = 0;
	}
	
	public Carro(String nome) {
		this();
		this.nome = nome;
	}
	
	public Carro(String nome, float capacidadeCarga) {
		this();
		this.nome = nome;
		this.capacidadeCarga = capacidadeCarga;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pessoa[] getPassageiros() {
		return passageiros;
	}

	public void setQuantosPassageiros(int quantosPassageiros) {
		this.quantosPassageiros = quantosPassageiros;
	}

	public float getCapacidadeCargaLivre() {
		return capacidadeCarga - this.carga;
	}

	public float getCarga() {
		return this.carga;
	}
	
	public boolean adicionaCarga(float carga) {
		if(carga <= this.getCapacidadeCargaLivre()) {
			this.carga += carga;
			return true;
		} else {
			return false; // impossível adicionar : já está cheio
		}
	}
	
	public boolean removeCarga(float carga) {
		if(carga <= this.getCarga()) {
			this.carga -= carga;
			return true;
		} else {
			return false; // impossível remover : bão tem tudo isso
		}
	}
	
	public boolean adicionaPassageiro(Pessoa pessoa) {
		if(this.quantosPassageiros < CAPACIDADE_PASSAGEIROS) {
			this.passageiros[this.quantosPassageiros] = pessoa;
			this.quantosPassageiros++;
			return true;
		} else {
			return false; // Carro já está cheio
		}
	}
	
	public Pessoa getPassageiro(int numero) { // passageiros tem números de 1 até 5
		if(numero < 1 || numero > CAPACIDADE_PASSAGEIROS) { // número impossível
			return null; 
		}
		return this.passageiros[numero-1];
	}
	
	public boolean removePassageiro(int numero) { // passageiros tem números de 1 até 5
		if(numero < 1 || numero > CAPACIDADE_PASSAGEIROS) { // número impossível
			return false; 
		} else {
			for(int i = numero-1; i < quantosPassageiros -1;i++) {
				this.passageiros[i] = this.passageiros[i+1];
			}
			if(quantosPassageiros>0 && numero <= quantosPassageiros) {
				this.passageiros[quantosPassageiros-1] = null;
				this.quantosPassageiros--;
				return true;
			} else {
				return false;
			}
		}
	}
	
	public float getCargaTotal() {
		float total = this.carga;
		for(int i = 0; i < quantosPassageiros; i++) {
			total += this.passageiros[i].getPeso();
		}
		return total;
	}
	
	public String getListaPassageiros() {
		if(quantosPassageiros==0) {
			return "Vazio";
		} else {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < quantosPassageiros; i++) {
				sb.append((i + 1));
				sb.append(" : ");
				sb.append(this.passageiros[i].getNome());
				sb.append("\n");
			}
			return sb.toString();
		}
	}		
}
