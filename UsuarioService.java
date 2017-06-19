package cl.duoc.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "UsuarioService")
public class UsuarioService {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "nombre") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "sumar")
    public int sumar(   @WebParam(name = "uno") int uno
                      , @WebParam(name = "dos") int dos
                    ) {
        return uno + dos;
    }
    
}
