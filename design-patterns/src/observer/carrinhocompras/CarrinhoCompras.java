package observer.carrinhocompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras implements Subject{

    private List<Produto> produtos = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();


    @Override
    public void inscrever(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void desinscrever(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers() {
        for (Observer observer : observers){
            observer.atutalizar(produtos);
        }
    }

    public void adicionarProdutoNoCarrinho(Produto produto){
        produtos.add(produto);
        System.out.println("\n[Carrinho] produto adicionado: " + produto.getNome());
        notificarObservers();
    }

    public void removerProdutoDoCarrinho(Produto produto){
        produtos.remove(produto);
        System.out.println("\n[Carrinho] produto removido: " + produto.getNome());
        notificarObservers();
    }
}
