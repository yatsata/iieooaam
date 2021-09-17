package gw.iieooaam.peasant;

public class AdvancedWorker {
    public static boolean doTheWork(String fileName) {
        System.out.print("Doing complex ML operations");
        fileName = fileName.substring(0,fileName.lastIndexOf("."));
        // delegate to someone lower in the ladder
        return Worker.doTheWork(fileName);
    }
}
