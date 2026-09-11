package strategy.formaspagamento.tipospagamentos;

import java.math.BigDecimal;

public class CartaoCredido implements PagamentoStrategy {
	
	private int parcelamento;
	
	public CartaoCredido (int parcelamento) {
		this.parcelamento = parcelamento;
	}

	@Override
	public BigDecimal aplicarPagamento(BigDecimal value) {
		if (parcelamento == 1) {
			return value;
		}else {
			double taxaParcela = (value.doubleValue() / parcelamento) * 0.1;
			double parcela = (value.doubleValue() / parcelamento) + taxaParcela;
			return BigDecimal.valueOf(parcela).multiply(BigDecimal.valueOf(parcelamento));
		}
	}
	
	

}
