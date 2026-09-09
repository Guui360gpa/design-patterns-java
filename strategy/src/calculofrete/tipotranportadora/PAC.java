package calculofrete.tipotranportadora;

public class PAC implements TransportadoraStrategy{
	
	public final double TB = 8.00;
	public final double TD = 0.02;
	private final double TP = 1.00;
	
	private double pesoProduto;
	private double distanciaRota;
	
	public PAC(double distanciaRota,double pesoProduto) {
		super();
		this.pesoProduto = pesoProduto;
		this.distanciaRota = distanciaRota;
	}

	@Override
	public double calcularFrete() {
		return TB + (distanciaRota * TD) + (pesoProduto * TP);
	}

}
