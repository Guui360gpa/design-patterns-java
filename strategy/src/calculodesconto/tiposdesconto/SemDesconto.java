package calculodesconto.tiposdesconto;

public class SemDesconto implements DescontoStrategy{
	
	@Override
	public double aplicarDesconto(double valor) {
		return valor;
	}

}
