package observer.carrinhocompras;

import java.util.List;

public class CalcularTotal implements Observer{

    @Override
    public void atutalizar(List<Produto> produtos) {
        double tot = produtos.stream()
                .mapToDouble(Produto::getSubTotal)
                .sum();
        System.out.printf("[Calculadora Total] Valor total do carrinho: R$ %.2f\n",tot);
    }
}
