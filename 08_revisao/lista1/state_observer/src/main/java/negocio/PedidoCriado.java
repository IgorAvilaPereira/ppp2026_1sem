package negocio;

public class PedidoCriado implements Estado {

    @Override
    public Estado progredir() {
        return new PedidoPago();
    }

    @Override
    public Estado regredir() {
        return new PedidoCancelado();
    }

}
