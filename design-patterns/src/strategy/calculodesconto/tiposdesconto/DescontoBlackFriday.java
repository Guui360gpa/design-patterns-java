package strategy.calculodesconto.tiposdesconto;

public class DescontoBlackFriday implements DescontoStrategy{
	
	@Override
	public double aplicarDesconto (double valor) {
		return valor * 0.5;
	}

}
