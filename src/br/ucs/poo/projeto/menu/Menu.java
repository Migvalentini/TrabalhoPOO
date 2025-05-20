package br.ucs.poo.projeto.menu;

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.Scanner;

public class Menu {
	private Loja loja;
	
	public Menu() {
		this.loja  = new Loja();
	}
	
	public static void main(String[] args) {
		Menu m = new Menu();
		
		Scanner sc = new Scanner(System.in);
		boolean continuar = true;

		System.out.println("SEJA MUITO BEM-VINDO(A) AO SISTEMA DE COMPRAS DESENVOLVIDO PELOS ALUNOS MIGUEL VALENTINI, HENRY PECATTI TIBOLA E VINICIUS BAREA PARA A DISCPLINA DE POO!");
		
		while (continuar) {
			System.out.println("\n" + m.loja.linha() + "\n         Menu Principal\n" + m.loja.linha());
			System.out.println(" 1 - Realizar Cadastro");
			System.out.println(" 2 - Realizar Login");
			System.out.println("99 - Facilitar testes");
			System.out.println(" 0 - Sair");
			System.out.print("Opção: ");
			
			String resposta = sc.nextLine();
			
			switch (resposta) {
			case "1":
				Cliente c = m.criarCliente(sc);
				if(c != null && m.loja.cadastrarCliente(c)) {
					System.out.println("\nCliente cadastrado com sucesso!");
				} else {
					System.out.println("\nFalha ao cadastrar cliente!");
				}
    			break;
			case "2":
				m.realizarLogin(sc);
				break;
			case "99":
				m.menuAdministrador(sc);
				break;
			case "0":
				continuar = false;
				System.out.println("\nEncerrando sistema...");
				break;
			default:
				System.out.println("\nOpção inválida!");
			}
		}
		
		sc.close();
	}
	
    public void menuAdministrador(Scanner sc) {
    	boolean continuar = true;
    	System.out.println("\nLogin como ADMINISTRADOR realizado com sucesso!");
    	
    	while (continuar) {
    		System.out.println("\n" + loja.linha() + "\n     Menu de Administrador\n" + loja.linha());
    		System.out.println("-- Fornecedores --");
    		System.out.println(" 1 - Cadastrar fornecedor");
    		System.out.println(" 2 - Editar fornecedor");
    		System.out.println(" 3 - Excluir fornecedor");
    		System.out.println(" 4 - Consultar fornecedores por código/nome");
    		System.out.println(" 5 - Mostrar todos fornecedores");
    		System.out.println("\n-- Produtos --");
    		System.out.println(" 6 - Cadastrar produto");
    		System.out.println(" 7 - Editar produto");
    		System.out.println(" 8 - Excluir produto");
    		System.out.println(" 9 - Consultar produtos por código/nome");
    		System.out.println("10 - Mostrar todos produtos");
    		System.out.println("11 - Editar estoque de produto");
    		System.out.println("\n-- Clientes --");
    		System.out.println("12 - Mostrar todos clientes");
    		System.out.println("\n-- Usuários Admin --");
    		System.out.println("13 - Mostrar todos usuários");
    		System.out.println("14 - Cadastrar usuário");
    		System.out.println("15 - Excluir usuário");
    		System.out.println("\n99 - Facilitar testes");
    		System.out.println(" 0 - Voltar ao menu principal");
    		System.out.print("Opção: ");
    		
    		String resposta = sc.nextLine();
    		
    		switch (resposta) {
    		case "1":
    			Fornecedor f = this.criarFornecedor(sc);
    			if(f != null && this.loja.cadastrarFornecedor(f)) {
    				System.out.println("\nFornecedor Cadastrado com Sucesso!");
    			} else {
    				System.out.println("\nErro ao Cadastrar Fornecedor!");
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
    			loja.mostrarObjetos(fo);
    			break;
    		case "5":
    	    	System.out.println("\n-- Lista de Fornecedores Cadastrados --");
    			loja.mostrarObjetos(loja.fornecedores);
    			break;
    		case "6":
    			Estoque e = this.criarEstoque(sc);
    			if(e == null) {
    				break;
    			}
    			Produto p = this.criarProduto(e, sc);
    			if(p != null && this.loja.cadastrarProduto(p, sc)) {
    				System.out.println("\nProduto Cadastrado com Sucesso!");
    			} else {
    				System.out.println("\nErro ao Cadastrar Produto!");
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
    				System.out.println("\nProduto com código informado não encontrado.");
    			}
    			break;
    		case "9":
    			Produto[] listaProdutos = loja.consultarProdutos(sc);
    			if(listaProdutos == null) {
    				System.out.println("\nFalha ao consultar produtos");
    			} else {
    				loja.mostrarObjetos(listaProdutos);
    			}
    			break;
    		case "10":
    	    	System.out.println("\n-- Lista de Produtos Cadastrados --");
    			loja.mostrarObjetos(loja.produtos);
    			break;
    		case "11":
    			if(loja.editarEstoqueProduto(sc)) {
    				System.out.println("\nEstoque editado com sucesso");
    			} else {
    				System.out.println("\nErro ao editar o estoque do produto");
    			}
    			break;
    		case "12":
    	    	System.out.println("\n-- Lista de Clientes Cadastrados --");
    			loja.mostrarObjetos(loja.clientes);
    			break;
    		case "13":
    	    	System.out.println("\n-- Lista de Usuários Admin Cadastrados: --");
    			loja.mostrarObjetos(loja.usuariosAdmin);
    			break;
    		case "14":
    			System.out.println("\n--- Cadastro de Novo Usuário Administrador ---");
    			if(loja.cadastrarUsuarioAdmin(sc)) {
    				System.out.println("\nUsuário admin Cadastrado com Sucesso!");
    			}
    			else {
    				System.out.println("\nErro no cadastro de usuário admin");
    			}
    			break;
    		case "15":
    			if(loja.excluirUsuarioAdmin(sc)) {
    				System.out.println("\nUsuário excluído com sucesso!");
    			} else {
    				System.out.println("\nFalha na exclusão do usuário");
    			}
    			
    			break;
    		case "99":
    			Produto p1 = new Produto("nome1", "descrição", new Estoque(0, 0));
    			Produto p2 = new Produto("nome2", "descrição2", new Estoque(0, 0));
    			loja.fornecedores[loja.posicaoVazia(loja.fornecedores)] = new Fornecedor("nome1", "descricao", "telefone", "email", new Endereco("rua", "numero", "complemento", "bairro", "cep", "cidade", "estado"), new Produto[] {p1, p2});
    			loja.fornecedores[loja.posicaoVazia(loja.fornecedores)] = new Fornecedor("nome2", "descricao2", "telefone2", "email2", new Endereco("rua2", "numero2", "complemento2", "bairro2", "cep2", "cidade2", "estado2"), new Produto[] {p1});
    			loja.produtos[loja.posicaoVazia(loja.produtos)] = p1;
    			loja.produtos[loja.posicaoVazia(loja.produtos)] = p2;
    			loja.clientes[loja.posicaoVazia(loja.clientes)] = new Cliente("nome1", "telefone1", "email1", "cartao1", new Endereco("rua", "numero", "complemento", "bairro", "cep", "cidade", "estado"), null, new Usuario("cliente1", "senha", TipoUsuario.CLIENTE));
    			loja.clientes[loja.posicaoVazia(loja.clientes)] = new Cliente("nome1", "telefone2", "email2", "cartao2", new Endereco("rua2", "numero2", "complemento2", "bairro2", "cep2", "cidade2", "estado2"), null, new Usuario("cliente2", "senha", TipoUsuario.CLIENTE));
    			break;  
    		case "0":
    			continuar = false;
    			System.out.println("\nSaindo do acesso de administrador...");
    			break;
    		default:
    			System.out.println("\nOpção inválida.");
    		}
    	}
    }

    public void menuCliente(Usuario usuario, Scanner sc) {
    	boolean continuar = true;
    	System.out.println("\nLogin como CLIENTE realizado com sucesso!");
    	
    	while (continuar) {
	    	System.out.println("\n" + loja.linha() + "\n     Menu de Cliente\n" + loja.linha());
	    	System.out.println("\n-- Produtos --");
			System.out.println(" 1 - Consultar todos produtos");
			System.out.println(" 2 - Consultar produtos por código/nome");
	    	System.out.println(" 0 - Voltar ao menu principal");
	    	System.out.print("Opção: ");
	    	
	    	String resposta = sc.nextLine();
			
			switch (resposta) {
			case "1":
				System.out.println("\n-- Lista de Produtos Cadastrados --");
				loja.mostrarObjetos(loja.produtos);
				break;
			case "2":
				Produto[] listaProdutos = loja.consultarProdutos(sc);
    			loja.mostrarObjetos(listaProdutos);
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
    
    public void realizarLogin(Scanner sc) {
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        Usuario usuario = loja.buscarUsuario(login, senha);

        if (usuario != null) {
            if (usuario.getTipo().equals(TipoUsuario.ADMIN)) {
                menuAdministrador(sc);
            } else if (usuario.getTipo().equals(TipoUsuario.CLIENTE)) {
                menuCliente(usuario, sc);
            }
        } else {
            System.out.println("\nErro: Login ou senha incorretos ou não encontrados");
        }
    }
    
    public Fornecedor criarFornecedor(Scanner sc) {
    	System.out.println("\n--- Cadastro de Fornecedor ---");
		try {
			System.out.println("Nome do fornecedor:");
			String nome = sc.nextLine();
			System.out.println("Descrição:");
			String descricao = sc.nextLine();
			System.out.println("Telefone:");
			String telefone = sc.nextLine();
			System.out.println("Email:");
			String email = sc.nextLine();
			Endereco endereco = criarEndereco(sc);
			
			return new Fornecedor(nome, descricao, telefone, email, endereco, null);
		} catch(Exception ex) {
			System.out.println("\nErro ao cadastrar fornecedor" + ex);
			return null;
		}
    }
    
    public Produto criarProduto(Estoque estoque, Scanner sc) {
    	System.out.println("\n--- Cadastro de Produto ---");
		try {			
			System.out.println("Nome do produto:");
			String nome = sc.nextLine();
			System.out.println("Descrição:");
			String descricao = sc.nextLine();
			
			Produto p = new Produto(nome, descricao, estoque);
			
			if(!loja.vincularProdutoAFornecedor(p, sc)) {
				return null;
			}
			
            return p;
		} catch(Exception ex) {
			return null;
		}
    }
    
    public Estoque criarEstoque(Scanner sc) {
    	System.out.println("\n--- Cadastro de Estoque ---");
		try {
			System.out.println("Quantidade:");
			int quantidade = sc.nextInt();
			System.out.println("Preço:");
			double preco = sc.nextDouble();
			sc.nextLine();

			return new Estoque(quantidade, preco);
		} catch (Exception ex) {
			System.out.println("Erro ao cadastrar estoque: " + ex);
			sc.nextLine();
			return null;
		}
    }
    
    public Cliente criarCliente(Scanner sc) {
    	System.out.println("\n--- Cadastro de Cliente ---");
		try {
 			System.out.println("Nome do cliente:");
			String nome = sc.nextLine();
			System.out.println("Telefone:");
			String telefone = sc.nextLine();
			System.out.println("Email:");
			String email = sc.nextLine();
			System.out.println("Cartão de Crédito:");
			String cartaoCredito = sc.nextLine();
			Endereco endereco = criarEndereco(sc);
			Usuario usuario = criarUsuario(sc, TipoUsuario.CLIENTE);
			
			if(loja.isClienteJaCadastrado(usuario)) {
				System.out.println("Usuário já utilizado!");
				return null;
			}
			
			return new Cliente(nome, telefone, email, cartaoCredito, endereco, null, usuario);
		} catch(Exception ex) {
			System.out.println("Erro ao cadastrar cliente: " + ex);
			return null;
		}
    }
    
    public Endereco criarEndereco(Scanner sc) {
    	System.out.println("\n--- Cadastro de Endereço ---");
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
    
    public Usuario criarUsuario(Scanner sc, TipoUsuario tipo) {
    	System.out.println("\n--- Cadastro de Usuário ---");
		try {			
			System.out.println("Usuário:");
			String usuario = sc.nextLine();
			System.out.println("Senha:");
			String senha = sc.nextLine();
			
			return new Usuario(usuario, senha, tipo);
		} catch(Exception ex) {
			System.out.println("Erro ao cadastrar endereço: " + ex);
			return null;
		}
    }
}
