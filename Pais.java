package cl.duoc.service;

import cl.duoc.entity.Countries;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@WebService
public class Pais {
    
    @WebMethod
    public List<Countries> getCountries(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication3PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Countries> q = em.createNamedQuery("Countries.findAll", Countries.class);
        List<Countries> r = q.getResultList();
        return r;
    }
    
}
