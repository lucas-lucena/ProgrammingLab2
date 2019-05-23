package comparators;

import java.util.Comparator;

import lab5.Conta;

public class ComparaConta implements Comparator<Conta> {

	@Override
	public int compare(Conta o1, Conta o2) {
		return o1.getFornecedor().compareTo(o2.getFornecedor());
	}
}