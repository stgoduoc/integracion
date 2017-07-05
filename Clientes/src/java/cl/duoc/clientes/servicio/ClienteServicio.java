package cl.duoc.clientes.servicio;

import cl.duoc.clientes.entidad.Cliente;
import cl.duoc.clientes.entidad.Direccion;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@WebService(serviceName = "ClienteServicio")
public class ClienteServicio {

    @PersistenceContext
    EntityManager em;
    
    @WebMethod(action = "crearCliente")
    public Cliente crearCliente(@WebParam(name = "clienteId") Long id, @WebParam(name = "nombreCliente") String nombre, @WebParam(name = "edad") Integer edad, @WebParam(name = "telefonoMovil") String telefonoMovil){
        Cliente c = new Cliente();
        c.setId(id);
        c.setNombre(nombre);
        c.setTelefonoMovil(telefonoMovil);
        c.setEdad(edad);
        em.persist(c);
        return c;
    }
    
    @WebMethod(action = "editarCliente")
    public Cliente editarCliente(@WebParam(name = "clienteId") Long clienteId, @WebParam(name = "nombreCliente") String nombre, @WebParam(name = "edad") Integer edad){
        Cliente c = em.find(Cliente.class, clienteId);
        c.setNombre(nombre);
        c.setEdad(edad);
        em.persist(c);
        return c;
    }
    
    @WebMethod(action = "agregarDireccionCliente")
    public Cliente agregarDireccionCliente(@WebParam(name = "clienteId") Long clienteId, @WebParam(name = "direccion") String direccion, @WebParam(name = "comuna") String comuna){
        Cliente c = em.find(Cliente.class, clienteId);
        List<Direccion> direccionList = c.getDireccionList();
        Direccion d = new Direccion();
        d.setDireccion(direccion);
        d.setComuna(comuna);
        direccionList.add(d);
        return c;
    }
    
    @WebMethod(action = "eliminarCliente")
    public boolean eliminarCliente(@WebParam(name = "clienteId") Long clienteId){
        Cliente c = em.find(Cliente.class, clienteId);
        em.remove(c);
        return true;
    }
    
    @WebMethod(action = "getClientes")
    public List<Cliente> getClientes(){
        TypedQuery<Cliente> query = em.createNamedQuery("Cliente.findAll", Cliente.class);
        return query.getResultList();
    }
    
}
