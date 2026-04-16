package negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

public class PaginaClientes extends Pagina {

    @Override
    protected String renderizarCorpo() {
        String html  = "";

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "postgres";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to PostgreSQL!");
            String sql = "SELECT * FROM cliente";
            PreparedStatement instrucao = conn.prepareStatement(sql);
            ResultSet rs = instrucao.executeQuery();
            html += "<ol>";
            while (rs.next()) {
                html += "<li>"+rs.getString("nome")+"</li>";
            }
            html += "</ol>";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return html;

    }

    protected String renderizarCabecalho() {
        return "<header> <h1>clientes </h1> </header>";
    }

}
