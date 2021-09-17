package gw.iieooaam.peasant;

import java.util.ArrayList;
import java.util.List;

public class Worker {
    public static boolean doTheWork(String theChecked){
        //There are other ways to do it, but are too lame. This is the best one
        String str = String.valueOf(Double.parseDouble(theChecked));
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
        return odd;
    }
}
