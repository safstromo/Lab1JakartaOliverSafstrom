package exception;

import jakarta.ws.rs.WebApplicationException;

public class IdNotFound extends WebApplicationException {

    public IdNotFound(){
        super();
    }
    public IdNotFound(String message){
        super();
    }

}
