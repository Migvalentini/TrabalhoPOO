package projeto;

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.Scanner;

public class Menu {
	private static Loja loja = new Loja();
	private static Menu menu = new Menu();
	
	public static void main(String[] args) {
		//abrirArquivos(arquivos);
		//leArquivo(usuarios, "usuarios", Usuario.class);
		
		Scanner sc = new Scanner(System.in);
		boolean continuar = true;

		System.out.println("SEJA MUITO BEM-VINDO(A) AO SISTEMA DE COMPRAS DESENVOLVIDO PELOS ALUNOS MIGUEL VALENTINI, HENRY PECATTI TIBOLA E VINICIUS BAREA PARA A DISCPLINA DE POO!");
		
		while (continuar) {
			System.out.println("\n" + loja.linha() + "\n         Menu Principal\n" + loja.linha());
			System.out.println("1 - Cadastrar usuário");
			System.out.println("2 - Excluir usuário");
			System.out.println("3 - Realizar login");
			System.out.println("4 - Mostrar usuários cadastrados");
			System.out.println("5 - Facilitar testes");
			System.out.println("0 - Sair");
			System.out.print("Opção: ");
			
			String resposta = sc.nextLine();
			
			switch (resposta) {
			case "1":
				if(loja.cadastrarUsuario(sc)) {
					System.out.println("\nUsuário cadastrado com sucesso!");
				} else {
					System.out.println("\nErro no cadastro do usuário!");
				}
				break;
			case "2":
				if(loja.excluirUsuario(sc)) {					
					System.out.println("\nUsuário excluído com sucesso!");
				} else {
					System.out.println("\nFalha na exclusão do usuário!");
				}
				break;
			case "3":
				menu.realizarLogin(sc);
				break;
			case "4":
				loja.mostrarUsuarios();
				break;
			case "5":
				loja.usuarios[loja.posicaoVazia(loja.usuarios)] = new Usuario("m", "1", TipoUsuario.ADMIN, null);
				menu.menuAdministrador(null, sc);
				break;
			case "0":
				continuar = false;
				System.out.println("\nEncerrando sistema...");
				//escreveNoArquivo(usuarios, "usuarios");
				break;
			default:
				System.out.println("\nOpção inválida!");
			}
		}
		
		sc.close();
	}
	
    public void menuAdministrador(Usuario usuario, Scanner sc) {
    	boolean continuar = true;
    	System.out.println("\nLogin como ADMINISTRADOR realizado com sucesso!");
    	
    	while (continuar) {
    		System.out.println("\n" + loja.linha() + "\n     Menu de Administrador\n" + loja.linha());
    		System.out.println("-- Fornecedores --");
    		System.out.println(" 1 - Cadastrar fornecedor");
    		System.out.println(" 2 - Editar fornecedor");
    		System.out.println(" 3 - Excluir fornecedor");
    		System.out.println(" 4 - Consultar fornecedores por código/nome");
    		System.out.println(" 5 - Consultar todos fornecedores");
    		System.out.println("\n-- Produtos --");
    		System.out.println(" 6 - Cadastrar produto");
    		System.out.println(" 7 - Editar produto");
    		System.out.println(" 8 - Excluir produto");
    		System.out.println(" 9 - Consultar produtos por código/nome");
    		System.out.println("10 - Consultar todos produtos");
    		System.out.println("11 - Vincular produto a um fornecedor");
    		System.out.println("12 - Editar estoque de produto");
    		System.out.println("\n99 - Facilitar testes");
    		System.out.println(" 0 - Voltar ao menu principal");
    		System.out.print("Opção: ");
    		
    		String resposta = sc.nextLine();
    		
    		switch (resposta) {
    		case "1":
    			if(loja.cadastrarFornecedor(sc)) {
    				System.out.println("\nFornecedor cadastrado com sucesso!");
    			} else {
    				System.out.println("\nErro no cadastro do fornecedor");
    			}
    			break;
    		case "2":
    			if(loja.editarFornecedor(sc)) {
    				System.out.println("\nFornecedor editado com sucesso!");
    			} else {
    				System.out.println("\nFalha ao editar fornecedor");
    			}
    			break;
    		case "3":
    			if(loja.excluirFornecedor(sc)) {
    				System.out.println("\nFornecedor excluído com sucesso!");
    			} else {
    				System.out.println("\nFalha ao excluir fornecedor");
    			}
    			break;
    		case "4":
    			Fornecedor[] fo = loja.consultarFornecedores(sc);
    			loja.mostrarFornecedores(fo);
    			break;
    		case "5":
    			loja.mostrarFornecedores(loja.fornecedores);
    			break;
    		case "6":
    			if(loja.cadastrarProduto(sc)) {
    				System.out.println("\nProduto cadastrado com sucesso!");
    			}
    			else {
    				System.out.println("Erro no cadastro de produto");
    			}
    			break;
    		case "7":
    			if(loja.editarProduto(sc)) {
    				System.out.println("\nProduto editado com sucesso!");
    			} else {
    				System.out.println("\nFalha ao editar produto");
    			}
    			break;
    		case "8":
    			if(loja.excluirProduto(sc)) {
    				System.out.println("\nProduto excluído com sucesso!");
    			} else {
    				System.out.println("\nFalha ao excluir produto");
    			}
    			break;
    		case "9":
    			Produto[] listaProdutos = loja.consultarProdutos(sc);
    			loja.mostrarProdutos(listaProdutos);
    			break;
    		case "10":
    			loja.mostrarProdutos(loja.produtos);
    			break;
    		case "11":
    			if(loja.vincularProdutoAFornecedor(sc)) {
    				System.out.println("\nProduto vinculado ao fornecedor com sucesso!");
    			} else {
    				System.out.println("\nErro ao vincular produto ao fornecedor");
    			}
    			break;
    		case "12":
    			if(loja.editarEstoqueProduto(sc)) {
    				System.out.println("Estoque editado com sucesso");
    			} else {
    				System.out.println("Erro ao editar o estoque do produto");
    			}
    			break;
    		case "99":
    			Produto p1 = new Produto("nome1", "descrição", new Estoque(0, 0));
    			Produto p2 = new Produto("nome2", "descrição2", new Estoque(0, 0));
    			loja.fornecedores[loja.posicaoVazia(loja.fornecedores)] = new Fornecedor("nome1", "descricao", "telefone", "email", new Endereco("rua", "numero", "complemento", "bairro", "cep", "cidade", "estado"), new Produto[] {p1, p2});
    			loja.fornecedores[loja.posicaoVazia(loja.fornecedores)] = new Fornecedor("nome2", "descricao2", "telefone2", "email2", new Endereco("rua2", "numero2", "complemento2", "bairro2", "cep2", "cidade2", "estado2"), new Produto[] {p1});
    			loja.produtos[loja.posicaoVazia(loja.produtos)] = p1;
    			loja.produtos[loja.posicaoVazia(loja.produtos)] = p2;
    			break;  
    		case "0":
    			continuar = false;
    			System.out.println("\nSaindo do acesso de adminstrador...");
    			break;
    		default:
    			System.out.println("\nOpção inválida.");
    		}
    	}
    }

    public void menuCliente(Usuario usuario, Scanner sc) {
    	System.out.println("\n" + loja.linha() + "\nMenu de Cliente\n" + loja.linha());
    	System.out.println(loja.linha());
    	System.out.println("Funções de cliente ainda não implementadas.");
    	System.out.println("0 - Voltar ao menu principal");
    	System.out.print("Opção: ");
    }
    
    public void realizarLogin(Scanner sc) {
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        Usuario usuario = loja.buscarUsuario(login, senha);

        if (usuario != null) {
            if (usuario.getTipo().equals(TipoUsuario.ADMIN)) {
                menuAdministrador(usuario, sc);
            } else if (usuario.getTipo().equals(TipoUsuario.CLIENTE)) {
                menuCliente(usuario, sc);
            }
        } else {
            System.out.println("\nErro: Login ou senha incorretos ou não encontrados");
        }
    }
}
