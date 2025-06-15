package br.ucs.poo.projeto;

import java.util.Comparator;

public class ComparatorFornecedor implements Comparator<Fornecedor>{
	@Override
	public int compare(Fornecedor o1, Fornecedor o2) {
		int compNome= o1.getNome().compareTo(o2.getNome());

		if(compNome !=0) {
			return compNome;
		}

			return o1.getCodigo() - o2.getCodigo();

	}

}
