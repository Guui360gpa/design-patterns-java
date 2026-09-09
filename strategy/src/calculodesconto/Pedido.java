package calculodesconto;

import calculodesconto.tiposdesconto.DescontoStrategy;

public class Pedido {
	private double valor;
	private DescontoStrategy tipoDesconto;
	
	public Pedido (double valor, DescontoStrategy tipoDesconto) {
		this.valor = valor;
		this.tipoDesconto = tipoDesconto;
	}
	
	public void setTipoDesconto (DescontoStrategy tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}
	
	public double calcularValorFinal() {
		return tipoDesconto.aplicarDesconto(valor);
	}
}
