package calculofrete;

import calculofrete.tipotranportadora.TransportadoraStrategy;

public class CalculoFrete {
	
	private double value;
	private TransportadoraStrategy tipoTransportadora;
	
	
	public CalculoFrete(double value, TransportadoraStrategy tipoTransportadora) {
		this.value = value;
		this.tipoTransportadora = tipoTransportadora;
	}
	
	public double getValor() {
		return value;
	}
	
	public void setTipoTransportadora(TransportadoraStrategy tipoTransportadora) {
		this.tipoTransportadora = tipoTransportadora;
	}
	
	public double calcularFrete() {
		return tipoTransportadora.calcularFrete();
	}
	
	public double calcularValorComFrete() {
		return value + tipoTransportadora.calcularFrete();
	}
	
	
	
	

}
