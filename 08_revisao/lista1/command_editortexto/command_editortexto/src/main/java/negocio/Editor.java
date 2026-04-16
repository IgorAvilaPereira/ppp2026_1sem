package negocio;

public class Editor {
    private String texto;
    private Command funcao;

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void ativarFuncao(Command command) {
        this.funcao = command;
        this.funcao.execute();
    }

    public String getTexto() {        
        return this.texto;
    }

}
