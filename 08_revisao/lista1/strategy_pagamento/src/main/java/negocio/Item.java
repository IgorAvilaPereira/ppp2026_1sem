package negocio;

public class Item {
    private Produto produto;
    private int qtde;
    private double precoAtual;

    public Item(Produto produto, int qtde) {
        this.produto = produto;
        this.qtde = qtde;
        this.precoAtual = this.produto.getPreco();
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public double getPrecoAtual() {
        return precoAtual;
    }

    public void setPrecoAtual(double precoAtual) {
        this.precoAtual = precoAtual;
    }

    
    

}
