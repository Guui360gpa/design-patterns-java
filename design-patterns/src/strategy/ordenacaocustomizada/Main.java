package strategy.ordenacaocustomizada;

import java.util.ArrayList;
import java.util.List;

import strategy.ordenacaocustomizada.tipoordenacao.OrdemCrescente;
import strategy.ordenacaocustomizada.tipoordenacao.OrdemDecrescente;

public class Main {
	
	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<>(List.of(5, 2, 8, 1, 9, 3));
		
		OrdenadorDeLista ordenador = new OrdenadorDeLista(new OrdemCrescente());
		ordenador.ordenar(numeros);
		System.out.println("Crescente: " + numeros);
		
		ordenador.setTipoOrdenacao(new OrdemDecrescente());
		ordenador.ordenar(numeros);
		System.out.println("Decrescente: " + numeros);
		
	}

}
