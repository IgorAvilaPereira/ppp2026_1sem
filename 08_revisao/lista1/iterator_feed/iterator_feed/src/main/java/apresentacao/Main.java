package apresentacao;

import negocio.Feed;

public class Main {
    public static void main(String[] args) {
        Feed feed = new Feed();
        while(feed.hasNext()) {
            System.out.println(feed.next().getTexto());
        }
    }
}