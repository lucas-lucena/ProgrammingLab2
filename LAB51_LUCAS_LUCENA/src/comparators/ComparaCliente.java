package comparators;

import java.util.Comparator;

import lab5.Cliente;

public class ComparaCliente implements Comparator<Cliente>{
	
	@Override
	public int compare(Cliente o1, Cliente o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
}
	
	
	//(<fornecedor>, <desc_prod>, <data_compra>);