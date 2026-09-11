package observer.sistemapedidos;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Subject{

    private List<Item> itens;
    private StatusPedido statusPedido;
    private List<Observer> observers = new ArrayList<>();

    public Pedido() {
        this.itens = new ArrayList<>();
        this.statusPedido = StatusPedido.CRIADO;
    }


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
            observer.atualizar(statusPedido);
        }
    }

    public void mudarStatus(StatusPedido novoStatus){
        this.statusPedido = novoStatus;
        System.out.printf("Status do Pedido modificado para: %s",novoStatus);
        notificarObservers();
    }

    public void adicionarItemNoPedido(Item item){
        itens.add(item);
    }

    public void removerItemDoPedido(Item item){
        itens.remove(item);
    }
}
