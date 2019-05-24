package comparators;

import java.util.Comparator;

import lab5.Compra;

public class ComparaPorCliente implements Comparator<Compra> {

	@Override
	public int compare(Compra o1, Compra o2) {
		if (o1.getCliente().equals(o2.getCliente())) {
			return o1.porCliente().compareTo(o2.porCliente());
		}
		return o1.getCliente().compareTo(o2.getCliente());
	}
}
