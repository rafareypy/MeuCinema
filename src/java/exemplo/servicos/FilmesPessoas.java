/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.servicos;

import com.google.gson.Gson;
import exemplo.modelo.Filme;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author TIERRA CHAQUEÑA
 */
@Path("filmes")
public class FilmesPessoas {

    private List<Filme> filmes ;

    /**
     * Creates a new instance of FilmesPessoas
     */
    public FilmesPessoas() {
        filmes = new LinkedList<Filme>();
        filmes.add(new Filme(1, "titulo 1", "blña bla", "123", "12:50", "adorocinema"));
        filmes.add(new Filme(1, "titulo 2", "blña bla", "456", "12:50", "adorocinema"));
        filmes.add(new Filme(1, "titulo 3", "blña bla", "789", "12:50", "adorocinema"));
        filmes.add(new Filme(1, "titulo 4", "blña bla", "1011", "12:50", "adorocinema"));
        filmes.add(new Filme(1, "titulo 5", "blña bla", "1213", "12:50", "adorocinema"));
        
    }

    /**
     * Retrieves representation of an instance of exemplo.servicos.FilmesPessoas
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        Gson gson = new Gson();        
        return gson.toJson(filmes);
    }

    @Path("{filmeId}")
    @GET
    @Produces("application/json")
    public String getFilme(@PathParam("filmeId") String id) {
         Gson gson = new Gson();
        for (Filme filme : filmes) {
            if(filme.getId().equals(Integer.valueOf(id))){               
                return gson.toJson(filme);
            }
        }
        
        return gson.toJson(null);
    }
    
    
    /**
     * PUT method for updating or creating an instance of FilmesPessoas
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
