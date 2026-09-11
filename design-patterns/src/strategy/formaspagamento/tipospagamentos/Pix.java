package strategy.formaspagamento.tipospagamentos;

import java.math.BigDecimal;

public class Pix implements PagamentoStrategy{

	@Override
	public BigDecimal aplicarPagamento(BigDecimal value) {
		return value;
	}
	
	

}
