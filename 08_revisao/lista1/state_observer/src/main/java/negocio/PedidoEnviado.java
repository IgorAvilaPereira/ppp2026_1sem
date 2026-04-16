package negocio;

public class PedidoEnviado implements Estado {

    @Override
    public Estado progredir() {
        return new PedidoEntregue();
    }

    @Override
    public Estado regredir() {
        return new PedidoPago();
    }

}
