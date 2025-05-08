package projeto;

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.Scanner;

public class Menu {
	static int totalUsuarios = 100;
	static int totalFornecedores = 100;
	static int totalProdutos = 100;
	static int totalEstoques = 100;
	static Usuario[] usuarios = new Usuario[totalUsuarios];
	static Fornecedor[] fornecedores = new Fornecedor[totalFornecedores];
	static Produto[] produtos = new Produto[totalProdutos];
	static Estoque[] estoques = new Estoque[totalEstoques];
	static String[] arquivos = {"fornecedores", "produtos", "clientes", "usuarios", "pedidos"};

	public static void main(String[] args) {
		//abrirArquivos(arquivos);
		//leArquivo(usuarios, "usuarios", Usuario.class);
		
		Scanner sc = new Scanner(System.in);
		boolean continuar = true;

		System.out.println("SEJA MUITO BEM-VINDO(A) AO SISTEMA DE COMPRAS DESENVOLVIDO PELOS ALUNOS MIGUEL VALENTINI, HENRY PECATTI TIBOLA E VINICIUS BAREA PARA A DISCPLINA DE POO!");
		
		while (continuar) {
			System.out.println("\n" + linha() + "\n         Menu Principal\n" + linha());
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
				if(cadastrarUsuario(sc)) {
					System.out.println("\nUsuário cadastrado com sucesso!");
				} else {
					System.out.println("\nErro no cadastro do usuário!");
				}
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
				usuarios[posicaoVazia(usuarios)] = new Usuario("m", "1", TipoUsuario.ADMIN, null);
				menuAdministrador(null, sc);
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
	
    private static void menuAdministrador(Usuario usuario, Scanner sc) {
    	boolean continuar = true;
    	System.out.println("\nLogin como ADMINISTRADOR realizado com sucesso!");
    	
    	while (continuar) {
    		System.out.println("\n" + linha() + "\n     Menu de Administrador\n" + linha());
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
    		System.out.println("12 - Editar estoque de produto");
    		System.out.println("\n99 - Facilitar testes");
    		System.out.println(" 0 - Voltar ao menu principal");
    		System.out.print("Opção: ");
    		
    		String resposta = sc.nextLine();
    		
    		switch (resposta) {
    		case "1":
    			if(cadastrarFornecedor(sc)) {
    				System.out.println("\nFornecedor cadastrado com sucesso!");
    			} else {
    				System.out.println("\nErro no cadastro do fornecedor");
    			}
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
    			if(cadastrarProduto(sc)) {
    				System.out.println("\nProduto cadastrado com sucesso!");
    			}
    			else {
    				System.out.println("Erro no cadastro de produto");
    			}
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
    			if(vincularProdutoAFornecedor(sc)) {
    				System.out.println("\nProduto vinculado ao fornecedor com sucesso!");
    			} else {
    				System.out.println("\nErro ao vincular produto ao fornecedor");
    			}
    			break;
    		case "12":
    			if(editarEstoqueProduto(sc)) {
    				System.out.println("Estoque editado com sucesso");
    			} else {
    				System.out.println("Erro ao editar o estoque do produto");
    			}
    			break;
    		case "99":
    			Produto p1 = new Produto("nome", "descrição", new Estoque(0, 0));
    			Produto p2 = new Produto("nome2", "descrição2", new Estoque(0, 0));
    			fornecedores[posicaoVazia(fornecedores)] = new Fornecedor("nome", "descricao", "telefone", "email", new Endereco("rua", "numero", "complemento", "bairro", "cep", "cidade", "estado"), new Produto[] {p1, p2});
    			fornecedores[posicaoVazia(fornecedores)] = new Fornecedor("nome2", "descricao2", "telefone2", "email2", new Endereco("rua2", "numero2", "complemento2", "bairro2", "cep2", "cidade2", "estado2"), new Produto[] {p1});
    			produtos[posicaoVazia(produtos)] = p1;
    			produtos[posicaoVazia(produtos)] = p2;
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
    
    private static boolean cadastrarFornecedor(Scanner sc) {
    	try {    		
    		System.out.println("\n--- Cadastro de Fornecedor ---");
    		Fornecedor novoFornecedor = Fornecedor.criarFornecedor(sc);
    		fornecedores[posicaoVazia(fornecedores)] = novoFornecedor;
    		return true;
    	} catch (Exception e) {
    		return false;
    	}
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
    	try {    		
    		System.out.print("Digite o código do fornecedor a ser excluído: ");
    		int codigo = sc.nextInt();
    		sc.nextLine();
    		
    		for(int i=0; i<fornecedores.length; i++) {
    			if(fornecedores[i] != null && fornecedores[i].getCodigo()==codigo) {
    				fornecedores[i] = null;
    				return true;
    			}
    		}
    	} catch (Exception e) {
    		return false;
    	}
    	return false;
    }
    
    private static Fornecedor consultarFornecedor(Scanner sc) {
    	try {    		
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
    	} catch (Exception e) {
    		return null;
    	}
    	
    	return null;
    }
    
    private static void mostrarFornecedores() {
    	System.out.println("\n-- Lista de Fornecedores Cadastrados --");
    	for (int i = 0; i < totalFornecedores; i++) {
    		if(fornecedores[i] != null) {    			
    			System.out.println(fornecedores[i].toString());
    			System.out.println(linha());
    		}
    	}
    }

    
    ////FORNECEDORES
    
    //PRODUTOS
    
    private static boolean cadastrarProduto(Scanner sc) {
    	try {    		
    		System.out.println("\n--- Cadastro de Produto ---");
    		Estoque novoEstoque = Estoque.criarEstoque(sc);
    		Produto novoProduto = Produto.criarProduto(novoEstoque, sc);
    		produtos[posicaoVazia(produtos)] = novoProduto;
    		
    		return true;
    	} catch (Exception e) {
    		return false;
    	}
    }
    
    private static boolean editarProduto(Scanner sc) {
    	try {    		
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
    		
    		System.out.print("\nDeseja alterar o estoque? (s/n): ");
    		String alterarEstoque = sc.nextLine();
    		if (alterarEstoque.equalsIgnoreCase("s")) {
    			System.out.print("Digite a nova quantidade: ");
    			int quantidade = sc.nextInt();
    			p.getEstoque().setQuantidade(quantidade);
    			System.out.print("Digite o novo preço: ");
    			double preco = sc.nextDouble();
    			p.getEstoque().setPreco(preco);
    			sc.nextLine();
    		}
    	} catch (Exception e) {
    		return false;
    	}
    	
    	return true;
    }

    private static boolean editarEstoqueProduto(Scanner sc) {
    	try {    		
    		Produto p = consultarProduto(sc);
    		if(p==null) {   
    			return false;
    		}
    		
    		System.out.print("Digite a quantidade: ");
    		int quantidade = sc.nextInt();
    		p.getEstoque().setQuantidade(quantidade);
    		System.out.print("Digite o preço: ");
    		double preco = sc.nextDouble();
    		p.getEstoque().setPreco(preco);
    		sc.nextLine();
    	} catch (Exception e) {
    		return false;
    	}
    	
    	return true;
    }
    
    private static boolean excluirProduto(Scanner sc) {
    	try {
    		System.out.print("Digite o código do produto a ser excluído: ");
    		int codigo = sc.nextInt();
    		sc.nextLine();
    		
    		for(int i=0; i<produtos.length; i++) {
    			if(produtos[i] != null && produtos[i].getCodigo()==codigo) {
    				produtos[i] = null;
    				return true;
    			}
    		}
    	} catch(Exception e) {
    		return false;
    	}
    	return false;
    }
    
    private static Produto consultarProduto(Scanner sc) {
    	try {    		
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
    	} catch(Exception e) {
    		return null;
    	}
    	return null;
    }
    
    private static void mostrarProdutos() {
    	System.out.println("\n-- Lista de Produtos Cadastrados --");
    	for (int i = 0; i < totalProdutos; i++) {
    		if(produtos[i] != null) {    			
    			System.out.println(produtos[i].toString());
    			System.out.println(linha());
    		}
    	}
    }
    
    private static boolean vincularProdutoAFornecedor(Scanner sc) {
    	try {    		
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
    	} catch(Exception e) {
    		return false;
    	}
        return true;
    }

    
    ////PRODUTOS
    
    //USUÁRIOS
    
    private static boolean cadastrarUsuario(Scanner sc) {
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
                return false;
            }
        }
        
        if(tipo.equals("0")) {
        	usuarios[posicaoVazia(usuarios)] = new Usuario(login, senha, TipoUsuario.ADMIN, null);
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
        	
        	Endereco endereco = Endereco.criarEndereco(sc);
        	Cliente cliente = new Cliente(nome, telefone, email, cartaoCredito, endereco, null);
        	
        	usuarios[posicaoVazia(usuarios)] = new Usuario(login, senha, TipoUsuario.CLIENTE, cliente);
        }
        
        return true;
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
            if (usuarios[i] != null && usuarios[i].getUsuario().equals(login) && usuarios[i].getSenha().equals(senha)) {
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
        		System.out.println(linha());
        	}
        }
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
    	return "--------------------------------";
    }
        
    //ARQUIVOS
    
    /*private static void abrirArquivos(String[] arquivos) {
    	try {
    		for(String arquivo : arquivos) {    			
    			File myObj = new File(arquivo + ".txt");
    			if (myObj.createNewFile()) {
    				System.out.println("Criado arquivo: " + myObj.getName());
    			} else {
    				System.out.println("Arquivo já criado.\n");
    			}
    		}
	    } catch (IOException e) {
	    	System.out.println("Aconteceu algum erro na criação do arquivo.");
	    	e.printStackTrace();
	    }
    }
    
    private static void escreveNoArquivo(Object[] array, String nomeArquivo) {
        try {
            FileWriter myWriter = new FileWriter(nomeArquivo + ".txt");
            
            for (Object obj : array) {
                if (obj != null) {
                    String texto = (String) obj.getClass().getMethod("toStringTxt").invoke(obj);
                    myWriter.write(texto + "\n");
                }
            }
            
            myWriter.close();
            System.out.println("Arquivo escrito com sucesso.");
        } catch (IOException | ReflectiveOperationException e) {
            System.out.println("Erro na escrita do arquivo: " + e);
        }
    }
    
    private static void leArquivo(Object[] array, String nomeArquivo, Class<?> classe) {
        try {
            File myObj = new File(nomeArquivo + ".txt"); 
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println("Lendo linha: " + data);
                
                Object obj = classe.getMethod("fromString", String.class).invoke(null, data);
                
                array[posicaoVazia(array)] = obj;
            }
            
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao ler arquivo.");
            e.printStackTrace();
        } catch (ReflectiveOperationException e) {
            System.out.println("Erro ao invocar o método fromString.");
            e.printStackTrace();
        }
    }*/

    
    ////ARQUIVOS


    private static int posicaoVazia(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        return -1; 
    }

}
