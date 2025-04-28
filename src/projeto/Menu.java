package projeto;

import java.util.Scanner;

public class Menu {
	static int totalUsuarios = 100;
	static int totalFornecedores = 100;
	static int totalProdutos = 100;
	static Usuario[] usuarios = new Usuario[totalUsuarios];
	static Fornecedor[] fornecedores = new Fornecedor[totalFornecedores];
	static Produto[] produtos = new Produto[100];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean continuar = true;

		System.out.println("SEJA MUITO BEM-VINDO(A) AO MELHOR SISTEMA DE COMPRAS QUE VOCÊ JÁ USOU!");
		
		while (continuar) {
			System.out.println("\n" + linha() + "\nMenu Principal\n" + linha());
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
				cadastrarUsuario(sc);
				break;
			case "2":
				if(excluirUsuario(sc)) {					
					System.out.println("\nUsuário excluído com sucesso!");
				} else {
					System.out.println("\nFalha na exclusão do usuário!");
				}
				break;
			case "3":
				realizarLogin(sc);
				break;
			case "4":
				mostrarUsuarios();
				break;
			case "5":
				usuarios[posicaoVaziaUsuarios(usuarios)] = new Usuario("m", "1", TipoUsuario.ADMIN, null);
				menuAdministrador(null, sc);
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
	
    private static void menuAdministrador(Usuario usuario, Scanner sc) {
    	boolean continuar = true;
    	System.out.println("\nLogin como ADMINISTRADOR realizado com sucesso!");
    	
    	while (continuar) {
    		System.out.println("\n" + linha() + "\nMenu de Administrador\n" + linha());
    		System.out.println("-- Fornecedores --");
    		System.out.println(" 1 - Cadastrar fornecedor");
    		System.out.println(" 2 - Editar fornecedor");
    		System.out.println(" 3 - Excluir fornecedor");
    		System.out.println(" 4 - Consultar fornecedor por código/nome");
    		System.out.println(" 5 - Consultar todos fornecedores");
    		System.out.println("\n-- Produtos --");
    		System.out.println(" 6 - Cadastrar produto");
    		System.out.println(" 7 - Editar produto");
    		System.out.println(" 8 - Excluir produto");
    		System.out.println(" 9 - Consultar produto por código/nome");
    		System.out.println("10 - Consultar todos produtos");
    		System.out.println("11 - Vincular produto a um fornecedor");
    		System.out.println("\n99 - Facilitar testes");
    		System.out.println(" 0 - Voltar ao menu principal");
    		System.out.print("Opção: ");
    		
    		String resposta = sc.nextLine();
    		
    		switch (resposta) {
    		case "1":
    			cadastrarFornecedor(sc);
    			break;
    		case "2":
    			if(editarFornecedor(sc)) {
    				System.out.println("\nFornecedor editado com sucesso!");
    			} else {
    				System.out.println("\nFalha ao editar fornecedor");
    			}
    			break;
    		case "3":
    			if(excluirFornecedor(sc)) {
    				System.out.println("\nFornecedor excluído com sucesso!");
    			} else {
    				System.out.println("\nFalha ao excluir fornecedor");
    			}
    			break;
    		case "4":
    			Fornecedor f = consultarFornecedor(sc);
    			if(f!=null) {    				
    				System.out.println("\n" + f.toString());
    			} else {
    				System.out.println("\nFalha ao buscar fornecedor");
    			}
    			break;
    		case "5":
    			mostrarFornecedores();
    			break;
    		case "6":
    			cadastrarProduto(sc);
    			break;
    		case "7":
    			if(editarProduto(sc)) {
    				System.out.println("\nProduto editado com sucesso!");
    			} else {
    				System.out.println("\nFalha ao editar produto");
    			}
    			break;
    		case "8":
    			if(excluirProduto(sc)) {
    				System.out.println("\nProduto excluído com sucesso!");
    			} else {
    				System.out.println("\nFalha ao excluir produto");
    			}
    			break;
    		case "9":
    			Produto p = consultarProduto(sc);
    			if(p!=null) {    				
    				System.out.println("\n" + p.toString());
    			} else {
    				System.out.println("\nFalha ao buscar produto");
    			}
    			break;
    		case "10":
    			mostrarProdutos();
    			break;
    		case "11":
    			vincularProdutoAFornecedor(sc);
    			break;
    		case "99":
    			fornecedores[posicaoVaziaFornecedores(fornecedores)] = new Fornecedor("nome", "descricao", "telefone", "email", new Endereco("rua", "numero", "complemento", "bairro", "cep", "cidade", "estado"), null);
    			fornecedores[posicaoVaziaFornecedores(fornecedores)] = new Fornecedor("nome2", "descricao2", "telefone2", "email2", new Endereco("rua2", "numero2", "complemento2", "bairro2", "cep2", "cidade2", "estado2"), null);
    			produtos[posicaoVaziaProdutos(produtos)] = new Produto("nome", "descrição", null);
    			produtos[posicaoVaziaProdutos(produtos)] = new Produto("nome2", "descrição2", null);
    			
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

    private static void menuCliente(Usuario usuario, Scanner sc) {
    	System.out.println("\n" + linha() + "\nMenu de Cliente\n" + linha());
    	System.out.println(linha());
    	System.out.println("Funções de cliente ainda não implementadas.");
    	System.out.println("0 - Voltar ao menu principal");
    	System.out.print("Opção: ");
    }
    
    //FORNECEDORES
    
    private static void cadastrarFornecedor(Scanner sc) {
        System.out.println("\n--- Cadastro de Fornecedor ---");
        Fornecedor novoFornecedor = Fornecedor.criarFornecedor(sc);
        fornecedores[posicaoVaziaFornecedores(fornecedores)] = novoFornecedor;
        System.out.println("\nFornecedor cadastrado com sucesso!");
    }
    
    private static boolean editarFornecedor(Scanner sc) {
       	Fornecedor f = consultarFornecedor(sc);
    	if(f==null) {   
    		return false;
    	}
    	System.out.println(f.toString());
    	System.out.println("Digite o novo nome do fornecedor: ");
    	String nome = sc.nextLine();
    	f.setNome(nome);
    	System.out.println("Digite a nova descrição do fornecedor: ");
    	String descricao = sc.nextLine();
    	f.setDescricao(descricao);
    	System.out.println("Digite o novo telefone do fornecedor: ");
    	String telefone = sc.nextLine();
    	f.setTelefone(telefone);
    	System.out.println("Digite o novo email do fornecedor: ");
    	String email = sc.nextLine();
    	f.setEmail(email);
    	
    	System.out.print("\nDeseja alterar o endereço? (s/n): ");
        String alterarEndereco = sc.nextLine();
        if (alterarEndereco.equalsIgnoreCase("s")) {
            System.out.print("Digite a nova rua: ");
            String rua = sc.nextLine();
            f.getEndereco().setRua(rua);
            System.out.print("Digite o novo número: ");
            String numero = sc.nextLine();
            f.getEndereco().setNumero(numero);
            System.out.print("Digite o novo complemento: ");
            String complemento = sc.nextLine();
            f.getEndereco().setComplemento(complemento);
            System.out.print("Digite o novo bairro: ");
            String bairro = sc.nextLine();
            f.getEndereco().setBairro(bairro);
            System.out.print("Digite o novo cep: ");
            String cep = sc.nextLine();
            f.getEndereco().setCep(cep);
            System.out.print("Digite a nova cidade: ");
            String cidade = sc.nextLine();
            f.getEndereco().setCidade(cidade);
            System.out.print("Digite o novo estado: ");
            String estado = sc.nextLine();
            f.getEndereco().setEstado(estado);
        }
    	
    	return true;
    }
    
    private static boolean excluirFornecedor(Scanner sc) {
    	System.out.print("Digite o código do fornecedor a ser excluído: ");
		int codigo = sc.nextInt();
		sc.nextLine();
		
    	for(int i=0; i<fornecedores.length; i++) {
    		if(fornecedores[i] != null && fornecedores[i].getCodigo()==codigo) {
    			fornecedores[i] = null;
    			return true;
    		}
    	}
    	return false;
    }
    
    private static Fornecedor consultarFornecedor(Scanner sc) {
    	System.out.println("Digite o código do fornecedor a ser pesquisado: ");
		int codigo = sc.nextInt();
		sc.nextLine();
		System.out.println("Digite o nome do fornecedor a ser pesquisado: ");
		String nome = sc.nextLine();
		
    	for(int i=0; i<fornecedores.length; i++) {
    		if(fornecedores[i]!=null && (fornecedores[i].getCodigo()==codigo || fornecedores[i].getNome().equals(nome))) {
    			return fornecedores[i];
    		}
    	}
    	return null;
    }
    
    private static void mostrarFornecedores() {
    	System.out.println("\n-- Lista de Fornecedores Cadastrados --");
    	for (int i = 0; i < totalFornecedores; i++) {
    		if(fornecedores[i] != null) {    			
    			System.out.println(fornecedores[i].toString());
    		}
    	}
    }
    
    private static int posicaoVaziaFornecedores(Fornecedor fornecedores[]) {
    	for(int i=0; i<fornecedores.length; i++) {
    		if(fornecedores[i] == null) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    ////FORNECEDORES
    
    //PRODUTOS
    
    private static void cadastrarProduto(Scanner sc) {
        System.out.println("\n--- Cadastro de Produto ---");
        Produto novoProduto = Produto.criarProduto(sc);
        produtos[posicaoVaziaProdutos(produtos)] = novoProduto;
        System.out.println("Produto cadastrado com sucesso!");
    }
    
    private static boolean editarProduto(Scanner sc) {
    	Produto p = consultarProduto(sc);
    	if(p==null) {   
    		return false;
    	}
    	System.out.println(p.toString());
    	System.out.println("Digite o novo nome do produto: ");
    	String nome = sc.nextLine();
    	p.setNome(nome);
    	System.out.println("Digite a nova descrição do produto: ");
    	String descricao = sc.nextLine();
    	p.setDescricao(descricao);
    	
    	return true;
    }
    
    private static boolean excluirProduto(Scanner sc) {
    	System.out.print("Digite o código do produto a ser excluído: ");
		int codigo = sc.nextInt();
		sc.nextLine();
    	
    	for(int i=0; i<produtos.length; i++) {
    		if(produtos[i] != null && produtos[i].getCodigo()==codigo) {
    			produtos[i] = null;
    			return true;
    		}
    	}
    	return false;
    }
    
    private static Produto consultarProduto(Scanner sc) {
    	System.out.println("Digite o código do produto a ser pesquisado: ");
		int codigo = sc.nextInt();
		sc.nextLine();
		System.out.println("Digite o nome do produto a ser pesquisado: ");
		String nome = sc.nextLine();
    	
    	for(int i=0; i<produtos.length; i++) {
    		if(produtos[i]!=null && (produtos[i].getCodigo()==codigo || produtos[i].getNome().equals(nome))) {
    			return produtos[i];
    		}
    	}
    	return null;
    }
    
    private static void mostrarProdutos() {
    	System.out.println("\n-- Lista de Produtos Cadastrados --");
    	for (int i = 0; i < totalProdutos; i++) {
    		if(produtos[i] != null) {    			
    			System.out.println(produtos[i].toString());
    		}
    	}
    }
    
    private static boolean vincularProdutoAFornecedor(Scanner sc) {
        System.out.println("\n--- Vincular Produto a Fornecedor ---");
        
        mostrarProdutos();
        Produto p = consultarProduto(sc);
        if (p == null) {
            System.out.println("\nProduto não encontrado.");
            return false;
        }
        
        mostrarFornecedores();
        System.out.print("Digite o código do fornecedor: ");
        int codigoFornecedor = sc.nextInt();
        sc.nextLine();
        
        Fornecedor fornecedorSelecionado = null;
        for (Fornecedor f : fornecedores) {
            if (f != null && f.getCodigo() == codigoFornecedor) {
                fornecedorSelecionado = f;
                break;
            }
        }
        
        if (fornecedorSelecionado == null) {
            System.out.println("\nFornecedor não encontrado.");
            return false;
        }
        
        fornecedorSelecionado.adicionarProduto(p);
        
        System.out.println("\nProduto vinculado ao fornecedor com sucesso!");
        return true;
    }

    private static int posicaoVaziaProdutos(Produto produtos[]) {
    	for(int i=0; i<produtos.length; i++) {
    		if(produtos[i] == null) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    
    ////PRODUTOS
    
    //USUÁRIOS
    
    private static void cadastrarUsuario(Scanner sc) {
        System.out.println("\n--- Cadastro de Novo Usuário ---");
        
        String tipo;
        do {
        	System.out.print("Tipo (0 - Admin, 1 - Cliente): ");
            tipo = sc.nextLine();
            if (!tipo.equals("0") && !tipo.equals("1")) {
                System.out.println("\nOpção Inválida! Insira novamente!");
            }
        } while (!tipo.equals("0") && !tipo.equals("1"));

        System.out.print("Escolha um login: ");
        String login = sc.nextLine();
        System.out.print("Escolha uma senha: ");
        String senha = sc.nextLine();
        
        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i] != null && usuarios[i].getUsuario().equals(login)) {
                System.out.println("\nEsse login já está em uso. Escolha outro.");
                return;
            }
        }
        
        if(tipo.equals("0")) {
        	usuarios[posicaoVaziaUsuarios(usuarios)] = new Usuario(login, senha, TipoUsuario.ADMIN, null);
        } else {  
        	System.out.println("\n--- Cadastro de Novo Cliente ---");
        	System.out.print("Nome: ");
        	String nome = sc.nextLine();
        	System.out.print("Telefone: ");
        	String telefone = sc.nextLine();
        	System.out.print("Email: ");
        	String email = sc.nextLine();
        	System.out.print("Cartão de Crédito: ");
        	String cartaoCredito = sc.nextLine();
        	
        	System.out.println("\n-- Cadastro de Endereço --");
        	System.out.print("Rua: ");
        	String rua = sc.nextLine();
        	System.out.print("Número: ");
        	String numero = sc.nextLine();
        	System.out.print("Complemento: ");
        	String complemento = sc.nextLine();
        	System.out.print("Bairro: ");
        	String bairro = sc.nextLine();
        	System.out.print("CEP: ");
        	String cep = sc.nextLine();
        	System.out.print("Cidade: ");
        	String cidade = sc.nextLine();
        	System.out.print("Estado: ");
        	String estado = sc.nextLine();
        	
        	Endereco endereco = new Endereco(rua, numero, complemento, bairro, cep, cidade, estado);
        	Cliente cliente = new Cliente(nome, telefone, email, cartaoCredito, endereco, null);
        	
        	usuarios[posicaoVaziaUsuarios(usuarios)] = new Usuario(login, senha, TipoUsuario.CLIENTE, cliente);
        }
        
        System.out.println("\nUsuário cadastrado com sucesso!");
    }
    
    private static void realizarLogin(Scanner sc) {
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        Usuario usuario = buscarUsuario(login, senha);
        
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
    
    private static Usuario buscarUsuario(String login, String senha) {
        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i].getUsuario().equals(login) && usuarios[i].getSenha().equals(senha)) {
                return usuarios[i];
            }
        }
        return null;
    }

    private static void mostrarUsuarios() {
    	System.out.println("\n-- Lista de Usuários Cadastrados: --");
        for (int i = 0; i < totalUsuarios; i++) {
        	if(usuarios[i] != null) {
        		System.out.println(usuarios[i].toString());
        		System.out.println("----------");
        	}
        }
    }
    
    private static int posicaoVaziaUsuarios(Usuario usuarios[]) {
    	for(int i=0; i<usuarios.length; i++) {
    		if(usuarios[i] == null) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    private static boolean excluirUsuario(Scanner sc) {
    	System.out.print("Digite o usuário a ser excluído: ");
		String usuario = sc.nextLine();
    	
    	for(int i=0; i<usuarios.length; i++) {
    		if(usuarios[i] != null && usuarios[i].getUsuario().equals(usuario)) {
    			usuarios[i] = null;
    			return true;
    		}
    	}
    	return false;
    }

    ////USUÁRIOS
    
    private static String linha() {
    	return "-------------------------------";
    }
}
