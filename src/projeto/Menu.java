package projeto;

import java.util.Scanner;

public class Menu {

	private static Scanner sc;
	private Carro carro;

	public Menu() {
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.mostra();
	}

	public void mostra() {

		int opcao = 0;
		sc = new Scanner(System.in);

		do {
			System.out.println("---------------------------------------------");
			System.out.println("Escolha a opção:");
			System.out.println(" 1 - Criar um carro");
			System.out.println(" 2 - Adicionar passageiro");
			System.out.println(" 3 - Remover passageiro");
			System.out.println(" 4 - Consultar lista de passageiros");
			System.out.println(" 5 - Consultar carga do carro");
			System.out.println(" 7 - Teste");
			System.out.println(" 0 - sair ");
			opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
			case 1:
				criarCarro();
				break;
			case 2:
				adicionarPassageiro();
				break;
			case 3:
				removerPassageiro();
				break;
			case 4:
				consultarLista();
				break;
			case 5:
				consultarCarga();
				break;
			case 0:
				System.out.println("Saindo...");
				System.exit(0);
			}
			System.out.println("---------------------------------------------");
		} while (opcao != 0);
		sc.close();
	}

	public boolean carroCriado() {
		if (this.carro == null) {
			System.out.println("Primeiro crie um carro!");
			return false;
		}
		return true;
	}

	public void criarCarro() {
		System.out.println("---------------------------------------------");
		System.out.println("Criar um carro:");
		System.out.println("Informe o nome do carro:");
		String nome = sc.nextLine();
		System.out.println("Informe a capacidade de carga do carro:");
		float capacidade = sc.nextFloat();
		sc.nextLine();
		this.carro = new Carro(nome, capacidade);
	}

	public void adicionarPassageiro() {
		if (carroCriado()) {
			System.out.println("---------------------------------------------");
			System.out.println("Adicionar uma pessoa:");
			System.out.println("Informe o nome da pessoa:");
			String nome = sc.nextLine();
			System.out.println("Informe o peso da pessoa:");
			float peso = sc.nextFloat();
			sc.nextLine();
			Pessoa p = new Pessoa(nome, peso);
			if (this.carro.adicionaPassageiro(p)) {
				System.out.println("Pessoa adicionada");
			} else {
				System.out.println("Não foi possível adicionar pessoa : Carro cheio");
			}
		}
	}

	public void removerPassageiro() {
		if (carroCriado()) {
			System.out.println("---------------------------------------------");
			System.out.println("Remover uma pessoa:");
			System.out.println("Informe o número do passageiro:");
			int nro = sc.nextInt();
			sc.nextLine();
			if (this.carro.removePassageiro(nro)) {
				System.out.println("Passageiro removido");
			} else {
				System.out.println("Não foi possível remover o passageiro");
			}
		}
	}

	public void consultarLista() {
		if (carroCriado()) {
			System.out.println("---------------------------------------------");
			System.out.println("Carro : " + this.carro.getNome());
			System.out.println("Lista de passageiros:");
			System.out.println(this.carro.getListaPassageiros());
		}
	}

	public void consultarCarga() {
		if (carroCriado()) {
			System.out.println("---------------------------------------------");
			System.out.println("Carro : " + this.carro.getNome());
			System.out.println("Carga Total : " + this.carro.getCargaTotal());
		}
	}

}
