package br.com.sigma.demotest.business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import br.com.sigma.demotest.entity.Noticia;

public class NoticiaBC {
    
    @PersistenceContext
    protected EntityManager em;
    
    @Transactional
    public void add(Noticia noticia) {
        em.persist(noticia);
    }
    
    public List<Noticia> lista() {
        System.out.println("Entrou no BC");
        CriteriaQuery<Noticia> query = em.getCriteriaBuilder().createQuery(Noticia.class);
        query.select(query.from(Noticia.class));
        return em.createQuery(query).getResultList();
    }

}
