package negocio;

public class NotificacaoPorSMS extends Observer {

    public void update(Pedido pedido) {
        System.out.println(pedido.getCliente().getNome() + ": foi notificado por sms");
    }

}
