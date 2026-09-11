package observer.carrinhocompras;

public class Main {

    static void main(String[] args) {
        CarrinhoCompras carrinho = new CarrinhoCompras();
        Observer contador = new ContadorProdutos();
        Observer calculador = new CalcularTotal();

        carrinho.inscrever(contador);
        carrinho.inscrever(calculador);

        Produto produto1 = new Produto("Sabonete",3.50,4);
        Produto produto2 = new Produto("Shamppo",13.99,2);
        Produto produto3 =new Produto("Condicionador",22.00,1);

        carrinho.adicionarProdutoNoCarrinho(produto1);
        carrinho.adicionarProdutoNoCarrinho(produto2);
        carrinho.adicionarProdutoNoCarrinho(produto3);
    }
}
