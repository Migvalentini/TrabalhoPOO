package trabalho;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import trabalho.excecoes.RegistroNaoEncontradoException;
import trabalho.excecoes.UsuarioJaCadastradoException;

public class Loja {
	private ObjectMapper mapper;
	ArrayList<Usuario> usuariosAdmin = new ArrayList<Usuario>();
	ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	ArrayList<Produto> produtos = new ArrayList<Produto>();
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
	public Loja() {
		usuariosAdmin.add(new Usuario("admin", "123", TipoUsuario.ADMIN));
		this.mapper = new ObjectMapper();
	}
	
	//FORNECEDOR
	
    public void cadastrarFornecedor(Fornecedor novoFornecedor) throws Exception {
    	 try {    		 
    		 fornecedores.add(novoFornecedor);
    	 } catch(Exception e) {
    		 throw new Exception(e.getMessage());
    	 }
    }
    
    public void existeFornecedor(int codigo) throws RegistroNaoEncontradoException, Exception {
        try {
            Fornecedor fornecedorEncontrado = null;
            for (Fornecedor f : fornecedores) {
                if (f != null && f.getCodigo() == codigo) {
                    fornecedorEncontrado = f;
                    break;
                }
            }

            if (fornecedorEncontrado == null) {
                throw new RegistroNaoEncontradoException("Fornecedor");
            }
        } catch (Exception e) {
        	throw new Exception(e.getMessage());
        }
    }
    
    public void editarFornecedor(int codigo, Fornecedor fornecedorComNovosDados) throws RegistroNaoEncontradoException, Exception {
        try {
            Fornecedor fornecedorEncontrado = null;
            for (Fornecedor f : fornecedores) {
                if (f != null && f.getCodigo() == codigo) {
                    fornecedorEncontrado = f;
                    break;
                }
            }

            if (fornecedorComNovosDados.getNome() != null && !fornecedorComNovosDados.getNome().isBlank()) {
                fornecedorEncontrado.setNome(fornecedorComNovosDados.getNome());
            }
            if (fornecedorComNovosDados.getDescricao() != null && !fornecedorComNovosDados.getDescricao().isBlank()) {
                fornecedorEncontrado.setDescricao(fornecedorComNovosDados.getDescricao());
            }
            if (fornecedorComNovosDados.getTelefone() != null && !fornecedorComNovosDados.getTelefone().isBlank()) {
                fornecedorEncontrado.setTelefone(fornecedorComNovosDados.getTelefone());
            }
            if (fornecedorComNovosDados.getEmail() != null && !fornecedorComNovosDados.getEmail().isBlank()) {
                fornecedorEncontrado.setEmail(fornecedorComNovosDados.getEmail());
            }

            if (fornecedorComNovosDados.getEndereco() != null) {
                Endereco novoEndereco = fornecedorComNovosDados.getEndereco();
                Endereco enderecoAtual = fornecedorEncontrado.getEndereco();

                if (enderecoAtual == null) {
                    enderecoAtual = new Endereco();
                    fornecedorEncontrado.setEndereco(enderecoAtual);
                }

                if (novoEndereco.getRua() != null && !novoEndereco.getRua().isBlank()) {
                    enderecoAtual.setRua(novoEndereco.getRua());
                }
                if (novoEndereco.getNumero() != null && !novoEndereco.getNumero().isBlank()) {
                    enderecoAtual.setNumero(novoEndereco.getNumero());
                }
                if (novoEndereco.getComplemento() != null && !novoEndereco.getComplemento().isBlank()) {
                    enderecoAtual.setComplemento(novoEndereco.getComplemento());
                }
                if (novoEndereco.getBairro() != null && !novoEndereco.getBairro().isBlank()) {
                    enderecoAtual.setBairro(novoEndereco.getBairro());
                }
                if (novoEndereco.getCep() != null && !novoEndereco.getCep().isBlank()) {
                    enderecoAtual.setCep(novoEndereco.getCep());
                }
                if (novoEndereco.getCidade() != null && !novoEndereco.getCidade().isBlank()) {
                    enderecoAtual.setCidade(novoEndereco.getCidade());
                }
                if (novoEndereco.getEstado() != null && !novoEndereco.getEstado().isBlank()) {
                    enderecoAtual.setEstado(novoEndereco.getEstado());
                }
            }
        } catch (Exception e) {
        	throw new Exception(e.getMessage());
        }
    }

    public void excluirFornecedor(int codigo) throws RegistroNaoEncontradoException, Exception {
    	try {
            for (int i = 0; i < fornecedores.size(); i++) {
            	Fornecedor fornecedor = fornecedores.get(i);
            	if (fornecedor != null && fornecedor.getCodigo() == codigo) {
                	if(fornecedor.getProdutos() == null || fornecedor.getProdutos().isEmpty()) {                		
                		fornecedores.remove(fornecedor);
                		return;
                	}
                }
			}
            throw new RegistroNaoEncontradoException("Fornecedor");
        } catch (Exception e) {
        	throw new Exception(e.getMessage());
        }
    }
    
    public ArrayList<Fornecedor> consultarFornecedores(String termoBusca) {
    	ArrayList<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();
		
		try {
			int codigoBusca = Integer.parseInt(termoBusca);
			for (Fornecedor fornecedor : fornecedores) {
		        if (fornecedor != null && fornecedor.getCodigo() == codigoBusca) {
		        	listaFornecedores.add(fornecedor);
		        	break;
		        }
			}
		} catch(Exception e) {
			for(Fornecedor fornecedor : fornecedores) {
				if(fornecedor!=null && (fornecedor.getNome().toLowerCase().contains(termoBusca))) {
					listaFornecedores.add(fornecedor);
				}
			}	
		}
    	
    	return listaFornecedores;
    }
    
    public void corrigirCodigoFornecedores() {
        int maxCodigo = 0;
        for (Fornecedor f : fornecedores) {
            if (f.getCodigo() > maxCodigo) {
                maxCodigo = f.getCodigo();
            }
        }
		Fornecedor.setUltimoCodigo(maxCodigo+1);
    }
    
    ////FORNECEDOR
    
    //PRODUTO
    
    public void cadastrarProduto(Produto novoProduto) throws Exception {
		try {    		 
			produtos.add(novoProduto);
		} catch(Exception e) {
			throw new Exception(e.getMessage());
	   	 }
    }
    
    public void existeProduto(String termoBusca) throws RegistroNaoEncontradoException, Exception {
    	try {   
    		ArrayList<Produto> resultados = consultarProdutos(termoBusca);
    	    if (resultados.size() == 0) {
    	        throw new RegistroNaoEncontradoException("Produto");
    	    }
        } catch (Exception e) {
        	throw new Exception(e.getMessage());
        }
    }
    
    public void editarProduto(String termoBusca, Produto produtoComNovosDados) throws RegistroNaoEncontradoException, Exception {
    	try {   
    		ArrayList<Produto> resultados = consultarProdutos(termoBusca);
    	    if (resultados.size() == 0) {
    	        throw new RegistroNaoEncontradoException("Produto");
    	    }
    	    Produto produtoEncontrado = resultados.get(0);
    	    
    	    if (produtoComNovosDados.getNome() != null && !produtoComNovosDados.getNome().isBlank()) {
    	    	produtoEncontrado.setNome(produtoComNovosDados.getNome());
            }
    	    if (produtoComNovosDados.getDescricao() != null && !produtoComNovosDados.getDescricao().isBlank()) {
    	    	produtoEncontrado.setDescricao(produtoComNovosDados.getDescricao());
            }
    	    
    	    if (produtoComNovosDados.getEstoque() != null) {
                Estoque novoEstoque = produtoComNovosDados.getEstoque();
                Estoque estoqueAtual = produtoEncontrado.getEstoque();

                if (estoqueAtual == null) {
                	estoqueAtual = new Estoque();
                	produtoEncontrado.setEstoque(estoqueAtual);
                }

                if(produtoComNovosDados.getEstoque().getQuantidade() >= 0) estoqueAtual.setQuantidade(novoEstoque.getQuantidade());
                if(produtoComNovosDados.getEstoque().getPreco() >= 0) estoqueAtual.setPreco(novoEstoque.getPreco());
                
            }
        } catch (Exception e) {
        	throw new Exception(e.getMessage());
        }
    }

    public void editarEstoqueProduto(String termoBusca, Estoque estoqueComNovosdados) throws RegistroNaoEncontradoException, Exception {
    	try {
    		ArrayList<Produto> resultados = consultarProdutos(termoBusca);
            if (resultados.size() == 0) {
                throw new RegistroNaoEncontradoException("Produto");
            }
            Produto produtoSelecionado = resultados.get(0);

            produtoSelecionado.getEstoque().setQuantidade(estoqueComNovosdados.getQuantidade());
            produtoSelecionado.getEstoque().setPreco(estoqueComNovosdados.getPreco());
        } catch (Exception e) {
        	throw new Exception(e.getMessage());
        }
    }
    
    public void excluirProduto(int codigo) throws RegistroNaoEncontradoException, Exception {
    	try {
            for (Pedido pedido : pedidos) {
            	if (pedido != null) {
            		for(ItemPedido p : pedido.getItensPedido()) {
            			if(p != null && p.getProduto().getCodigo() == codigo) {
            				throw new Exception("Produto Já Foi Utilizado em Algum Pedido. Exclusão Cancelada!");
            			}
            		}
            	}
            }
            Produto produtoRemovido = null;

            for (Produto produto : produtos) {
            	if(produto != null) {            		
            		if (produtos != null && produto.getCodigo() == codigo) {
            			produtoRemovido = produto;
            			produtos.remove(produto);
            			break;
            		}
            	}
			}

            if (produtoRemovido == null) {
                throw new RegistroNaoEncontradoException("Produto");
            }

        } catch (Exception e) {
        	throw new Exception(e.getMessage());
        }
    }    

    public ArrayList<Produto> consultarProdutos(String termoBusca) {
    	ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		
		try {
            int codigoBusca = Integer.parseInt(termoBusca);
            for (Produto produto : produtos) {
                if (produto != null && produto.getCodigo() == codigoBusca) {
                	listaProdutos.add(produto);
                }
            }
        } catch (NumberFormatException e) {
        	for (Produto produto : produtos) {
        		if (produto != null && (produto.getNome().toLowerCase().contains(termoBusca) || produto.getDescricao().toLowerCase().contains(termoBusca))) {
        			listaProdutos.add(produto);
        		}
        	}
        }
		
		return listaProdutos;
    }

    public void vincularProdutoAFornecedor(Produto p, int codigoFornecedor) throws RegistroNaoEncontradoException, Exception {
    	try {			
    		Fornecedor fornecedorSelecionado = null;
    		for (Fornecedor f : fornecedores) {
    			if (f != null && f.getCodigo() == codigoFornecedor) {
    				fornecedorSelecionado = f;
    				break;
    			}
    		}
    		
    		if (fornecedorSelecionado == null) {
    			throw new RegistroNaoEncontradoException("Fornecedor");
    		}
    		
    		fornecedorSelecionado.adicionarProduto(p);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
    }
    
    public void editarFornecedorProduto(String termoBusca, int codigoNovoFornecedor) throws RegistroNaoEncontradoException, Exception {
        try {
            ArrayList<Produto> resultadosProdutos = consultarProdutos(termoBusca);
            if (resultadosProdutos == null || resultadosProdutos.get(0) == null) {
                throw new RegistroNaoEncontradoException("Produto");
            }
            Produto produtoSelecionado = resultadosProdutos.get(0);

            Fornecedor fornecedorAtual = null;
            for (Fornecedor f : fornecedores) {
                if (f != null && f.getProdutos() != null) {
                    for (Produto p : f.getProdutos()) {
                        if (p != null && p.getCodigo() == produtoSelecionado.getCodigo()) {
                            fornecedorAtual = f;
                            break;
                        }
                    }
                }
            }

            Fornecedor novoFornecedor = null;
            for (Fornecedor f : fornecedores) {
                if (f != null && f.getCodigo() == codigoNovoFornecedor) {
                    novoFornecedor = f;
                    break;
                }
            }

            if (novoFornecedor == null) {
            	throw new RegistroNaoEncontradoException("Fornecedor");
            }

            if (fornecedorAtual != null) {
                fornecedorAtual.removerProduto(produtoSelecionado);
            }

            novoFornecedor.adicionarProduto(produtoSelecionado);

        } catch (Exception e) {
        	throw new Exception(e.getMessage());
        }
    }
    
    public void corrigirCodigoProdutos() {
        int maxCodigo = 0;
        for (Produto p : produtos) {
            if (p.getCodigo() > maxCodigo) {
                maxCodigo = p.getCodigo();
            }
        }
		Produto.setUltimoCodigo(maxCodigo+1);
    }
    
    ////PRODUTO
   
    //PEDIDO
    
    public ArrayList<Pedido> consultarPedidos(Integer idCliente, Integer codigo) {
    	ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
    	
    	for (Pedido pedido : pedidos) {
            if (pedido != null && pedido.getCodigo() == codigo && pedido.getIdCliente() == idCliente) {
                listaPedidos.add(pedido);
            }
        }
        
		return listaPedidos;
    }
    
    public ArrayList<Pedido> consultarPedidos(Integer idCliente, String dataInicialFormatada, String dataFinalFormatada) throws Exception {
    	ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date dataInicial = sdf.parse(dataInicialFormatada);
            Date dataFinal = sdf.parse(dataFinalFormatada);

            for (Pedido pedido : pedidos) {
                if (pedido != null) {
                    Date dataPedido = pedido.getDataPedido();
                    if (dataPedido.compareTo(dataInicial) >= 0 && dataPedido.compareTo(dataFinal) <= 0 && pedido.getIdCliente() == idCliente) {
                        listaPedidos.add(pedido);
                    }
                }
            }
        } catch (Exception e) {
        	throw new Exception(e);
        }
        
		return listaPedidos;
    }
    
    public ArrayList<Pedido> consultarPedidos(String dataInicialFormatada, String dataFinalFormatada) {
    	ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date dataInicial = sdf.parse(dataInicialFormatada);
            Date dataFinal = sdf.parse(dataFinalFormatada);

            for (Pedido pedido : pedidos) {
                if (pedido != null) {
                    Date dataPedido = pedido.getDataPedido();
                    if (dataPedido.compareTo(dataInicial) >= 0 && dataPedido.compareTo(dataFinal) <= 0) {
                        listaPedidos.add(pedido);
                    }
                }
            }
        } catch (Exception e) {

        }
        
		return listaPedidos;
    }
    
    public ArrayList<Pedido> consultarPedidos(int idCliente) {
    	ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
		
		for (Pedido pedido : pedidos) {
        	if (pedido != null && pedido.getIdCliente() == idCliente) {
            	listaPedidos.add(pedido);
            }
        }
        
		
		return listaPedidos;
    }
    
    public ArrayList<Pedido> consultarPedidos(int idCliente, TipoPedido tipo) {
    	ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
		
		for (Pedido pedido : pedidos) {
        	if (pedido != null && pedido.getIdCliente() == idCliente && pedido.getSituacao() == tipo) {
            	listaPedidos.add(pedido);
            }
        }
		
		return listaPedidos;
    }
    
    public ArrayList<Pedido> consultarPedidos(TipoPedido tipo) {
    	ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
		
		for (Pedido pedido : pedidos) {
        	if (pedido != null && pedido.getSituacao() != tipo) {
            	listaPedidos.add(pedido);
            }
        }
		
		return listaPedidos;
    }
    
    public ArrayList<Pedido> consultarPedidosNovos() {
    	ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
		
		for (Pedido pedido : pedidos) {
        	if (pedido != null && pedido.getSituacao() == TipoPedido.NOVO) {
            	listaPedidos.add(pedido);
            }
        }
		
		return listaPedidos;
    }
    
    public double calcularTotalItem(ItemPedido itemPedido) throws Exception {
    	try {
    		return itemPedido.getPreco() * itemPedido.getQuantidade();			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
    }
    
    public void atualizarEstoque(Produto p, int quantidade) throws Exception {
    	try {			
    		for (Produto produto : produtos) {
    			if (produto.equals(p)) {
    				Estoque estoque = new Estoque(produto.getEstoque().getQuantidade() - quantidade, produto.getEstoque().getPreco());
    				produto.setEstoque(estoque);
    				return;
    			}
    		}
    		throw new RegistroNaoEncontradoException("Produto");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
    }
    
    public int cadastrarPedido(Integer idCliente, ItemPedido itemPedido) throws Exception {
		try {    		 
			Pedido novoPedido = new Pedido(idCliente, new Date(), null, null, null, TipoPedido.NOVO, itemPedido, itemPedido.getPreco());
	        pedidos.add(novoPedido);
	        return novoPedido.getCodigo();
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
    }
    
    public void addProdutoPedido(Integer codigo, ItemPedido itemPedido) throws RegistroNaoEncontradoException, Exception {
		try {    		 
			for (Pedido pedido : pedidos) {
	        	if (pedido != null && pedido.getCodigo() == codigo) {
	        		pedido.addItensPedido(itemPedido);
	        		pedido.adicionarTotalPedido(itemPedido.getPreco());
	        		return;
	            }
	        }
			throw new RegistroNaoEncontradoException("Pedido");
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
    }
    
    public void calcularICMSPedido(Integer codigo) throws RegistroNaoEncontradoException, Exception {
		try {    		 
			for (Pedido pedido : pedidos) {
	        	if (pedido != null && pedido.getCodigo() == codigo) {
	        		pedido.adicionarICMS();
	        		return;
	            }
	        }
			throw new RegistroNaoEncontradoException("Pedido");
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
    }
    
    public double mostrarTotalPedido(Integer codigo) throws Exception {
		try {    		 
			for (Pedido pedido : pedidos) {
	        	if (pedido != null && pedido.getCodigo() == codigo) {
	        		return pedido.getTotalPedido();
	            }
	        }
			return 0;
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
    }
  
    public void retomarEstoque(int codigoPedido) throws RegistroNaoEncontradoException, Exception {
    	try {			
    		for (Pedido pedido : pedidos) {
    			if (pedido.getCodigo() == codigoPedido ) {
    				ArrayList<ItemPedido> itensPedidos = pedido.getItensPedido();
    				for (ItemPedido itemPedido : itensPedidos) {
    					int quantidade = itemPedido.getQuantidade();
                        Estoque estoque = itemPedido.getProduto().getEstoque();
                        estoque.setQuantidade(estoque.getQuantidade() + quantidade);
    				}
    				return;
    			}
    		}
    		throw new RegistroNaoEncontradoException("Pedido");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
    }
    
    public void enviarPedido(int codigoPedido) throws RegistroNaoEncontradoException, Exception {
    	try {			
    		for (Pedido pedido : pedidos) {
    			if (pedido.getCodigo() == codigoPedido && pedido.getSituacao() == TipoPedido.NOVO) {
    				pedido.setSituacao(TipoPedido.ENVIADO);
    				pedido.setDataEnvio(new Date());
    				return;
    			}
    		}
    		throw new RegistroNaoEncontradoException("Pedido");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
    }
    
    public void cancelarPedido(int codigoPedido) throws RegistroNaoEncontradoException, Exception {
    	try {			
    		for (Pedido pedido : pedidos) {
    			if (pedido.getCodigo() == codigoPedido && pedido.getSituacao() != TipoPedido.CANCELADO) {
    				pedido.setSituacao(TipoPedido.CANCELADO);
    				pedido.setDataCancelamento(new Date());
    				return;
    			}
    		}
    		throw new RegistroNaoEncontradoException("Pedido");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
    }
    
    public void receberPedido(int idCliente, int codigoPedido) throws RegistroNaoEncontradoException, Exception {
    	try {			
    		for (Pedido pedido : pedidos) {
    			if (pedido.getIdCliente() == idCliente && pedido.getCodigo() == codigoPedido) {
    				if(pedido.getDataEnvio() == null) {
    					throw new Exception("O pedido ainda não foi enviado pelo administrador");
    				}
    				pedido.setSituacao(TipoPedido.ENTREGUE);
    				pedido.setDataEntrega(new Date());
    				return;
    			}
    		}
    		throw new RegistroNaoEncontradoException("Pedido");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
    }
    
    public void corrigirCodigoPedidos() {
        int maxCodigo = 0;
        for (Pedido p : pedidos) {
            if (p.getCodigo() > maxCodigo) {
                maxCodigo = p.getCodigo();
            }
        }
		Pedido.setUltimoCodigo(maxCodigo+1);
    }
    
    ////PEDIDO
    
    //CLIENTE
    
    public void excluirCliente(String nome) throws RegistroNaoEncontradoException, Exception {
    	try {
    		for (Cliente c : clientes) {
            	if(c != null && c.getNome().equals(nome) && !"admin".equals(nome)) {
                	clientes.remove(c);
                    return;
                }
			}
    		throw new RegistroNaoEncontradoException();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public void corrigirCodigoClientes() {
        int maxCodigo = 0;
        for (Cliente c : clientes) {
            if (c.getCodigo() > maxCodigo) {
                maxCodigo = c.getCodigo();
            }
        }
		Cliente.setUltimoCodigo(maxCodigo+1);
    }
    
    ////CLIENTE
    
    //USUARIO
    
    public void cadastrarUsuarioAdmin(String login, String senha) throws UsuarioJaCadastradoException, Exception {
        try {
            for (Usuario usuario : usuariosAdmin) {
                if (usuario != null && usuario.getUsuario().equals(login)) {
                    throw new UsuarioJaCadastradoException();
                }
            }

            usuariosAdmin.add(new Usuario(login, senha, TipoUsuario.ADMIN));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public Usuario buscarUsuario(String login, String senha) throws Exception {
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
    		throw new Exception(e.getMessage());
    	}
    	
        return null;
    }
 
    public void excluirUsuarioAdmin(String user) throws RegistroNaoEncontradoException, Exception {
    	try {
    		for (Usuario usuarioAdmin : usuariosAdmin) {
            	if(usuarioAdmin != null && usuarioAdmin.getUsuario().equals(user) && !"admin".equals(user)) {
                	usuariosAdmin.remove(usuarioAdmin);
                    return;
                }
			}
    		throw new RegistroNaoEncontradoException();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public void cadastrarCliente(Cliente novoCliente) throws Exception {
    	try {    		 
    		clientes.add(novoCliente);
    	} catch(Exception e) {
    		throw new Exception(e.getMessage());
    	}
   }
    
    public void isClienteJaCadastrado(Usuario usuario) throws UsuarioJaCadastradoException {
    	for (Cliente cliente : clientes) {
            if(cliente != null) {
            	Usuario usuarioCliente = cliente.getUsuario();
            	if(usuarioCliente != null && (usuarioCliente.getUsuario().equals(usuario.getUsuario()))) {
            		throw new UsuarioJaCadastradoException();
            	}
            }
        }
    }
    
    //USUARIO
    
    //ARQUIVOS
    
    private void gravaArquivo(String nomeArquivo, String texto) throws IOException {
    	try {			
    		FileWriter fw = new FileWriter(nomeArquivo);
    		fw.write(texto);
    		fw.close();
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		}
    }
    
    private String leArquivo(String nomeArquivo) throws IOException {
    	try {			
    		StringBuilder sb = new StringBuilder();
    		FileInputStream fis = new FileInputStream(nomeArquivo);
    		InputStreamReader isr = new InputStreamReader(fis);
    		BufferedReader br = new BufferedReader(isr);
    		String linha;
    		while((linha = br.readLine()) != null) {
    			sb.append(linha);
    			sb.append("\n");
    		}
    		fis.close();
    		return sb.toString();
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		}
    }
    
    public <T> void gravarListaJSON(String nomeArquivo, ArrayList<T> lista) throws IOException {
    	try {			
    		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(lista);
    		gravaArquivo(nomeArquivo, json);
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		}
    }
	
	public <T> ArrayList<T> lerJson(String nomeArquivo, TypeReference<ArrayList<T>> typeReference) throws IOException {
		try {			
			String json = leArquivo(nomeArquivo);
			return mapper.readValue(json, typeReference);
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		}
    }

	public void carregarProdutos(String nomeArquivo) throws IOException {
        try {
            this.produtos = lerJson(nomeArquivo, new TypeReference<ArrayList<Produto>>() {});
        } catch (IOException e) {
            this.produtos = new ArrayList<>();
            throw new IOException(e.getMessage());
        }
    }

    public void carregarFornecedores(String nomeArquivo) throws IOException {
        try {
            this.fornecedores = lerJson(nomeArquivo, new TypeReference<ArrayList<Fornecedor>>() {});
        } catch (IOException e) {
            this.fornecedores = new ArrayList<>();
            throw new IOException(e.getMessage());
        }
    }

    public void carregarClientes(String nomeArquivo) throws IOException {
        try {
            this.clientes = lerJson(nomeArquivo, new TypeReference<ArrayList<Cliente>>() {});
        } catch (IOException e) {
            this.clientes = new ArrayList<>();
            throw new IOException(e.getMessage());
        }
    }
    
    public void carregarPedidos(String nomeArquivo) throws IOException {
        try {
            this.pedidos = lerJson(nomeArquivo, new TypeReference<ArrayList<Pedido>>() {});
        } catch (IOException e) {
            this.pedidos = new ArrayList<>();
            throw new IOException(e.getMessage());
        }
    }
    
    public void carregarUsuariosAdmin(String nomeArquivo) throws IOException {
        try {
            this.usuariosAdmin = lerJson(nomeArquivo, new TypeReference<ArrayList<Usuario>>() {});
        } catch (IOException e) {
            this.usuariosAdmin = new ArrayList<>();
            throw new IOException(e.getMessage());
        }
    }
    
    ////ARQUIVOS
}
