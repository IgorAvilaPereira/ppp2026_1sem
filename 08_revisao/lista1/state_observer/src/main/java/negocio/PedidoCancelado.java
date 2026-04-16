package negocio;

public class PedidoCancelado implements Estado {

    @Override
    public Estado progredir() {
        return this;
    }

    @Override
    public Estado regredir() {
        return this;
    }

}
