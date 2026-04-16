package apresentacao;

import io.javalin.Javalin;
import negocio.PaginaClientes;
import negocio.PaginaDeContato;
import negocio.PaginaInicial;

public class Main {
    public static void main(String[] args) {
        // PaginaInicial paginaInicial = new PaginaInicial();
        // PaginaDeContato paginaDeContato = new PaginaDeContato();
        // System.out.println(paginaDeContato.renderizar());

        var app = Javalin.create(config -> {
            config.routes.get("/", ctx -> ctx.html(new PaginaInicial().renderizar()));
            config.routes.get("/contato", ctx -> ctx.html(new PaginaDeContato().renderizar()));
            config.routes.get("/clientes", ctx -> ctx.html(new PaginaClientes().renderizar()));
        }).start(7070);
    }
}