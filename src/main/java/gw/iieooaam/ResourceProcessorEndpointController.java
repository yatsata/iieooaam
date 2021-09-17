package gw.iieooaam;

import com.github.javafaker.Faker;
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
        if(StringUtils.isEmpty(theChecked)){
            return "Nice try";
        }
        double d = 7;
        try {
            d = Double.parseDouble(theChecked);
        } catch (NumberFormatException nfe) {
            return "Really nice try";
        }
        //There are other ways to do it, but are too lame. This is the best one
        String str = String.valueOf(d);
        if(str.endsWith(".0")){
            // bye bye
            str = str.replace(".0","");
        }
        int num = Integer.parseInt(String.valueOf(str.charAt(str.length() -1)));
        // Initial version, later we will ad DB integration
        List<Integer> least = new ArrayList<>();
        for(int o=1; o <= num; o+=2){
            least.add(o);
        }
        boolean odd;
        if(least.contains(num)==true){
            odd = true;
        } else {
            odd=false;
        }
        // just to be sure they are correct print the credentials
        return "{ \n \"theAnswerIz\": \"maybe is " + (odd ?"odd":"even") +"\"," +
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