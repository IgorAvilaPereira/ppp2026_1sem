package negocio;

public class Pix implements FormaPagamento {

    @Override
    public void invocaFormaDePagamento(Pedido pedido) {
        System.out.println("Realizando o processo de pagamento via pix");
    }

}
