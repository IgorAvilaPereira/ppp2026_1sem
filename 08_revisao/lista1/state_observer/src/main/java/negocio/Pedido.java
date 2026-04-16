package negocio;

import java.util.ArrayList;
import java.util.List;

public class Pedido extends Subject {
    private Cliente cliente;
    private List<Item> itens;
    // strategy
    private FormaPagamento formaPagamento;    
    // estado
    private Estado estado;


    public Pedido(){
        this.itens = new ArrayList<Item>();
        this.estado = new PedidoCriado();
    }

    public void progredir(){
        this.estado = this.estado.progredir();
        this.notifyObservers();
    }

  

    public void regredir(){
        this.estado = this.estado.regredir();
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

    public Estado getEstado() {
        return estado;
    }

    @Override
    protected void notifyObservers() {
        for (Observer observer : vetObserver) {
            observer.update(this);
        }
    }

    

}
