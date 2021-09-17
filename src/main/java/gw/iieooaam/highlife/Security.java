package gw.iieooaam.highlife;

import java.util.concurrent.TimeUnit;

public class Security {
    public static void doSecurity(String username, String password){
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
    }
}
