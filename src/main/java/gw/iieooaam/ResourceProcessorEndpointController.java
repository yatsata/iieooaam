package gw.iieooaam;

import com.github.javafaker.Faker;
import gw.iieooaam.highlife.HighLifeFactory;
import gw.iieooaam.highlife.Security;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/find")
public class ResourceProcessorEndpointController {

     //The main service can use ML to determine if the number displayed on picture is odd or even. The only mandatory
     //thing is that the name of the file should be passed to the service and be the same as the number
     //on the picture. The expected format is the filename + the extension - for example 254.jpg
     //Patch is the most logical option here
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/find-is-it-even-or-odd")
    public String findItOut(@QueryParam(value="username") String username,
                            @QueryParam(value="password") String password,
                            @QueryParam(value="theChecked") String theChecked,
                            @QueryParam(value="fileName") String fileName) {
        Security.doSecurity(username, password);
        var highLifeChecks = HighLifeFactory.doChecksTooImportantToBeDoneByThePeasants(theChecked, fileName);
        if(highLifeChecks != null){
            return "{ \n \"theAnswerIz\": \""+highLifeChecks+"\" \n}";
        }
        var result = HighLifeFactory.findRequestTypeAndDoIT(theChecked, fileName);
        // just to be sure they are correct print the credentials
        return "{ \n \"theAnswerIz\": \"maybe is " + (result?"odd":"even") +"\"," +
                "\"authentication\":{\n" +
                " \n \"credentials\": \"" + password + " + " + username+"\"," +
                "\"sameAs\": \"" + new Faker().name().fullName() + "\"\n } \n}" ;
    }

    //Delete is the most logical option here
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