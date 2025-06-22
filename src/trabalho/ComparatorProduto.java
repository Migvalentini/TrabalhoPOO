package trabalho;

import java.util.Comparator;

public class ComparatorProduto implements Comparator<Produto> {
	
	@Override
	public int compare(Produto o1, Produto o2) {
		int compNome= o1.getNome().compareTo(o2.getNome());

		if(compNome !=0) {
			return compNome;
		}
		
		return o1.getCodigo() - o2.getCodigo();
	}

}