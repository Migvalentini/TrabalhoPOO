package br.ucs.poo.projeto;

import java.util.ArrayList;
import java.util.Arrays;
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

		System.out.println("SEJA MUITO BEM-VINDO(A) AO SISTEMA DE COMPRAS DESENVOLVIDO PELOS ALUNOS MIGUEL VALENTINI, HENRY PECATTI TIBOLA E VINICIUS BAREA PARA A DISCIPLINA DE POO!");
		
		while (continuar) {
			System.out.println("\n" + m.linha() + "\n         Menu Principal\n" + m.linha());
			System.out.println(" 1 - Realizar Cadastro");
			System.out.println(" 2 - Realizar Login");
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
			case "88":
				Usuario u = new Usuario("cliente1", "senha", TipoUsuario.CLIENTE);
				u.setCliente(new Cliente("Test Client", "111111111", "test@example.com", "1234-5678-9012-3456", new Endereco("Test St", "123", "", "Test B", "00000-000", "Test City", "TS"), null, new Usuario("cliente1", "senha", TipoUsuario.CLIENTE)));
				m.menuCliente(u, sc);
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
    		System.out.println("\n" + linha() + "\n     Menu de Administrador\n" + linha());
    		System.out.println("1 - Menu Fornecedores");
    		System.out.println("2 - Menu Produtos");
    		System.out.println("3 - Menu Clientes");
    		System.out.println("4 - Menu Usuários Admin");
    		System.out.println("0 - Voltar ao menu principal");
    		System.out.print("Opção: ");
    		
    		String resposta = sc.nextLine();
    		
    		switch (resposta) {
    		case "1":
    			menuAdministradorFornecedores(sc);
    			break;
    		case "2":
    			menuAdministradorProdutos(sc);
    			break;
    		case "3":
    			menuAdministradorClientes(sc);
    			break;
    		case "4":
    			menuAdministradorUsuarios(sc);
    			break;
    		case "99":
    			Produto p1 = new Produto("nome1", "descrição", new Estoque(10, 20));
    			Produto p2 = new Produto("nome2", "descrição2", new Estoque(30, 40));
    			loja.fornecedores.add(new Fornecedor("nome1", "descricao", "telefone", "email", new Endereco("rua", "numero", "complemento", "bairro", "cep", "cidade", "estado"), new ArrayList<>(Arrays.asList(p1, p2))));
    			loja.fornecedores.add(new Fornecedor("nome2", "descricao2", "telefone2", "email2", new Endereco("rua2", "numero2", "complemento2", "bairro2", "cep2", "cidade2", "estado2"), new ArrayList<>(Arrays.asList(p1, p2))));
    			loja.produtos.add(p1);
    			loja.produtos.add(p2);
    			loja.clientes.add(new Cliente("nome1", "telefone1", "email1", "cartao1", new Endereco("rua", "numero", "complemento", "bairro", "cep", "cidade", "estado"), null, new Usuario("cliente1", "senha", TipoUsuario.CLIENTE)));
    			loja.clientes.add(new Cliente("nome1", "telefone2", "email2", "cartao2", new Endereco("rua2", "numero2", "complemento2", "bairro2", "cep2", "cidade2", "estado2"), null, new Usuario("cliente2", "senha", TipoUsuario.CLIENTE)));
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
    
    public void menuAdministradorFornecedores(Scanner sc) {
		System.out.println("\n" + linha() + "\n     Menu de Fornecedores\n" + linha());
		System.out.println("1 - Cadastrar fornecedor");
		System.out.println("2 - Editar fornecedor");
		System.out.println("3 - Excluir fornecedor");
		System.out.println("4 - Consultar fornecedores por código/nome");
		System.out.println("5 - Mostrar todos fornecedores");
		System.out.println("0 - Voltar ao menu principal");
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
			System.out.print("Digite o código do fornecedor a ser editado: ");
            int codigo = sc.nextInt();
            sc.nextLine();
            
            Fornecedor fornecedor = new Fornecedor();
            
            System.out.println("Digite o novo nome do fornecedor (ou deixe em branco para manter): ");
            String nome = sc.nextLine();
            if (!nome.isBlank()) fornecedor.setNome(nome);
            System.out.println("Digite a nova descrição do fornecedor (ou deixe em branco para manter): ");
            String descricao = sc.nextLine();
            if (!descricao.isBlank()) fornecedor.setDescricao(descricao);
            System.out.println("Digite o novo telefone do fornecedor (ou deixe em branco para manter): ");
            String telefone = sc.nextLine();
            if (!telefone.isBlank()) fornecedor.setTelefone(telefone);
            System.out.println("Digite o novo email do fornecedor (ou deixe em branco para manter): ");
            String email = sc.nextLine();
            if (!email.isBlank()) fornecedor.setEmail(email);
            System.out.print("\nDeseja alterar o endereço? (s/n): ");
            String alterarEndereco = sc.nextLine();
            if (alterarEndereco.equalsIgnoreCase("s")) {
            	fornecedor.setEndereco(new Endereco());
                System.out.print("Digite a nova rua (ou deixe em branco para manter): ");
                String rua = sc.nextLine();
                if (!rua.isBlank()) fornecedor.getEndereco().setRua(rua);
                System.out.print("Digite o novo número (ou deixe em branco para manter): ");
                String numero = sc.nextLine();
                if (!numero.isBlank()) fornecedor.getEndereco().setNumero(numero);
                System.out.print("Digite o novo complemento (ou deixe em branco para manter): ");
                String complemento = sc.nextLine();
                if (!complemento.isBlank()) fornecedor.getEndereco().setComplemento(complemento);
                System.out.print("Digite o novo bairro (ou deixe em branco para manter): ");
                String bairro = sc.nextLine();
                if (!bairro.isBlank()) fornecedor.getEndereco().setBairro(bairro);
                System.out.print("Digite o novo CEP (ou deixe em branco para manter): ");
                String cep = sc.nextLine();
                if (!cep.isBlank()) fornecedor.getEndereco().setCep(cep);
                System.out.print("Digite a nova cidade (ou deixe em branco para manter): ");
                String cidade = sc.nextLine();
                if (!cidade.isBlank()) fornecedor.getEndereco().setCidade(cidade);
                System.out.print("Digite o novo estado (ou deixe em branco para manter): ");
                String estado = sc.nextLine();
                if (!estado.isBlank()) fornecedor.getEndereco().setEstado(estado);
            }
            
			if(loja.editarFornecedor(codigo, fornecedor)) {
				System.out.println("\nFornecedor editado com sucesso!");
			} else {
				System.out.println("\nFalha ao editar fornecedor");
			}
			break;
		case "3":
			mostrarObjetos(loja.fornecedores);
            System.out.print("Digite o código do fornecedor a ser excluído: ");
            int codigo2 = sc.nextInt();
            sc.nextLine();
			if(loja.excluirFornecedor(codigo2)) {
				System.out.println("\nFornecedor excluído com sucesso!");
			} else {
				System.out.println("\nFalha ao excluir fornecedor");
			}
			break;
		case "4":
			System.out.println("Digite o código/nome do fornecedor a ser pesquisado: ");
			String termoBusca = sc.nextLine().trim().toLowerCase();
			ArrayList<Fornecedor> fo = loja.consultarFornecedores(termoBusca);
			mostrarObjetos(fo);
			break;
		case "5":
			mostrarObjetos(loja.fornecedores);
			break;
		case "0":
			break;
		default:
			System.out.println("\nOpção inválida.");
		}
    }
    
    public void menuAdministradorProdutos(Scanner sc) {
		System.out.println("\n" + linha() + "\n     Menu de Produtos\n" + linha());
		System.out.println("1 - Cadastrar produto");
		System.out.println("2 - Editar produto");
		System.out.println("3 - Excluir produto");
		System.out.println("4 - Consultar produtos por código/nome");
		System.out.println("5 - Mostrar todos produtos");
		System.out.println("6 - Editar estoque de produto");
		System.out.println("7 - Alterar fornecedor do produto");
		System.out.println("0 - Voltar ao menu principal");
		System.out.print("Opção: ");
		
		String resposta = sc.nextLine();
		
		switch (resposta) {
		case "1":
			Produto p = this.criarProduto(null, sc);
			if (p == null) {
				System.out.println("\nErro ao Cadastrar Produto!");
				break;
			}
			Estoque e = this.criarEstoque(sc);
			p.setEstoque(e);
			if(e == null) {
				break;
			}
			if(p != null && this.loja.cadastrarProduto(p)) {
				System.out.println("\nProduto Cadastrado com Sucesso!");
			} else {
				System.out.println("\nErro ao Cadastrar Produto!");
			}
			break;
		case "2":
			mostrarObjetos(loja.produtos);
    		
    		System.out.println("Digite o código/nome do produto a ser pesquisado: ");
			String termoBusca = sc.nextLine().trim().toLowerCase();
			
			Produto produto = new Produto();
			
			System.out.println("Digite o novo nome do produto (ou deixe em branco para manter): ");
            String nome = sc.nextLine();
            if (!nome.isEmpty()) produto.setNome(nome);
            System.out.println("Digite a nova descrição do produto (ou deixe em branco para manter): ");
            String descricao = sc.nextLine();
            if (!descricao.isEmpty()) produto.setDescricao(descricao);

            System.out.print("\nDeseja alterar o estoque? (s/n): ");
            produto.setEstoque(new Estoque());
            String alterarEstoque = sc.nextLine();
            if (alterarEstoque.equalsIgnoreCase("s")) {
                try {
                    System.out.print("Digite a nova quantidade (ou deixe -1 para manter): ");
                    int quantidade = sc.nextInt();
                    if (quantidade != -1) produto.getEstoque().setQuantidade(quantidade);
                    sc.nextLine();
                    System.out.print("Digite o novo preço (ou deixe -1 para manter): ");
                    double preco = sc.nextDouble();
                    if (preco != -1) produto.getEstoque().setPreco(preco);
                    sc.nextLine();
                } catch (Exception e2) {
                    System.out.println("Erro ao inserir quantidade/preço: " + e2);
                    break;
                }
            }
			
			if(loja.editarProduto(termoBusca, produto)) {
				System.out.println("\nProduto editado com sucesso!");
			} else {
				System.out.println("\nFalha ao editar produto");
			}
			break;
		case "3":
			mostrarObjetos(loja.produtos);
    		System.out.print("Digite o código do produto a ser excluído: ");
            int codigo = sc.nextInt();
            sc.nextLine();
			if(loja.excluirProduto(codigo)) {
				System.out.println("\nProduto excluído com sucesso!");
			} else {
				System.out.println("\nProduto com código informado não encontrado.");
			}
			break;
		case "4":
			System.out.println("Digite o código/nome do produto a ser pesquisado: ");
			String termoBusca2 = sc.nextLine().trim().toLowerCase();
			ArrayList<Produto> listaProdutos = loja.consultarProdutos(termoBusca2);
			if(listaProdutos == null) {
				System.out.println("\nFalha ao consultar produtos");
			} else {
				mostrarObjetos(listaProdutos);
			}
			break;
		case "5":
			mostrarObjetos(loja.produtos);
			break;
		case "6":
			mostrarObjetos(loja.produtos);
    		
    		System.out.println("Digite o código/nome do produto a ser pesquisado: ");
			String termoBusca4 = sc.nextLine().trim().toLowerCase();
			
			Estoque estoque = new Estoque();
			
			System.out.print("Digite a quantidade: ");
            int quantidade = sc.nextInt();
            estoque.setQuantidade(quantidade);
            System.out.print("Digite o preço: ");
            double preco = sc.nextDouble();
            estoque.setPreco(preco);
            sc.nextLine();
			
			if(loja.editarEstoqueProduto(termoBusca4, estoque)) {
				System.out.println("\nEstoque editado com sucesso");
			} else {
				System.out.println("\nErro ao editar o estoque do produto");
			}
			break;
		case "7":
			System.out.println("\nProdutos disponíveis:");
            mostrarObjetos(loja.produtos);
			
			System.out.println("\nDigite o código/nome do produto a ser alterado: ");
			String termoBusca3 = sc.nextLine().trim().toLowerCase();
			System.out.print("Digite o código do novo fornecedor: ");
            int codigoNovoFornecedor = sc.nextInt();
            sc.nextLine();
			if(loja.editarFornecedorProduto(termoBusca3, codigoNovoFornecedor)) {
				System.out.println("\nFornecedor do produto editado com sucesso");
			} else {
				System.out.println("\nErro ao editar o fornecedor do produto");
			}
			break;
		case "0":
			break;
		default:
			System.out.println("\nOpção inválida.");
		}
    }
    
    public void menuAdministradorClientes(Scanner sc) {
    	System.out.println("\n" + linha() + "\n     Menu de Usuários\n" + linha());
		System.out.println("1 - Mostrar todos clientes");
		System.out.println("0 - Voltar ao menu principal");
		System.out.print("Opção: ");
		
		String resposta = sc.nextLine();
		
		switch (resposta) {
		case "1":
			mostrarObjetos(loja.clientes);
			break;
		case "0":
			break;
		default:
			System.out.println("\nOpção inválida.");
		}
    	
    }
    
    public void menuAdministradorUsuarios(Scanner sc) {
    	System.out.println("\n" + linha() + "\n     Menu de Usuários\n" + linha());
		System.out.println("1 - Cadastrar usuário");
		System.out.println("2 - Mostrar todos usuários");
		System.out.println("3 - Excluir usuário");
		System.out.println("0 - Voltar ao menu principal");
		System.out.print("Opção: ");
		
		String resposta = sc.nextLine();
		
		switch (resposta) {
		case "1":
			System.out.println("\n--- Cadastro de Novo Usuário Administrador ---");
			System.out.print("Escolha um login: ");
            String login = sc.nextLine();
            System.out.print("Escolha uma senha: ");
            String senha = sc.nextLine();
			if(loja.cadastrarUsuarioAdmin(login, senha)) {
				System.out.println("\nUsuário admin Cadastrado com Sucesso!");
			}
			else {
				System.out.println("\nErro no cadastro de usuário admin");
			}
			break;
		case "2":
			mostrarObjetos(loja.usuariosAdmin);
			break;
		case "3":
			mostrarObjetos(loja.usuariosAdmin);
			
			System.out.print("Digite o usuário a ser excluído: ");
            String user = sc.nextLine();
			if(loja.excluirUsuarioAdmin(user)) {
				System.out.println("\nUsuário excluído com sucesso!");
			} else {
				System.out.println("\nFalha na exclusão do usuário");
			}
			break;
		case "0":
			break;
		default:
			System.out.println("\nOpção inválida.");
		}
    	
    }

    public void menuCliente(Usuario usuario, Scanner sc) {
    	boolean continuar = true;
    	System.out.println("\nLogin como CLIENTE realizado com sucesso!");
    	
    	while (continuar) {
	    	System.out.println("\n" + linha() + "\n     Menu de Cliente\n" + linha());
			System.out.println(" 1 - Menu de Produtos");
			System.out.println(" 2 - Menu de Pedidos");
	    	System.out.println(" 0 - Voltar ao menu principal");
	    	System.out.print("Opção: ");
	    	
	    	String resposta = sc.nextLine();
			
			switch (resposta) {
			case "1":
				menuClienteProdutos(usuario, sc);
				break;
			case "2":
				menuClientePedidos(usuario, sc);
				break;
			case "0":
				continuar = false;
				System.out.println("\nSaindo do acesso de cliente...");
				break;
			default:
				System.out.println("\nOpção inválida.");
			}
    	}
    }
    
    public void menuClienteProdutos(Usuario usuario, Scanner sc) {
    	System.out.println("\n" + linha() + "\n     Menu de Produtos\n" + linha());
		System.out.println(" 1 - Consultar todos produtos");
		System.out.println(" 2 - Consultar produtos por código/nome");
    	System.out.println(" 0 - Voltar ao menu principal");
    	System.out.print("Opção: ");
    	
    	String resposta = sc.nextLine();
		
		switch (resposta) {
		case "1":
			mostrarObjetos(loja.produtos);
			break;
		case "2":
			System.out.println("Digite o código/nome do produto a ser pesquisado: ");
			String termoBusca = sc.nextLine().trim().toLowerCase();
			ArrayList<Produto> listaProdutos = loja.consultarProdutos(termoBusca);
			mostrarObjetos(listaProdutos);
			break;
		case "0":
			break;
		default:
			System.out.println("\nOpção inválida.");
		}
	}
    
    public void menuClientePedidos(Usuario usuario, Scanner sc) {
    	System.out.println("\n" + linha() + "\n     Menu de Produtos\n" + linha());
		System.out.println("1 - Criar pedido");
		System.out.println("2 - Visualizar pedidos");
    	System.out.println("0 - Voltar ao menu principal");
    	System.out.print("Opção: ");
    	
    	String resposta = sc.nextLine();
		
		switch (resposta) {
		case "1":
			String continuar = "n";
			do {
				System.out.println("Selecione um produto para adicionar ao carrinho: ");
				mostrarObjetos(loja.produtos);
				String termoBusca = sc.nextLine().trim().toLowerCase();
				ArrayList<Produto> produtos = loja.consultarProdutos(termoBusca);
				if (produtos.size() == 0) {
					System.out.println("Produto Não Encontrado!");
					break;
				}
				Produto produto = produtos.get(0);
				System.out.println("Digite a quantidade que deseja comprar: ");
				int quantidade = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Confirma a adição do item? O total será R$" + loja.calcularTotalItem(new ItemPedido(produto, quantidade, produto.getEstoque().getPreco())));
				String confirma = sc.nextLine();
				
				if ("s".equals(confirma)) {				
					loja.cadastrarPedido(usuario.getCliente().getCodigo(), new ItemPedido(produto, quantidade, produto.getEstoque().getPreco()));
				}
				
				System.out.println("Deseja adicionar mais itens? (s)");
				continuar = sc.nextLine();
			} while("s".equals(continuar));
			sc.nextLine();
			break;
		case "2":
			try {
				ArrayList<Pedido> listaPedidos = loja.consultarPedidos(usuario.getCliente().getCodigo());
				mostrarObjetos(listaPedidos);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "0":
			break;
		default:
			System.out.println("\nOpção inválida.");
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
			
			mostrarObjetos(loja.fornecedores);
			
			System.out.print("Digite o código do fornecedor: ");
	        int codigoFornecedor = sc.nextInt();
	        sc.nextLine();
			
			if(!loja.vincularProdutoAFornecedor(p, codigoFornecedor)) {
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
			
			Cliente cliente = new Cliente(nome, telefone, email, cartaoCredito, endereco, null, usuario);
			usuario.setCliente(cliente);
			
			return cliente;
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
    
    public <T> void mostrarObjetos(ArrayList<T> lista) {
    	if (lista.isEmpty()) {
            return;
        }
    	
    	System.out.println("\n-- Lista de " + pluralizarClasse(lista.get(0).getClass().getSimpleName()) + " Cadastrados --");
        for (T item : lista) {
            if (item != null) {
                System.out.println(item.toString());
            }
        }
    }
    
    public String pluralizarClasse(String nomeClasse) {
        if (nomeClasse.endsWith("r") || nomeClasse.endsWith("z")) {
            return nomeClasse + "es"; // Fornecedor → Fornecedores
        } else if (nomeClasse.endsWith("m")) {
            return nomeClasse.substring(0, nomeClasse.length() - 1) + "ns"; // Ex: Item → Itens
        } else {
            return nomeClasse + "s"; // Produto → Produtos
        }
    }

    public String linha() {
    	return "--------------------------------";
    }
}
