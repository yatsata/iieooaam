package gw.iieooaam;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.concurrent.TimeUnit;

@Path("/find")
public class ResourceProcessorEndpointController {

    //Patch is the most logical option here
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/find-is-it-even-or-odd")
    public String findItOut(@QueryParam(value="username") String username,
                            @QueryParam(value="password") String password,
                            @QueryParam(value="theChecked") String theChecked) {
        //IT is extremely important to provide credentials to such important service
        if(username == null || username == "" || username.equalsIgnoreCase("peasant") ||
           password == null || password == "" || password.equalsIgnoreCase("peasant_password")){
            // A little punishment
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.out.print("Wrong credentials moron");
            }
        }
        // just to be sure they are correct print the credentials
        return "{ \n \"the answer iz\": \"maybe\", \n \"credentials\": \"" + password + username+"\" \n}";
    }
}