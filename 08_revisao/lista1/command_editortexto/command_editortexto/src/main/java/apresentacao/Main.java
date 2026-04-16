package apresentacao;

import negocio.Colar;
import negocio.Copiar;
import negocio.Editor;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.setTexto("oi");
        editor.ativarFuncao(new Copiar(editor));
        editor.ativarFuncao(new Colar("ola!", editor));
        System.out.println(editor.getTexto());        
    }
}