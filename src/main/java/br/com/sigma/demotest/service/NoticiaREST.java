package br.com.sigma.demotest.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.sigma.demotest.business.NoticiaBC;
import br.com.sigma.demotest.entity.Noticia;

@Path("noticia")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NoticiaREST {
    
    @Inject
    NoticiaBC noticiaBC;
    
    @POST
    public void create(Noticia noticia) {
        noticiaBC.add(noticia);
    }
    
    @GET
    public List<Noticia> list() {
        return noticiaBC.lista();
    }

}
