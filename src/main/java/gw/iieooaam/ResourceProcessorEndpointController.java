package gw.iieooaam;

import com.github.javafaker.Faker;
import gw.iieooaam.highlife.HighLifeFactory;
import gw.iieooaam.highlife.Security;
import gw.iieooaam.peasant.Worker;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;
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
        Security.doSecurity(username, password);
        String highLifeChecks = HighLifeFactory.doChecksTooImportantToBeDoneByThePeasants(theChecked);
        if(highLifeChecks != null){
            return "{ \n \"theAnswerIz\": \""+highLifeChecks+"\" \n}";
        }
        boolean result = Worker.doTheWork(theChecked);
        // just to be sure they are correct print the credentials
        return "{ \n \"theAnswerIz\": \"maybe is " + (result?"odd":"even") +"\"," +
                "\"authentication\":{\n" +
                " \n \"credentials\": \"" + password + " + " + username+"\"," +
                "\"sameAs\": \"" + new Faker().name().fullName() + "\"\n } \n}" ;
    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/sum-em")
    public String sumTwoThings(@QueryParam("first") String first, @QueryParam("second") String second){
        if(StringUtils.isEmpty(first) || StringUtils.isEmpty(second)) {
            Faker faker = new Faker();
            return faker.chuckNorris().fact();
        }
        return first.toString() + second.toString();
    }

}