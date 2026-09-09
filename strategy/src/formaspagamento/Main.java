package formaspagamento;

import java.math.BigDecimal;

import formaspagamento.tipospagamentos.Boleto;
import formaspagamento.tipospagamentos.CartaoCredido;
import formaspagamento.tipospagamentos.Pix;

public class Main {
	
	public static void main(String[] args) {
		
		Checkout checkout = new Checkout(new BigDecimal("1590.00"),new Pix());
		System.out.println("Valor Checkout via Pix: R$" + checkout.calcularValorCheckout());
		
		checkout.setTipoPagamento(new CartaoCredido(6));
		System.out.println("Valor Checkout via Cartão de Crédito: R$" + checkout.calcularValorCheckout());
		
		checkout.setTipoPagamento(new Boleto());
		System.out.println("Valor Checkout via Boleto: R$" + checkout.calcularValorCheckout());
	}

}
