package negocio;

public class Copiar extends Command {

    public Copiar(Editor editor){
        super(editor);
    }   

    @Override
    public void execute() {
        System.out.println("copiando conteudo"+this.editor.getTexto());
    }



}
