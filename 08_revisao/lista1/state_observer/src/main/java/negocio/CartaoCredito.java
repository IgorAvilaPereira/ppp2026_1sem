package negocio;

public class CartaoCredito implements FormaPagamento {

    @Override
    public void invocaFormaDePagamento(Pedido pedido) {
        System.out.println("Realizando o processo de pagamento via cartão de credito.");
    }

    
}