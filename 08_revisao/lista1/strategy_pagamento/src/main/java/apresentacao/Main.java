package apresentacao;

import negocio.CartaoCredito;
import negocio.Cliente;
import negocio.Item;
import negocio.Pedido;
import negocio.Pix;
import negocio.Produto;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        pedido.setCliente(new Cliente("Igor"));
        Produto produto = new Produto("Prod1", 1.99, 100);
        Item item = new Item(produto, 2);
        pedido.adicionaItem(item);
        pedido.setFormaPagamento(new Pix());
        pedido.resumoDoPedido();

        // pedido.setFormaPagamento(new CartaoCredito());
        // pedido.realizarPagamento();
        // pedido.resumoDoPedido();

        // System.out.println(produto.getQtdeEstoque());
    }
}