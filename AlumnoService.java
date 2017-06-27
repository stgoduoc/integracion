package cl.duoc.service;

import cl.duoc.entity.Alumnos;
import javax.jws.WebService;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@WebService(serviceName = "AlumnoService")
@Stateless
public class AlumnoService {
    
    @PersistenceContext
    private EntityManager em;

    private EntityManager getEntityManager() {
        return em;
    }
    
    @WebMethod
    public List<Alumnos> getAlumnos(){
        EntityManager em = getEntityManager();
        TypedQuery<Alumnos> query = em.createNamedQuery("Alumnos.findAll", Alumnos.class);
        return query.getResultList();
    }
    
    @WebMethod
    public Alumnos editarAlumno(Integer id, String nombre, String apellido) {
        EntityManager em = getEntityManager();
        Alumnos alumno = em.find(Alumnos.class, id);
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        return alumno;
    }
    
    @WebMethod
    public Alumnos crearAlumno(String nombre, String apellido){
        EntityManager em = getEntityManager();
        Alumnos alumno = new Alumnos();
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        em.persist(alumno);
        return alumno;
    }
    
    @WebMethod
    public boolean borrarAlumno(Integer id){
        EntityManager em = getEntityManager();
        Alumnos alumno = em.find(Alumnos.class, id);        
        em.remove(alumno);        
        return true;
    }
    
}
