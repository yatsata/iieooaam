package gw.iieooaam.peasant;

import java.util.ArrayList;

public class Worker {
    public static boolean doTheWork(String theChecked){
        //There are other ways to do it, but are too lame. This is the best one
        var str = String.valueOf(Double.parseDouble(theChecked));
        if(str.endsWith(".0")){
            // bye bye
            str = str.replace(".0","");
        }
        var num = Integer.parseInt(String.valueOf(str.charAt(str.length() -1)));
        // Initial version, later we will ad DB integration
        var least = new ArrayList<>();
        for(int o=1; o <= num; o+=2){
            least.add(o);
        }
        var odd = false;
        if(least.contains(num)==true){
            odd = true;
        } else {
            odd=false;
        }
        return odd;
    }
}
