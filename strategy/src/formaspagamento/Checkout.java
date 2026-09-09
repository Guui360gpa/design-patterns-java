package formaspagamento;

import java.math.BigDecimal;

import formaspagamento.tipospagamentos.PagamentoStrategy;

public class Checkout {
	
	private BigDecimal value;
	private PagamentoStrategy tipoPagamento;
	
	
	public Checkout(BigDecimal value,PagamentoStrategy tipoPagamento) {
		this.value = value;
		this.tipoPagamento = tipoPagamento;
	}
	
	public void setTipoPagamento (PagamentoStrategy tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	public BigDecimal calcularValorCheckout() {
		return tipoPagamento.aplicarPagamento(value);
	}
}
