////package ucs.jackson;
////import java.io.BufferedReader;
////import java.io.FileInputStream;
////import java.io.FileWriter;
////import java.io.IOException;
////import java.io.InputStreamReader;
////import java.util.ArrayList;
////
////import com.fasterxml.jackson.databind.ObjectMapper;
////
////import ucs.jackson.excecoes.ErroGravacaoException;
////import ucs.jackson.excecoes.ErroLeituraException;
////
////public class Main {
////	
////	private ObjectMapper mapper;
////	
////	public Main() {
////		this.mapper = new ObjectMapper();
////	}
////	
////	public static void main(String[] args) throws Exception {
////    	
////    	Main m = new Main();
////    	
////        // Criar objetos com referência circular
////        Pessoa2 joao = new Pessoa2("João");
////        Pessoa2 maria = new Pessoa2("Maria");
////        
////        ArrayList<Pessoa2> listaPessoasArrayList = new ArrayList<Pessoa2>();
////        listaPessoasArrayList.add(joao);
////        listaPessoasArrayList.add(maria);
////
////        //joao.setAmigo(maria);
////        //maria.setAmigo(joao);
////        
////        Pessoa2 donald = new Pessoa2("Donald");
////        Pessoa2 huguinho = new Pessoa2("Huguinho");
////        Pessoa2 zezinho = new Pessoa2("Zézinho");
////        Pessoa2 luizinho = new Pessoa2("Luizinho");
////        
////        huguinho.addAmigo(donald);
////        huguinho.addAmigo(luizinho);
////                
////        donald.addAmigo(huguinho);
////        donald.addAmigo(zezinho);
////        donald.addAmigo(luizinho);
////
////        // Serializar para JSON
////        String json = m.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listaPessoasArrayList);
////        System.out.println("JSON serializado:");
////        System.out.println(json);
////
////        // Desserializar de volta para objetos
////        ArrayList<Pessoa2> desserializado = m.mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<ArrayList<Pessoa2>>() {});
////        System.out.println("\nObjeto desserializado:");
////        System.out.println("Nome: " + desserializado.getFirst().getNome());
////        System.out.println("Amigo: " + desserializado.getFirst());
////        //System.out.println("Amigo do amigo: " + desserializado.getFirst().getAmigo().getAmigo().getNome());  // Deve ser João novamente
////   
////        // Serializar para JSON
////        String jsonDonald = m.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(donald);
////        System.out.println("JSON serializado:");
////        System.out.println(jsonDonald);
////        
////     // Desserializar de volta para objetos
////        Pessoa2 donaldDesserializado = m.mapper.readValue(jsonDonald, Pessoa2.class);
////        System.out.println("\nObjeto desserializado:");
////        System.out.println(donaldDesserializado);
////        System.out.println("Amigos:");
////        for(Pessoa2 p : donaldDesserializado.getAmigos()) {
////        	System.out.println(p.getNome());
////        	if(p.getAmigos()!= null && !p.getAmigos().isEmpty()) {
////        		System.out.println("\tAmigos:");
////        		for(Pessoa2 p1 : p.getAmigos()) {
////        			System.out.println("\t" + p1.getNome());
////        		}
////        	}
////        }
////        
////        boolean ok = true;
////        String nomeArquivo = "donald.json";
////        
////        try {
////        	m.gravaJSONPessoa(nomeArquivo, jsonDonald);
////        	m.gravaJSONPessoa("joao.json", json);
////        } catch (ErroGravacaoException e) {
////        	System.out.println(e.getMessage());
////        	ok = false;
////        }
////        
////        if(ok) {
////        	Pessoa2 p = m.leJSONPessoa(nomeArquivo);
////        	System.out.println("Pessoa lida do arquivo " + nomeArquivo);
////        	System.out.println(p);
////        }
////    }
////    
////    public Pessoa2 leJSONPessoa(String nomeArquivo) throws ErroLeituraException {
////    	
////    	String json = null;
////    	Pessoa2 p = null;
////    	try {
////			json = this.leArquivo(nomeArquivo);
////			p = this.mapper.readValue(json, Pessoa2.class);
////		} catch (IOException e) {
////			throw new ErroLeituraException(e);
////		}
////    	return p;
////    }
////    
////    public void gravaJSONPessoa(String nomeArquivo, String json) throws ErroGravacaoException {
////    	try {
////    		this.gravaArquivo(nomeArquivo, json);
////    	} catch (IOException e) {
////    		throw new ErroGravacaoException(e);
////    	}
////    }
////    
////    private String leArquivo(String nomeArquivo) throws IOException {
////    	StringBuilder sb = new StringBuilder();
////    	FileInputStream fis = new FileInputStream(nomeArquivo);
////    	InputStreamReader isr = new InputStreamReader(fis);
////    	BufferedReader br = new BufferedReader(isr);
////    	String linha;
////    	while((linha = br.readLine()) != null) {
////    		sb.append(linha);
////    		sb.append("\n");
////    	}
////    	fis.close();
////    	return sb.toString();
////    }
////    
////    private void gravaArquivo(String nomeArquivo, String texto) throws IOException {
////    	FileWriter fw = new FileWriter(nomeArquivo);
////    	fw.write(texto);
////    	fw.close();
////    }
////}
package trabalho;

