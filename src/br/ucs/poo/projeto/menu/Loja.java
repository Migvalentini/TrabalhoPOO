package br.ucs.poo.projeto.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Loja {
	int totalUsuarios = 100;
	int totalFornecedores = 100;
	int totalProdutos = 100;
	int totalEstoques = 100;
	int totalClientes = 100;
	Usuario[] usuariosAdmin = new Usuario[totalUsuarios];
	Fornecedor[] fornecedores = new Fornecedor[totalFornecedores];
	Produto[] produtos = new Produto[totalProdutos];
	Estoque[] estoques = new Estoque[totalEstoques];
	Cliente[] clientes = new Cliente[totalClientes];
	
	public Loja() {
		usuariosAdmin[0] = new Usuario("admin", "123", TipoUsuario.ADMIN);
	}
	
	//FORNECEDOR
	
    public void cadastrarFornecedor(Fornecedor novoFornecedor) {
    	fornecedores[posicaoVazia(fornecedores)] = novoFornecedor;
    }
    
    public boolean editarFornecedor(Scanner sc) {
        try {
            System.out.print("Digite o código do fornecedor a ser editado: ");
            int codigo = sc.nextInt();
            sc.nextLine();

            Fornecedor fornecedorEncontrado = null;
            for (Fornecedor f : fornecedores) {
                if (f != null && f.getCodigo() == codigo) {
                    fornecedorEncontrado = f;
                    break;
                }
            }

            if (fornecedorEncontrado == null) {
                System.out.println("\nFornecedor não encontrado com o código informado.");
                return false;
            }

            System.out.println("\nFornecedor atual:");
            System.out.println(fornecedorEncontrado.toString());
            System.out.println("Digite o novo nome do fornecedor (ou deixe em branco para manter): ");
            String nome = sc.nextLine();
            if (!nome.isBlank()) fornecedorEncontrado.setNome(nome);
            System.out.println("Digite a nova descrição do fornecedor (ou deixe em branco para manter): ");
            String descricao = sc.nextLine();
            if (!descricao.isBlank()) fornecedorEncontrado.setDescricao(descricao);
            System.out.println("Digite o novo telefone do fornecedor (ou deixe em branco para manter): ");
            String telefone = sc.nextLine();
            if (!telefone.isBlank()) fornecedorEncontrado.setTelefone(telefone);
            System.out.println("Digite o novo email do fornecedor (ou deixe em branco para manter): ");
            String email = sc.nextLine();
            if (!email.isBlank()) fornecedorEncontrado.setEmail(email);
            System.out.print("\nDeseja alterar o endereço? (s/n): ");
            String alterarEndereco = sc.nextLine();
            if (alterarEndereco.equalsIgnoreCase("s")) {
                System.out.print("Digite a nova rua (ou deixe em branco para manter): ");
                String rua = sc.nextLine();
                if (!rua.isBlank()) fornecedorEncontrado.getEndereco().setRua(rua);
                System.out.print("Digite o novo número (ou deixe em branco para manter): ");
                String numero = sc.nextLine();
                if (!numero.isBlank()) fornecedorEncontrado.getEndereco().setNumero(numero);
                System.out.print("Digite o novo complemento (ou deixe em branco para manter): ");
                String complemento = sc.nextLine();
                if (!complemento.isBlank()) fornecedorEncontrado.getEndereco().setComplemento(complemento);
                System.out.print("Digite o novo bairro (ou deixe em branco para manter): ");
                String bairro = sc.nextLine();
                if (!bairro.isBlank()) fornecedorEncontrado.getEndereco().setBairro(bairro);
                System.out.print("Digite o novo CEP (ou deixe em branco para manter): ");
                String cep = sc.nextLine();
                if (!cep.isBlank()) fornecedorEncontrado.getEndereco().setCep(cep);
                System.out.print("Digite a nova cidade (ou deixe em branco para manter): ");
                String cidade = sc.nextLine();
                if (!cidade.isBlank()) fornecedorEncontrado.getEndereco().setCidade(cidade);
                System.out.print("Digite o novo estado (ou deixe em branco para manter): ");
                String estado = sc.nextLine();
                if (!estado.isBlank()) fornecedorEncontrado.getEndereco().setEstado(estado);
            }

            return true;

        } catch (InputMismatchException e) {
            System.out.println("\nErro: Código inválido. Por favor, digite um número.");
            sc.nextLine();
            return editarFornecedor(sc);
        } catch (Exception e) {
            return false;
        }
    }

    
    public boolean excluirFornecedor(Scanner sc) {
    	try {
            System.out.print("Digite o código do fornecedor a ser excluído: ");
            int codigo = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < fornecedores.length; i++) {
                if (fornecedores[i] != null && fornecedores[i].getCodigo() == codigo) {
                	fornecedores[i] = null;
                    return true;
                }
            }
            return false;
        } catch (InputMismatchException e) {
            System.out.println("\nErro: Código inválido. Por favor, digite um número.");
            sc.nextLine();
            return excluirFornecedor(sc);
        }
    }
    
    public Fornecedor[] consultarFornecedores(Scanner sc) {
    	Fornecedor[] listaFornecedores = new Fornecedor[totalFornecedores];
    	int cont=0;
    	   		
		System.out.println("Digite o código/nome do fornecedor a ser pesquisado: ");
		String termoBusca = sc.nextLine().trim().toLowerCase();
		
		try {
			int codigoBusca = Integer.parseInt(termoBusca);
			for (Fornecedor fornecedor : fornecedores) {
		        if (fornecedor != null && fornecedor.getCodigo() == codigoBusca) {
		        	listaFornecedores[cont++] = fornecedor;
		        	break;
		        }
			}
		} catch(Exception e) {
			return null;
		}
		for(Fornecedor fornecedor : fornecedores) {
			if(fornecedor!=null && (fornecedor.getNome().toLowerCase().contains(termoBusca))) {
				listaFornecedores[cont++] = fornecedor;
			}
		}	
    	
    	return listaFornecedores;
    }
    
    ////FORNECEDOR
    
    //PRODUTO
    
    public void cadastrarProduto(Produto novoProduto, Scanner sc) {
    	produtos[posicaoVazia(produtos)] = novoProduto;
    }
    
    public boolean editarProduto(Scanner sc) {
    	try {    		
    		Produto[] resultados = consultarProdutos(sc);
    	    if (resultados[0] == null) {
    	        return false;
    	    }
    	    Produto p = resultados[0];
    	    System.out.println(p.toString());
    	    
    	    System.out.println("Digite o novo nome do produto (ou deixe em branco para manter): ");
            String nome = sc.nextLine();
            if (!nome.isEmpty()) p.setNome(nome);
            System.out.println("Digite a nova descrição do produto (ou deixe em branco para manter): ");
            String descricao = sc.nextLine();
            if (!descricao.isEmpty()) p.setDescricao(descricao);

            System.out.print("\nDeseja alterar o estoque? (s/n): ");
            String alterarEstoque = sc.nextLine();
            if (alterarEstoque.equalsIgnoreCase("s")) {
                try {
                    System.out.print("Digite a nova quantidade (ou deixe -1 para manter): ");
                    int quantidade = sc.nextInt();
                    if (quantidade != -1) p.getEstoque().setQuantidade(quantidade);
                    System.out.print("Digite o novo preço (ou deixe -1 para manter): ");
                    double preco = sc.nextDouble();
                    if (preco != -1) p.getEstoque().setPreco(preco);
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("\nErro: Entrada inválida para quantidade ou preço. Tente novamente.");
                    sc.nextLine();
                    return editarProduto(sc);
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao editar produto: " + e.getMessage() + ". Tente novamente.");
            return editarProduto(sc);
        }
    }

    public boolean editarEstoqueProduto(Scanner sc) {
    	try {
            Produto[] resultados = consultarProdutos(sc);
            if (resultados[0] == null) {
                return false;
            }
            Produto p = resultados[0];

            System.out.print("Digite a quantidade: ");
            int quantidade = sc.nextInt();
            p.getEstoque().setQuantidade(quantidade);
            System.out.print("Digite o preço: ");
            double preco = sc.nextDouble();
            p.getEstoque().setPreco(preco);
            sc.nextLine();
            return true;
        } catch (InputMismatchException e) {
            System.out.println("\nErro: Entrada inválida para quantidade ou preço. Tente novamente.");
            sc.nextLine();
            return editarEstoqueProduto(sc);
        } catch (Exception e) {
            System.out.println("Erro ao editar estoque do produto: " + e.getMessage() + ". Tente novamente.");
            return editarEstoqueProduto(sc);
        }
    }
    
    public boolean excluirProduto(Scanner sc) {
    	try {
            System.out.print("Digite o código do produto a ser excluído: ");
            int codigo = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < produtos.length; i++) {
                if (produtos[i] != null && produtos[i].getCodigo() == codigo) {
                    produtos[i] = null;
                    return true;
                }
            }
            return false;
        } catch (InputMismatchException e) {
            System.out.println("\nErro: Código inválido. Por favor, digite um número.");
            sc.nextLine();
            return excluirProduto(sc);
        }
    }    

    public Produto[] consultarProdutos(Scanner sc) {
    	Produto[] listaProdutos = new Produto[totalProdutos];
    	int cont=0;
    	    		
		System.out.println("Digite o código/nome do produto a ser pesquisado: ");
		String termoBusca = sc.nextLine().trim().toLowerCase();
		
		try {
            int codigoBusca = Integer.parseInt(termoBusca);
            for (Produto produto : produtos) {
                if (produto != null && produto.getCodigo() == codigoBusca) {
                	listaProdutos[cont++] = produto;
                }
            }
        } catch (NumberFormatException e) {
        	return null;
        }
		for (Produto produto : produtos) {
			if (produto != null && produto.getNome().toLowerCase().contains(termoBusca)) {
				listaProdutos[cont++] = produto;
			}
		}
		
		return listaProdutos;
    }

    public boolean vincularProdutoAFornecedor(Produto p, Scanner sc) {
    	mostrarObjetos(fornecedores);
        
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
            return false;
        }

        fornecedorSelecionado.adicionarProduto(p);
        return true;
    }
    
    ////PRODUTO
    
    //USUARIO
    
    public boolean cadastrarUsuarioAdmin(Scanner sc) {
        try {
            System.out.print("Escolha um login: ");
            String login = sc.nextLine();
            System.out.print("Escolha uma senha: ");
            String senha = sc.nextLine();

            for (Usuario usuario : usuariosAdmin) {
                if (usuario != null && usuario.getUsuario().equals(login)) {
                    System.out.println("Login já existe.");
                    return false;
                }
            }

            usuariosAdmin[posicaoVazia(usuariosAdmin)] = new Usuario(login, senha, TipoUsuario.ADMIN);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar administrador: " + e.getMessage() + ". Tente novamente.");
            return cadastrarUsuarioAdmin(sc);
        }
    }
    
    public Usuario buscarUsuario(String login, String senha) {
    	try {    		
    		for (Cliente cliente : clientes) {
    			if(cliente != null) {    				
    				Usuario usuario = cliente.getUsuario();
    				if (usuario != null && usuario.getUsuario().equals(login) && usuario.getSenha().equals(senha)) {
    					return cliente.getUsuario();
    				}
    			}
    		}
    		for (Usuario usuario : usuariosAdmin) {
    			if (usuario != null && usuario.getUsuario().equals(login) && usuario.getSenha().equals(senha)) {
    				return usuario;
    			}
    		}
    	} catch(Exception e) {
    		System.out.println("Erro ao buscar usuário: " + e.getMessage());
    	}
    	
        return null;
    }
 
    public boolean excluirUsuarioAdmin(Scanner sc) {
    	try {
            System.out.print("Digite o usuário a ser excluído: ");
            String user = sc.nextLine();

            for (int i = 0; i < usuariosAdmin.length; i++) {
            	if(usuariosAdmin[i] != null && usuariosAdmin[i].getUsuario().equals(user) && !"admin".equals(user)) {
                	usuariosAdmin[i] = null;
                    return true;
                }
            }
            System.out.println("Usuário " + user + " não encontrado ou não pode ser excluído.");
            return false;
        } catch (Exception e) {
            System.out.println("Erro ao excluir administrador: " + e.getMessage() + ". Tente novamente.");
            return excluirUsuarioAdmin(sc);
        }
    }
    
    public void cadastrarCliente(Cliente novoCliente) {
    	clientes[posicaoVazia(clientes)] = novoCliente;
    }
    
    public boolean clienteJaCadastrado(Usuario usuario) {
    	for (Cliente cliente : clientes) {
            if(cliente != null) {
            	Usuario usuarioCliente = cliente.getUsuario();
            	if(usuarioCliente != null && (usuarioCliente.getUsuario().equals(usuario.getUsuario()))) {
            		return true;
            	}
            }
        }
    	return false;
    }
    
    //USUARIO
        
    ////ARQUIVOS
    
    /*public void abrirArquivos(String[] arquivos) {
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
    
    public void escreveNoArquivo(Object[] array, String nomeArquivo) {
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
    
    public void leArquivo(Object[] array, String nomeArquivo, Class<?> classe) {
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


    public int posicaoVazia(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        return -1; 
    }
    
    public <T> void mostrarObjetos(T[] objetos) {
        for (T obj : objetos) {
            if (obj != null) {
                System.out.println(obj.toString());
                System.out.println(linha());
            }
        }
    }
    
    public String linha() {
    	return "--------------------------------";
    }
}
