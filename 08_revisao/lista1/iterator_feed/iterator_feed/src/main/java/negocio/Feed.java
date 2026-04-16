package negocio;

import java.time.LocalDateTime;
import java.util.Iterator;

public class Feed implements Iterator<Publicacao> {
    private Publicacao vetPublicacao[];
    private int i;

    public Feed(){
        this.vetPublicacao = new Publicacao[2];
        this.vetPublicacao[0] = new Publicacao("oi", "ola", LocalDateTime.of(2026, 4, 15, 21, 0));
        this.vetPublicacao[1] = new Publicacao("oi", "ola", LocalDateTime.of(2026, 4, 15, 21, 0));
        this.i = 0;
    }

    @Override
    public boolean hasNext() {
        if (i < this.vetPublicacao.length) return true;
        return false;

    }

    @Override
    public Publicacao next() {
        Publicacao publicacao = this.vetPublicacao[this.i];
        this.i++;
        return publicacao;
    }

}
