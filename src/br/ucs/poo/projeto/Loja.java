package br.ucs.poo.projeto;

import java.util.ArrayList;
import java.util.Date;

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
	
    public boolean cadastrarFornecedor(Fornecedor novoFornecedor) {
    	 try {    		 
    		 fornecedores.add(novoFornecedor);
    		 return true;
    	 } catch(Exception e) {
    		 return false;
    	 }
    	
    }
    
    public boolean editarFornecedor(int codigo, Fornecedor fornecedorComNovosDados) {
        try {
            Fornecedor fornecedorEncontrado = null;
            for (Fornecedor f : fornecedores) {
                if (f != null && f.getCodigo() == codigo) {
                    fornecedorEncontrado = f;
                    break;
                }
            }

            if (fornecedorEncontrado == null) {
                return false;
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

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean excluirFornecedor(int codigo) {
    	try {
            for (int i = 0; i < fornecedores.size(); i++) {
            	Fornecedor fornecedor = fornecedores.get(i);
            	if (fornecedor != null && fornecedor.getCodigo() == codigo) {
                	if(fornecedor.getProdutos() == null || fornecedor.getProdutos().isEmpty()) {                		
                		fornecedores.remove(fornecedor);
                		return true;
                	}
                }
			}
            
            return false;
        } catch (Exception e) {
            return false;
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
    
    public boolean cadastrarProduto(Produto novoProduto) {
		try {    		 
			produtos.add(novoProduto);
			return true;
		} catch(Exception e) {
			return false;
		}
    }
    
    public boolean editarProduto(String termoBusca, Produto produtoComNovosDados) {
    	try {   
    		ArrayList<Produto> resultados = consultarProdutos(termoBusca);
    	    if (resultados.size() == 0) {
    	        return false;
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
    	    
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editarEstoqueProduto(String termoBusca, Estoque estoqueComNovosdados) {
    	try {
    		ArrayList<Produto> resultados = consultarProdutos(termoBusca);
            if (resultados.size() == 0) {
                return false;
            }
            Produto produtoSelecionado = resultados.get(0);

            produtoSelecionado.getEstoque().setQuantidade(estoqueComNovosdados.getQuantidade());
            produtoSelecionado.getEstoque().setPreco(estoqueComNovosdados.getPreco());
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean excluirProduto(int codigo) {
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
                return false;
            }

            for (Fornecedor fornecedor : fornecedores) {
                if (fornecedor != null) {
                    fornecedor.removerProduto(produtoRemovido);
                }
            }

            return true;

        } catch (Exception e) {
            return false;
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

    public boolean vincularProdutoAFornecedor(Produto p, int codigoFornecedor) {
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
    
    public boolean editarFornecedorProduto(String termoBusca, int codigoNovoFornecedor) {
        try {
            ArrayList<Produto> resultadosProdutos = consultarProdutos(termoBusca);
            if (resultadosProdutos == null || resultadosProdutos.get(0) == null) {
                return false;
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
                return false;
            }

            if (fornecedorAtual != null) {
                fornecedorAtual.removerProduto(produtoSelecionado);
            }

            novoFornecedor.adicionarProduto(produtoSelecionado);

            return true;

        } catch (Exception e) {
            return false;
        }
    }
    
    ////PRODUTO
   
    //PEDIDO
    
    public double calcularTotalItem(ItemPedido itemPedido) {
	    return itemPedido.getPreco() * itemPedido.getQuantidade();
    }
    
    public boolean cadastrarPedido(Integer idCliente, ItemPedido itemPedido) {
		try {    		 
			Pedido novoPedido = new Pedido(idCliente, new Date(), new Date(), TipoPedido.NOVO, itemPedido);
	        pedidos.add(novoPedido);
	        return true;
		} catch(Exception e) {
			return false;
		}
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
    
    ////PEDIDO
    
    //USUARIO
    
    public boolean cadastrarUsuarioAdmin(String login, String senha) {
        try {
            for (Usuario usuario : usuariosAdmin) {
                if (usuario != null && usuario.getUsuario().equals(login)) {
                    return false;
                }
            }

            usuariosAdmin.add(new Usuario(login, senha, TipoUsuario.ADMIN));
            return true;
        } catch (Exception e) {
            return false;
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
    		
    	}
    	
        return null;
    }
 
    public boolean excluirUsuarioAdmin(String user) {
    	try {
    		for (Usuario usuarioAdmin : usuariosAdmin) {
            	if(usuarioAdmin != null && usuarioAdmin.getUsuario().equals(user) && !"admin".equals(user)) {
                	usuariosAdmin.remove(usuarioAdmin);
                    return true;
                }
			}
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean cadastrarCliente(Cliente novoCliente) {
   	 try {    		 
   		 clientes.add(novoCliente);
   		 return true;
   	 } catch(IndexOutOfBoundsException iobe) {
   		 return false;
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
