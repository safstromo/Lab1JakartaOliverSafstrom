package exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class IdNotFoundMapper implements ExceptionMapper<IdNotFound> {


    @Override
    public Response toResponse(IdNotFound idNotFound) {
        return Response.status(404).entity(idNotFound.getMessage()).build();
    }
}
