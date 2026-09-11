package observer.sistemapedidos;

public class Main {
    static void main(String[] args) {
        Pedido pedido = new Pedido();

        Observer email = new EmailService();
        Observer estoque = new EstoqueService();

        pedido.inscrever(email);
        pedido.inscrever(estoque);

        pedido.adicionarItemNoPedido(new Item("Notebook",1,3500.00));

        pedido.mudarStatus(StatusPedido.PAGO);
        pedido.mudarStatus(StatusPedido.ENVIADO);

        System.out.println("\n--- Desinscrevendo o EstoqueService ---");
        pedido.desinscrever(estoque);

        pedido.mudarStatus(StatusPedido.ENTREGUE);
    }
}
