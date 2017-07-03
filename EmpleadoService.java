package cl.duoc.service;

import cl.duoc.entity.Empleados;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@WebService(serviceName = "EmpleadoService")
public class EmpleadoService {

    @PersistenceContext
    EntityManager em;
    
    @WebMethod(action = "crear")
    public Empleados crear(
            @WebParam(name = "nombre") String nombre
            ,@WebParam(name = "edad") Integer edad){
        Empleados e = new Empleados();
        e.setNombre(nombre);
        e.setEdad(edad);
        em.persist(e);
        return e;
    }
    
    @WebMethod(action = "editar")
    public Empleados editar(
            @WebParam(name = "id") Integer id
            , @WebParam(name = "nombre") String nombre
            , @WebParam(name = "edad") Integer edad
    ){
        Empleados e = em.find(Empleados.class, id);
        e.setNombre(nombre);
        e.setEdad(edad);
        return e;
    }
    
    @WebMethod(action = "getEmpleados")
    public List<Empleados> getEmpleados(){
        TypedQuery<Empleados> query = em.createNamedQuery("Empleados.findAll", Empleados.class);
        return query.getResultList();
    }
    
    @WebMethod(action = "eliminar")
    public boolean eliminar(@WebParam(name = "id") Integer id){
        Empleados e = em.find(Empleados.class, id);
        em.remove(e);
        return true;
    }
    
}
