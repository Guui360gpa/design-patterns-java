package calculofrete;

import calculofrete.tipotranportadora.PAC;
import calculofrete.tipotranportadora.Sedex;
import calculofrete.tipotranportadora.TranportadoraPropria;

public class Main {
	
	public static void main(String[] args) {
		CalculoFrete calculo = new CalculoFrete(1945.00,new TranportadoraPropria(20, 5));
		System.out.println("Valor: " + calculo.getValor());
		System.out.println("Com Transportadora Propria: " + calculo.calcularFrete());
		System.out.println("Total: " + calculo.calcularValorComFrete() + "\n");
		
		calculo.setTipoTransportadora(new Sedex(20, 5));
		System.out.println("Valor: " + calculo.getValor());
		System.out.println("Com Sedex: " + calculo.calcularFrete());
		System.out.println("Total: " + calculo.calcularValorComFrete() + "\n");
		
		calculo.setTipoTransportadora(new PAC(20,5));
		System.out.println("Valor: " + calculo.getValor());
		System.out.println("Com PAC: " + calculo.calcularFrete());
		System.out.println("Total: " + calculo.calcularValorComFrete() + "\n");
	}

}
