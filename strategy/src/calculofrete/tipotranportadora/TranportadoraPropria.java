package calculofrete.tipotranportadora;

public class TranportadoraPropria implements TransportadoraStrategy{
	
	public final double TB = 0.1;
	public final double TD = 0.5;
	public final double TP = 0.2;
	
	private double pesoProduto;
	private double distanciaRota;

	
	
	public TranportadoraPropria(double distanciaRota, double pesoProduto) {
		this.distanciaRota = distanciaRota;
		this.pesoProduto = pesoProduto;
	}


	@Override
	public double calcularFrete() {
		return TB + (distanciaRota * TD) + (pesoProduto * TP);
	}

}
