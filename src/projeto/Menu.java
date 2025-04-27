package projeto;

import java.util.Scanner;

public class Menu {
	static int totalUsuarios = 100;
	static int totalFornecedores = 100;
	static Usuario[] usuarios = new Usuario[totalUsuarios];
	static Fornecedor[] fornecedores = new Fornecedor[totalFornecedores];
	static Produto[] produtos = new Produto[100];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean continuar = true;

		System.out.println("SEJA MUITO BEM-VINDO(A) AO MELHOR SISTEMA DE COMPRAS QUE VOCÊ JÁ USOU!");
		
		while (continuar) {
			System.out.println("\nSelecione o que deseja fazer:");
			System.out.println("1 - Cadastrar usuário");
			System.out.println("2 - Excluir usuário");
			System.out.println("3 - Realizar login");
			System.out.println("4 - Mostrar usuários cadastrados");
			System.out.println("5 - Facilitar testes");
			System.out.println("0 - Sair");
			
			String resposta = sc.nextLine();
			
			switch (resposta) {
			case "1":
				cadastrarUsuario(sc);
				break;
			case "2":
				System.out.print("Digite o usuário a ser excluído: ");
				String usuario = sc.nextLine();
				if(excluirUsuario(usuario)) {					
					System.out.println("Usuário " + usuario + " excluído com sucesso!");
				} else {
					System.out.println("Falha na exclusão do usuário " + usuario);
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
				System.out.println("Encerrando sistema...");
				break;
			default:
				System.out.println("Opção inválida.");
			}
		}
		
		sc.close();
	}
	
    private static void menuAdministrador(Usuario usuario, Scanner sc) {
    	boolean continuar = true;
    	System.out.println("Login como ADMINISTRADOR realizado com sucesso!");
    	
    	while (continuar) {
    		System.out.println("\nSelecione o que deseja fazer:");
    		System.out.println("1 - Cadastrar fornecedor");
    		System.out.println("2 - Editar fornecedor");
    		System.out.println("3 - Excluir fornecedor");
    		System.out.println("4 - Consultar fornecedor por código/nome");
    		System.out.println("5 - Consultar todos fornecedores");
    		//System.out.println("2 - Cadastrar Produto");
    		//System.out.println("3 - Manutenção do estoque de produtos");
    		System.out.println("9 - Facilitar testes");
    		System.out.println("0 - Sair");
    		
    		String resposta = sc.nextLine();
    		
    		switch (resposta) {
    		case "1":
    			cadastrarFornecedor(sc);
    			break;
    		case "2":
    			System.out.print("Digite o código do fornecedor a ser editado: ");
    			int codigo = sc.nextInt();
    			sc.nextLine();
    			if(editarFornecedor(codigo, sc)) {
    				System.out.println("Fornecedor editado com sucesso!");
    			} else {
    				System.out.println("Falha ao editar fornecedor");
    			}
    			
    			break;
    		case "3":
    			System.out.print("Digite o código do fornecedor a ser excluído: ");
    			int codigo2 = sc.nextInt();
    			sc.nextLine();
    			if(excluirFornecedor(codigo2)) {
    				System.out.println("Fornecedor excluído com sucesso!");
    			} else {
    				System.out.println("Falha ao excluir fornecedor");
    			}
    			break;
    		case "4":
    			
    			break;
    		case "5":
    			mostrarFornecedores();
    			break;
    		case "9":
    			fornecedores[posicaoVaziaFornecedores(fornecedores)] = new Fornecedor("nome", "descricao", "telefone", "email", new Endereco("rua", "numero", "complemento", "bairro", "cep", "cidade", "estado"), null);
    			break;
    		case "0":
    			continuar = false;
    			System.out.println("Saindo do acesso de adminstrador...");
    			break;
    		default:
    			System.out.println("Opção inválida.");
    		}
    	}
    }

    private static void menuCliente(Usuario usuario, Scanner sc) {
    	System.out.println("Login como CLIENTE realizado com sucesso!");
    }
    
	
    
    //FORNECEDOR
    
    private static void cadastrarFornecedor(Scanner sc) {
        System.out.println("\n--- Cadastro de Fornecedor ---");
        Fornecedor novoFornecedor = Fornecedor.criarFornecedor(sc);
        fornecedores[posicaoVaziaFornecedores(fornecedores)] = novoFornecedor;
        System.out.println("Fornecedor cadastrado com sucesso!");
    }
    
    private static boolean editarFornecedor(int codigo, Scanner sc) {
    	Fornecedor f = consultarFornecedor(codigo, null);
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
    	
    	System.out.print("Deseja alterar o endereço? (s/n): ");
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
    
    private static boolean excluirFornecedor(int codigo) {
    	for(int i=0; i<fornecedores.length; i++) {
    		if(fornecedores[i] != null && fornecedores[i].getCodigo()==codigo) {
    			fornecedores[i] = null;
    			return true;
    		}
    	}
    	return false;
    }
    
    private static Fornecedor consultarFornecedor(int codigo, String nome) {
    	System.out.println("Codigo: " + codigo + "Nome: " + nome);
    	for(int i=0; i<fornecedores.length; i++) {
    		if(fornecedores[i]!=null && fornecedores[i].getCodigo()==codigo && fornecedores[i].getNome().equals(nome)) {
    			return fornecedores[i];
    		}
    	}
    	return null;
    }
    
    private static void mostrarFornecedores() {
    	System.out.println("-- Lista de Fornecedores Cadastrados --");
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
    
    ////FORNECEDOR
    
    //USUÁRIOS
    
    private static void cadastrarUsuario(Scanner sc) {
        System.out.println("\n--- Cadastro de Novo Usuário ---");
        
        String tipo;
        do {
        	System.out.print("Tipo (0 - Admin, 1 - Cliente): ");
            tipo = sc.nextLine();
            if (!tipo.equals("0") && !tipo.equals("1")) {
                System.out.println("Opção Inválida! Insira novamente!");
            }
        } while (!tipo.equals("0") && !tipo.equals("1"));

        System.out.print("Escolha um login: ");
        String login = sc.nextLine();
        System.out.print("Escolha uma senha: ");
        String senha = sc.nextLine();
        
        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i] != null && usuarios[i].getUsuario().equals(login)) {
                System.out.println("Esse login já está em uso. Escolha outro.");
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
        
        System.out.println("Usuário cadastrado com sucesso!");
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
            System.out.println("Erro: Login ou senha incorretos ou não encontrados");
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
    	System.out.println("-- Lista de Usuários Cadastrados: --");
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
    
    private static boolean excluirUsuario(String usuario) {
    	for(int i=0; i<usuarios.length; i++) {
    		if(usuarios[i] != null && usuarios[i].getUsuario().equals(usuario)) {
    			usuarios[i] = null;
    			return true;
    		}
    	}
    	return false;
    }

    ////USUÁRIOS
    
}
