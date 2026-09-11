package observer.sistemapedidos;

public class EstoqueService implements Observer{
    @Override
    public void atualizar(StatusPedido statusPedido) {
        if (statusPedido == StatusPedido.PAGO){
            System.out.println("Item(s) retirados do estoque");
        }
    }
}
