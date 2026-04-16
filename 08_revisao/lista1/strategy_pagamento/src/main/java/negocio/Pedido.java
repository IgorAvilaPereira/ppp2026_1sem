package negocio;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<Item> itens;
    // interface
    private FormaPagamento formaPagamento;    

    public Pedido(){
        this.itens = new ArrayList<Item>();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItens() {
        return this.itens;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    // public void setItens(List<Item> itens) {
    //     this.itens = itens;
    // }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void resumoDoPedido() {
        System.out.println("--------------------");
        double total = 0;
        for (Item item : itens) {
            System.out.println(item.getProduto().getDescricao()+";"+item.getPrecoAtual()+";"+item.getQtde());
            total += item.getPrecoAtual() * item.getQtde();
        }
        System.out.println("Total:"+total);
        System.out.println("Forma de Pagamento:"+this.formaPagamento.getClass().getSimpleName());
        System.out.println("-------------------");

    }

    public void adicionaItem(Item item) {
        if (item.getQtde() <= item.getProduto().getQtdeEstoque()) {
            this.itens.add(item);
            item.getProduto().setQtdeEstoque(item.getProduto().getQtdeEstoque() - item.getQtde());
        } else {
            throw new UnsupportedOperationException("Estoque insuficiente....");
        }
    }

    public void realizarPagamento() {
        this.formaPagamento.invocaFormaDePagamento(this);
    }

    

}
