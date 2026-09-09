package calculodesconto.tiposdesconto;

public class DescontoClienteVIP implements DescontoStrategy{
	
	@Override
	public double aplicarDesconto (double valor) {
		return valor * 0.8; 
	}

}
