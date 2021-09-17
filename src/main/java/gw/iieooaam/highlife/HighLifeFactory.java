package gw.iieooaam.highlife;

import gw.iieooaam.peasant.AdvancedWorker;
import gw.iieooaam.peasant.Worker;
import org.apache.commons.lang3.StringUtils;

public class HighLifeFactory {
    public static String doChecksTooImportantToBeDoneByThePeasants(String theChecked, String fileName ){
        if(StringUtils.isBlank(theChecked) && StringUtils.isBlank(fileName)){
            return "Nice try";
        }
        if(StringUtils.isNotBlank(theChecked) && StringUtils.isNotBlank(fileName)){
            return "You cheater";
        }
        if(StringUtils.isNotBlank(theChecked)){
            try {
                Double.parseDouble(theChecked);
            } catch (NumberFormatException nfe) {
                return "Really nice try";
            }
        }
        if(StringUtils.isNotBlank(fileName)&&fileName.contains(".")&&StringUtils.isNotBlank(fileName.substring(0,fileName.lastIndexOf(".")))){
            try {
                Double.parseDouble(fileName.substring(0,fileName.lastIndexOf(".")));
            } catch (NumberFormatException nfe) {
                return "R U testing me?";
            }
        } else {
            return "Do not even try it";
        }
        return null;
    }

    public static boolean requestToWork(String theChecked){
        return Worker.doTheWork(theChecked);
    }

    private static boolean requestToWorkAdvanced(String fileName) {
        return AdvancedWorker.doTheWork(fileName);
    }

    public static boolean findRequestTypeAndDoIT(String theChecked, String fileName) {
        if(StringUtils.isNotBlank(theChecked)){
            return requestToWork(theChecked);
        }
        if(StringUtils.isNotBlank(fileName)){
            return requestToWorkAdvanced(fileName);
        }
        return true;
    }
}
