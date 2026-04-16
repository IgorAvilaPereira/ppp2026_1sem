package apresentacao;

import negocio.CartaoCredito;
import negocio.Cliente;
import negocio.NotificacaoPorEmail;
import negocio.Item;
import negocio.Pedido;
import negocio.Pix;
import negocio.Produto;
import negocio.NotificacaoPorSMS;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        pedido.setCliente(new Cliente("Igor", "igor.pereira@riogrande.ifrs.edu.br", "539999999"));
        Produto produto = new Produto("Prod1", 1.99, 100);
        Item item = new Item(produto, 2);
        pedido.adicionaItem(item);
        pedido.setFormaPagamento(new Pix());
        pedido.addObserver(new NotificacaoPorEmail());
        pedido.addObserver(new NotificacaoPorSMS());
        pedido.resumoDoPedido();
        pedido.progredir();
        pedido.progredir();
        pedido.regredir();
        pedido.regredir();
        pedido.progredir();

        System.out.println(pedido.getEstado().getClass().getSimpleName());

        // pedido.setFormaPagamento(new CartaoCredito());
        // pedido.realizarPagamento();
        // pedido.resumoDoPedido();

        // System.out.println(produto.getQtdeEstoque());
    }
}