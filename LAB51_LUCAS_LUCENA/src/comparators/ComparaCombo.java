package comparators;

import java.util.Comparator;

import lab5.Produto;

public class ComparaCombo implements Comparator<Produto>{
	
	@Override
	public int compare(Produto o1, Produto o2) {
		if (o1.getNome().equals(o2.getNome())) {
			return o1.getDescricao().compareTo(o2.getDescricao());
		}
		else {
			return o1.getNome().compareTo(o2.getNome());
		}
	}
}