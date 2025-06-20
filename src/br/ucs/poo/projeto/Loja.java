package br.ucs.poo.projeto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.ucs.poo.projeto.excecoes.RegistroNaoEncontradoException;
import br.ucs.poo.projeto.excecoes.UsuarioJaCadastradoException;

public class Loja {
	ArrayList<Usuario> usuariosAdmin = new ArrayList<Usuario>();
	ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	ArrayList<Produto> produtos = new ArrayList<Produto>();
	ArrayList<Estoque> estoques = new ArrayList<Estoque>();
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
	public Loja() {
		usuariosAdmin.add(new Usuario("admin", "123", TipoUsuario.ADMIN));
	}
	
	//FORNECEDOR
	
    public void cadastrarFornecedor(Fornecedor novoFornecedor) throws Exception {
    	 try {    		 
    		 fornecedores.add(novoFornecedor);
    	 } catch(Exception e) {
    		 throw new Exception(e.getMessage(), e);
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

            if (fornecedorEncontrado == null) {
                throw new RegistroNaoEncontradoException("Fornecedor");
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
        	throw new Exception(e.getMessage(), e);
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
    
    ////FORNECEDOR
    
    //PRODUTO
    
    public void cadastrarProduto(Produto novoProduto) throws Exception {
		try {    		 
			produtos.add(novoProduto);
		} catch(Exception e) {
			throw new Exception(e.getMessage(), e);
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
        	throw new Exception(e.getMessage(), e);
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
        	throw new Exception(e.getMessage(), e);
        }
    }
    
    public void excluirProduto(int codigo) throws RegistroNaoEncontradoException, Exception {
    	try {
            Produto produtoRemovido = null;

            for (Produto produto : produtos) {
            	if (produtos != null && produto.getCodigo() == codigo) {
                    produtoRemovido = produto;
                    produtos.remove(produto);
                    break;
                }
			}

            if (produtoRemovido == null) {
                throw new RegistroNaoEncontradoException("Produto");
            }

            for (Fornecedor fornecedor : fornecedores) {
                if (fornecedor != null) {
                    fornecedor.removerProduto(produtoRemovido);
                }
            }

        } catch (Exception e) {
        	throw new Exception(e.getMessage(), e);
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
			throw new Exception(e.getMessage(), e);
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
        	throw new Exception(e.getMessage(), e);
        }
    }
    
    ////PRODUTO
   
    //PEDIDO
    
    public ArrayList<Pedido> consultarPedidos(Integer idCliente, Integer codigo, String dataInicialFormatada, String dataFinalFormatada) {
    	ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	
    	for (Pedido pedido : pedidos) {
            if (pedido != null && pedido.getCodigo() == codigo && pedido.getIdCliente() == idCliente) {
                listaPedidos.add(pedido);
            }
        }

        if (listaPedidos.isEmpty()) {
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
            	
            }
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
    
    public double calcularTotalItem(ItemPedido itemPedido) throws Exception {
    	try {
    		return itemPedido.getPreco() * itemPedido.getQuantidade();			
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
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
			throw new Exception(e.getMessage(), e);
		}
    }
    
    public int cadastrarPedido(Integer idCliente, ItemPedido itemPedido) throws Exception {
		try {    		 
			Pedido novoPedido = new Pedido(idCliente, new Date(), null, null, null, TipoPedido.NOVO, itemPedido, itemPedido.getPreco());
	        pedidos.add(novoPedido);
	        return novoPedido.getCodigo();
		} catch(Exception e) {
			throw new Exception(e.getMessage(), e);
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
			throw new Exception(e.getMessage(), e);
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
			throw new Exception(e.getMessage(), e);
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
			throw new Exception(e.getMessage(), e);
		}
    }
    
    public void alterarPedido(int codigoPedido, TipoPedido tipo) throws RegistroNaoEncontradoException, Exception {
    	try {
    		for (Pedido pedido : pedidos) {
    			if (pedido.getCodigo() == codigoPedido && pedido.getSituacao() != tipo) {
    				pedido.setSituacao(tipo);
    			}
    		}			
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
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
			throw new Exception(e.getMessage(), e);
		}
    }
    
    public void alterarPedido(int idCliente, int codigoPedido, TipoPedido tipo) throws RegistroNaoEncontradoException, Exception {
    	try {			
    		for (Pedido pedido : pedidos) {
    			if (pedido.getIdCliente() == idCliente && pedido.getCodigo() == codigoPedido && pedido.getSituacao() != tipo) {
    				pedido.setSituacao(tipo);
    				return;
    			}
    		}
    		throw new RegistroNaoEncontradoException("Pedido");
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
    }
    
    ////PEDIDO
    
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
            throw new Exception(e.getMessage(), e);
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
    		throw new Exception(e.getMessage(), e);
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
            throw new Exception(e.getMessage(), e);
        }
    }
    
    public void cadastrarCliente(Cliente novoCliente) throws RegistroNaoEncontradoException, Exception {
    	try {    		 
    		clientes.add(novoCliente);
    	} catch(Exception e) {
    		throw new Exception(e.getMessage(), e);
    	}
   }
    
    public boolean isClienteJaCadastrado(Usuario usuario) {
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
}
