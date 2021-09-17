package gw.iieooaam.highlife;

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
}
