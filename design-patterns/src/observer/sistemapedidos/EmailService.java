package observer.sistemapedidos;

public class EmailService implements Observer{
    @Override
    public void atualizar(StatusPedido statusPedido) {
        switch (statusPedido){
            case CRIADO -> System.out.println("[Email] Recebemos seu pedido!");
            case PAGO -> System.out.println("[Email] Pagamento confirmado!");
            case ENVIADO -> System.out.println("[Email] Seu pedido foi enviado!");
            case ENTREGUE -> System.out.println("[Email] Pedido entregue, aproveite!");
        }
    }
}
