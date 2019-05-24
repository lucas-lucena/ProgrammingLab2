package comparators;

import java.util.Comparator;

import lab5.Compra;

public class ComparaPorFornecedor implements Comparator<Compra> {

	@Override
	public int compare(Compra o1, Compra o2) {
		if (o1.getFornecedor().equals(o2.getFornecedor())) {
			return o1.porFornecedor().compareTo(o2.porFornecedor());
		}
		return o1.getFornecedor().compareTo(o2.getFornecedor());
	}

}
