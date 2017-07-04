package cl.duoc.servicio;

import cl.duoc.entidad.Categoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@WebService(serviceName = "CategoriaService")
public class CategoriaService {
    
    @PersistenceContext
    EntityManager em;
    
    @WebMethod(action = "crearCategoria")
    public Categoria crearCategoria(@WebParam(name = "categoriaId") Long id, @WebParam(name = "nombreCategoria") String categoria){
        Categoria c = new Categoria();
        c.setId(id);
        c.setCategoria(categoria);
        em.persist(c);
        return c;
    }
    
    @WebMethod(action = "editarCategoria")
    public Categoria editarCategoria(@WebParam(name = "categoriaId") Long id, @WebParam(name = "nombreCategoria") String categoria){
        Categoria c = em.find(Categoria.class, id);
        c.setId(id);
        c.setCategoria(categoria);
        return c;
    }
    
    @WebMethod(action = "eliminarCategoria")
    public boolean eliminarCategoria(@WebParam(name = "categoriaId") Long id){
        Categoria c = em.find(Categoria.class, id);
        em.remove(c);
        return true;
    }
    
    @WebMethod(action = "getCategorias")
    public List<Categoria> getCategorias(){
        TypedQuery<Categoria> query = em.createNamedQuery("Categoria.findAll", Categoria.class);
        return query.getResultList();
    }
}
