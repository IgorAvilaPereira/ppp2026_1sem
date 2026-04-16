package negocio;

public abstract class Command { 
    protected Editor editor;

    public Command(Editor editor) {
        this.editor = editor;
    }

    public abstract void execute();

}
