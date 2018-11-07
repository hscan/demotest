package br.com.sigma.demotest.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.sigma.demotest.entity.Noticia;

@Path("noticia")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NoticiaREST {
    
    @PersistenceContext
    protected EntityManager em;
    
    @POST
    @Transactional
    public void create(Noticia noticia) {
        em.persist(noticia);
    }
    
    @GET
    public List<Noticia> list() {
        CriteriaQuery<Noticia> query = em.getCriteriaBuilder().createQuery(Noticia.class);
        query.select(query.from(Noticia.class));
        return em.createQuery(query).getResultList();
    }

}
