package negocio;

public abstract class Pagina {

    // template Method
    public final String renderizar(){
        String html = "<html> <head> <style> body { background-color: yellow} </style> </head><body>"+this.renderizarCabecalho();
        html+= this.renderizarCorpo()+"</body>";
        html+= this.renderizarRodape()+"</html>";

        return html;
    }

    protected abstract String renderizarCorpo();

    private String renderizarRodape() {
        return "<footer> Igor Corporation LTDA - <a href='mailto:igor.pereira@riogrande.ifrs.edu.br'> mailto:igor.pereira@riogrande.ifrs.edu.br </a> </footer>";
    }

    protected String renderizarCabecalho() {
        return "<header> oi </header>";
    }

}
