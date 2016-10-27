package MVC;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Mostly setUp = new Mostly();
        HashMap<Integer, theCrabs> crabMap = setUp.setUp();
        ControlCrabs getControled = new ControlCrabs();
        getControled.run(null, crabMap);
    }
}

 class ControlCrabs {
    public void run(String action, HashMap crabMap){
        theCrabs Crabs = (theCrabs)crabMap.get(1);
        ViewCrabs viewCrabs = new ViewCrabs();
        if(action != null){
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
            } else {
                viewCrabs.backupView(crabMap);
            }
        } else {
            viewCrabs.firstView(crabMap);
        }
    }

}
