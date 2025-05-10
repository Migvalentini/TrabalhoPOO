package projeto;

//import java.util.InputMismatchException;
import java.util.Scanner;

public class Loja {
	int totalUsuarios = 100;
	int totalFornecedores = 100;
	int totalProdutos = 100;
	int totalEstoques = 100;
	Usuario[] usuarios = new Usuario[totalUsuarios];
	Fornecedor[] fornecedores = new Fornecedor[totalFornecedores];
	Produto[] produtos = new Produto[totalProdutos];
	Estoque[] estoques = new Estoque[totalEstoques];
	String[] arquivos = {"fornecedores", "produtos", "clientes", "usuarios", "pedidos"};
	
	public boolean cadastrarFornecedor(Scanner sc) {
    	try {    		
    		System.out.println("\n--- Cadastro de Fornecedor ---");
    		Fornecedor novoFornecedor = Fornecedor.criarFornecedor(sc);
    		fornecedores[posicaoVazia(fornecedores)] = novoFornecedor;
    		return true;
    	} catch (Exception e) {
    		return false;
    	}
    }
    
    public boolean editarFornecedor(Scanner sc) {
       	Fornecedor[] listaFornecedores = consultarFornecedores(sc);
       	Fornecedor f = listaFornecedores[0];
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
    
    public boolean excluirFornecedor(Scanner sc) {
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
		} catch(Exception e) {}
		for(Fornecedor fornecedor : fornecedores) {
			if(fornecedor!=null && (fornecedor.getNome().toLowerCase().contains(termoBusca))) {
				listaFornecedores[cont++] = fornecedor;
			}
		}	
    	
    	return listaFornecedores;
    }
    
    
    public void mostrarFornecedores(Fornecedor[] fornecedores) {
    	System.out.println("\n-- Lista de Fornecedores Cadastrados --");
    	for (Fornecedor fornecedor : fornecedores) {
    		if(fornecedores != null) {    			
    			System.out.println(fornecedor.toString());
    			System.out.println(linha());
    		}
    	}
    }
 
    ////FORNECEDORES
    
    //PRODUTOS
    
    
    public boolean cadastrarProduto(Scanner sc) {
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
    
    
    public boolean editarProduto(Scanner sc) {
    	try {    		
    		Produto p = consultarProdutos(sc)[0];
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

    
    public boolean editarEstoqueProduto(Scanner sc) {
    	try {
    		Produto p = consultarProdutos(sc)[0];
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
    
    
    public boolean excluirProduto(Scanner sc) {
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
        } catch (NumberFormatException e) {}
		for (Produto produto : produtos) {
			if (produto != null && produto.getNome().toLowerCase().contains(termoBusca)) {
				listaProdutos[cont++] = produto;
			}
		}
		
		return listaProdutos;
    }
    
    public void mostrarProdutos(Produto[] listaProdutos) {
    	System.out.println("\n-- Lista de Produtos Cadastrados --");
    	for (int i = 0; i < listaProdutos.length; i++) {
    		if(listaProdutos[i] != null) {    			
    			System.out.println(listaProdutos[i].toString());
    			System.out.println(linha());
    		}
    	}
    }
    
    public boolean vincularProdutoAFornecedor(Scanner sc) {
    	try {    		
    		System.out.println("\n--- Vincular Produto a Fornecedor ---");
    		
    		mostrarProdutos(produtos);
    		Produto p = consultarProdutos(sc)[0];
    		if (p == null) {
    			System.out.println("\nProduto não encontrado.");
    			return false;
    		}
    		
    		mostrarFornecedores(fornecedores);
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
    
    
    public boolean cadastrarUsuario(Scanner sc) {
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
    
    
    public Usuario buscarUsuario(String login, String senha) {
        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i] != null && usuarios[i].getUsuario().equals(login) && usuarios[i].getSenha().equals(senha)) {
                return usuarios[i];
            }
        }
        return null;
    }

    
    public void mostrarUsuarios() {
    	System.out.println("\n-- Lista de Usuários Cadastrados: --");
        for (int i = 0; i < totalUsuarios; i++) {
        	if(usuarios[i] != null) {
        		System.out.println(usuarios[i].toString());
        		System.out.println(linha());
        	}
        }
    }
 
    
    public boolean excluirUsuario(Scanner sc) {
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
    
    public String linha() {
    	return "--------------------------------";
    }
        
    //ARQUIVOS
    
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
}
