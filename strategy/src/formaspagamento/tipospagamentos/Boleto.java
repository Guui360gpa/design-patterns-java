package formaspagamento.tipospagamentos;

import java.math.BigDecimal;

public class Boleto implements PagamentoStrategy{

	@Override
	public BigDecimal aplicarPagamento(BigDecimal value) {
		BigDecimal tax = value.multiply(BigDecimal.valueOf(0.05));
		return value.add(tax);
	}
	
	

}
