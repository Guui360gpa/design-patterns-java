package calculodesconto;


import calculodesconto.tiposdesconto.DescontoBlackFriday;
import calculodesconto.tiposdesconto.DescontoClienteVIP;
import calculodesconto.tiposdesconto.SemDesconto;

public class Main {
	
	public static void main(String[] args) {

		Pedido pedido = new Pedido(1000.00,new SemDesconto());
		System.out.println("Sem desconto: R$" + pedido.calcularValorFinal());
		
		pedido.setTipoDesconto(new DescontoClienteVIP());
		System.out.println("Desconto cliente VIP: R$" + pedido.calcularValorFinal());
		
		pedido.setTipoDesconto(new DescontoBlackFriday());
		System.out.println("Desconto Black Friday: R$" + pedido.calcularValorFinal());

	}

}
