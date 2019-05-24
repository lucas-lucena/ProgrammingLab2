package comparators;

import java.util.Comparator;

import lab5.Compra;

public class ComparaPorData implements Comparator<Compra> {

	@Override
	public int compare(Compra o1, Compra o2) {
		if (o1.getYear().equals(o2.getYear())) {
			if (o1.getMonth().equals(o2.getMonth())) {
				return o1.porData().compareTo(o2.porData());
			}
			return o1.getMonth().compareTo(o2.getMonth());
		}
		return o1.getYear().compareTo(o2.getYear());
	}
}
