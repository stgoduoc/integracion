package cl.duoc.servicio;

import cl.duoc.entidad.Categoria;
import cl.duoc.entidad.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@WebService(serviceName = "ProductoService")
public class ProductoService {

    @PersistenceContext
    EntityManager em;
    
    @WebMethod(action = "crearProducto")
    public Producto crearProducto(@WebParam(name = "productoId") Long id, @WebParam(name = "nombreProducto") String producto, @WebParam(name = "precio") Long precio, @WebParam(name = "imagen") String imagen, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "categoriaId") Long categoriaId){
        Producto p = new Producto();
        p.setId(id);
        p.setProducto(producto);
        p.setPrecio(precio);
        p.setImagen(imagen);
        p.setDescripcion(descripcion);
        Categoria categoria = em.find(Categoria.class, categoriaId);
        p.setCategoria(categoria);
        em.persist(p);
        return p;
    }
    
    @WebMethod(action = "editarProducto")
    public Producto editarProducto(@WebParam(name = "productoId") Long id, @WebParam(name = "nombreProducto") String producto, @WebParam(name = "precio") Long precio, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "categoriaId") Long categoriaId){
        Producto p = em.find(Producto.class, id);        
        p.setProducto(producto);
        p.setPrecio(precio);
        p.setDescripcion(descripcion);
        Categoria categoria = em.find(Categoria.class, categoriaId);
        p.setCategoria(categoria);
        return p;
    }
    
    @WebMethod(action = "eliminarProducto")
    public boolean eliminarProducto(@WebParam(name = "productoId") Long id){
        Producto p = em.find(Producto.class, id);
        em.remove(p);
        return true;
    }
    
    @WebMethod(action = "getProductos")
    public List<Producto> getProductos(){
        TypedQuery<Producto> query = em.createNamedQuery("Producto.findAll", Producto.class);
        return query.getResultList();
    }
    
    @WebMethod(action = "getProductoById")
    public Producto getProductoById(@WebParam(name = "productoId") Long id){
        TypedQuery<Producto> query = em.createNamedQuery("Producto.findById", Producto.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
