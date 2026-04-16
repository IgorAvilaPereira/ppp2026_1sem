package negocio;

public class PaginaDeContato extends Pagina {

    protected String renderizarCorpo() {
        return """
        <form action='/enviarContato' method='post'>
        Nome: <input type='text' name='nome'> <br>
        Email: <input type='email' name='email'> <br>
        <input type='submit' value='Enviar'>
        """;
    }

}
