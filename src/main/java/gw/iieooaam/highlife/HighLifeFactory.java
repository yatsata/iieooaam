package gw.iieooaam.highlife;

import gw.iieooaam.peasant.Worker;
import org.apache.commons.lang3.StringUtils;

public class HighLifeFactory {
    public static String doChecksTooImportantToBeDoneByThePeasants(String theChecked){
        if(StringUtils.isEmpty(theChecked)){
            return "Nice try";
        }
        try {
            Double.parseDouble(theChecked);
        } catch (NumberFormatException nfe) {
            return "Really nice try";
        }
        return null;
    }

    public static boolean requrestForWork(String theChecked){
        return Worker.doTheWork(theChecked);
    }
}
