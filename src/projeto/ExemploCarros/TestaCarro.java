package projeto.ExemploCarros;

public class TestaCarro {
	
	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa("Mickey", 50);
		Pessoa p2 = new Pessoa("Donald", 45);
		Pessoa p3 = new Pessoa("Pateta", 80);
		Pessoa p4 = new Pessoa("Minnie", 45);
		Pessoa p5 = new Pessoa("Clarabela", 80);
		Pessoa p6 = new Pessoa("Tio Patinhas", 50);
		
		
		Carro c = new Carro("Gol");
		
		
		System.out.println("Adicionando " + p1.getNome() + " ao carro : " + c.adicionaPassageiro(p1));
		System.out.println("Adicionando " + p2.getNome() + " ao carro : " + c.adicionaPassageiro(p2));
		System.out.println("Adicionando " + p3.getNome() + " ao carro : " + c.adicionaPassageiro(p3));
		System.out.println("Adicionando " + p4.getNome() + " ao carro : " + c.adicionaPassageiro(p4));
		System.out.println("Adicionando " + p5.getNome() + " ao carro : " + c.adicionaPassageiro(p5));
		System.out.println("Adicionando " + p6.getNome() + " ao carro : " + c.adicionaPassageiro(p6));
		
		System.out.println("Passageiros:");
		System.out.println(c.getListaPassageiros());
		
		int nro = 2;
		System.out.println("Removendo o passageiro " + nro + " " + c.removePassageiro(nro));
		
		System.out.println("Passageiros agora:");
		System.out.println(c.getListaPassageiros());
		
		System.out.println("Adicionando " + p6.getNome() + " ao carro : " + c.adicionaPassageiro(p6));
		
		System.out.println("Passageiros agora:");
		System.out.println(c.getListaPassageiros());
		
		System.out.println("Carga atual " + c.getCargaTotal());
		
		
		
	}

}
