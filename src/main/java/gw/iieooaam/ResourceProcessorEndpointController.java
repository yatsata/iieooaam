package gw.iieooaam;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/find")
public class ResourceProcessorEndpointController {

    //Patch is the most logical option here
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/find-is-it-even-or-odd")
    public String findItOut(@QueryParam(value="username") String username,
                            @QueryParam(value="password") String password,
                            @QueryParam(value="theChecked") String theChecked) {
        // just to be sure they are correct print the credentials
        return "{ \n \"the answer iz\": \"maybe\", \n \"credentials\": \"" + password + username+"\" \n}";
    }
}