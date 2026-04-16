package negocio;

import java.time.LocalDateTime;

public class Publicacao {
    private String titulo;
    private String texto;
    private LocalDateTime dataHora;

    public Publicacao(String titulo, String texto, LocalDateTime dataHora) {
        this.titulo = titulo;
        this.texto = texto;
        this.dataHora = dataHora;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    

}
