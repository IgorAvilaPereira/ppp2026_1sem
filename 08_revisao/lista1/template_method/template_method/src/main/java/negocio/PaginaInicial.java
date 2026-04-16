package negocio;

public class PaginaInicial extends Pagina {

    @Override
    protected String renderizarCorpo() {
        return "Amigo estou aqui! <a href='/contato'>Contato</a>";
    }

}
