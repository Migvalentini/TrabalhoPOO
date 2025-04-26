package projeto;

public class Menu {

	public static void main(String[] args) {
		 Endereco endereco = new Endereco(
            "Rua das Flores",
            "123",
            "Apto 202",
            "Centro",
            "12345-678",
            "São Paulo",
            "SP"
        );

        Produto[] produtos = new Produto[0];

        Fornecedor fornecedor = new Fornecedor(
            "Fornecedor ABC",
            "Fornecedor de eletrônicos",
            "(11) 99999-9999",
            "contato@fornecedorabc.com",
            endereco,
            produtos
        );

        System.out.println("Fornecedor criado: " + fornecedor.getNome() + fornecedor.getEndereco().getRua());
	}

}
