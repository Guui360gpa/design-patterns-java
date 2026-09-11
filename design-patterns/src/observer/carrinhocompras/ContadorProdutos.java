package observer.carrinhocompras;

import java.util.List;

public class ContadorProdutos implements Observer{
    @Override
    public void atutalizar(List<Produto> produtos) {
        int tot = produtos.stream()
                .mapToInt(Produto::getQuantidade)
                .sum();
        System.out.printf("[Contador Itens] Quantidade de itens no carrinho: %d (tipos diferentes): %d\n",tot,produtos.size());
    }
}
