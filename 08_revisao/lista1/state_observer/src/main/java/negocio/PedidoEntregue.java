package negocio;

public class PedidoEntregue implements Estado {

    @Override
    public Estado progredir() {
        return this;
    }

    @Override
    public Estado regredir() {
        return new PedidoEnviado();
    }

}
