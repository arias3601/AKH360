package MVC;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        ManageCrabs modle = new ManageCrabs();
        HashMap<Integer, theCrabs> crabMap = modle.setUp();
        ControlCrabs getControled = new ControlCrabs();
        getControled.run("", crabMap);
    }
}

 class ControlCrabs {
    public void run(String action, HashMap crabMap){
        theCrabs Crabs = (theCrabs)crabMap.get(1);
        ViewCrabs viewCrabs = new ViewCrabs();
        if (action.contentEquals("Help")){
            viewCrabs.helpView(crabMap);
        } else if (action.contentEquals("numCrabs")){
           int numCrabs =  Crabs.getNumOfCrabs();
            viewCrabs.numCrabView(crabMap, numCrabs);
        } else if (action.contentEquals("addCrab")){
            Crabs.adder();
            viewCrabs.addCrabView(crabMap);
        } else if (action.contentEquals("removeCrab")){
            Crabs.remover();
            viewCrabs.removeCrabView(crabMap);
        } else if (action.contentEquals("tasteCrab")){
            String taste = Crabs.getTodaysTaste();
            viewCrabs.tasteCrabView(crabMap, taste);
        } else if (action.contentEquals("exit")){
            viewCrabs.leaveView();
        } else if (action == null){
            viewCrabs.firstView(crabMap);
        }else {
            viewCrabs.backupView(crabMap);
        }
    }
}
