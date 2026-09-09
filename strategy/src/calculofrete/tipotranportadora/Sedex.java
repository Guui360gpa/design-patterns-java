package calculofrete.tipotranportadora;

public class Sedex implements TransportadoraStrategy{
	
	private final double TB = 15.00;
	private final double TD = 0.05;
	private final double TP = 2.00;
	
	private double pesoProduto;
	private double distanciaRota;
	
	
	public Sedex(double distanciaRota, double pesoProduto) {
		super();
		this.pesoProduto = pesoProduto;
		this.distanciaRota = distanciaRota;
	}

	@Override
	public double calcularFrete() {
		return TB + (distanciaRota * TD) + (pesoProduto * TP);
	}

}
