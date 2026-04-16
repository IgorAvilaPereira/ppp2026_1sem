package negocio;

public abstract class Observer {

    public void update(Pedido pedido) {
        System.out.println("Fui notificado");
    }

}
