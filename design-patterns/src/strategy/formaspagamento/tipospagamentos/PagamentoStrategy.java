package strategy.formaspagamento.tipospagamentos;

import java.math.BigDecimal;

public interface PagamentoStrategy {
	
	BigDecimal aplicarPagamento (BigDecimal value);

}
