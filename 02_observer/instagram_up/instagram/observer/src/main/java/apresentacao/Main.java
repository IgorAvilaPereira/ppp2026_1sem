package apresentacao;

import negocio.Influenciador;
import negocio.Patrocinador;
import negocio.Post;
import negocio.Seguidor;


import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinMustache;
import static io.javalin.rendering.template.TemplateUtil.model;

public class Main {
    public static void main(String[] args) {

        Influenciador chicoBarney = new Influenciador();

            var app = Javalin.create(config -> {
            // config.fileRenderer(new JavalinMustache());       
//            config.staticFiles.add(staticFiles -> {
//                staticFiles.hostedPath = "/";                   // change to host files on a subpath, like '/assets'
//                staticFiles.directory = "/static_files";              // the directory where your files are located;
//                staticFiles.location = Location.CLASSPATH;      // Location.CLASSPATH (jar) or Location.EXTERNAL (file system)
//                staticFiles.precompress = false;                // if the files should be pre-compressed and cached in memory (optimization)
//                staticFiles.aliasCheck = null;                  // you can configure this to enable symlinks (= ContextHandler.ApproveAliases())
//                staticFiles.headers = Map.of(...);              // headers that will be set for the files
//                staticFiles.skipFileFunction = req -> false;    // you can use this to skip certain files in the dir, based on the HttpServletRequest
//                staticFiles.mi    meTypes.add(mimeType, ext);       // you can add custom mimetypes for extensions
//              });            
        }).start(7071);
         
        app.get("/", ctx -> {
            ctx.json("oi");
        });

        app.get("/new_post/{title}", ctx -> {
            chicoBarney.changedState(new Post(ctx.pathParam("title")));
            ctx.json("novo post adicionado, observadores notificados");
        });

         app.get("/add/{nome}", ctx -> {
            chicoBarney.addSubscribe(new Seguidor(ctx.pathParam("nome")));
            ctx.json("{\"message\":\""+ctx.pathParam("nome")+"-adicionado com seguidor\"}");
        });

          app.get("/remove/{i}", ctx -> {
            chicoBarney.removeSubscribe(Integer.parseInt(ctx.pathParam("i")));
            ctx.json("removeu um seguidor");
        });

    
        // Influenciador chicoBarney = new Influenciador();
        // Seguidor igor = new Seguidor("Igor");
        // chicoBarney.addSubscribe(igor);
        // chicoBarney.addSubscribe(new Seguidor("Jaaziel"));
        // chicoBarney.removeSubscribe(igor);
        // chicoBarney.addSubscribe(new Patrocinador());
        // chicoBarney.changedState(new Post("jonas ganhou o bbb"));
    }
}