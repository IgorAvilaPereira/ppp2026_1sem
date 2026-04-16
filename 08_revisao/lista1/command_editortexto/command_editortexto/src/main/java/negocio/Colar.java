package negocio;

public class Colar extends Command {

    private String conteudo;

    public Colar(String conteudo, Editor editor) {
        super(editor);
        this.conteudo = conteudo;
    }

    @Override
    public void execute() {
        this.editor.setTexto(this.editor.getTexto()+"==="+this.conteudo);
    }

}
