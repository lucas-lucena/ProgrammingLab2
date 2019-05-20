package comparators;

import java.util.Comparator;

import lab5.Compra;

public class ComparaCompra implements Comparator<Compra>{
	
	@Override
	public int compare(Compra o1, Compra o2) {
		if (o1.getNome().equals(o2.getNome())) {
			return o1.getData().compareTo(o2.getData());
		}
		else {
			return o1.getNome().compareTo(o2.getNome());
		}
	}
}