package negocio;

public class PedidoPago implements Estado {

    @Override
    public Estado progredir() {
        return new PedidoEnviado();
    }

    @Override
    public Estado regredir() {
        return new PedidoCriado();
    }

}
