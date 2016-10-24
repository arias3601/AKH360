package MVC;

import java.util.HashMap;

public class Cribbly {
    public static void run(String action, HashMap crabMap){
        theCrabs Crabs = (theCrabs)crabMap.get(1);
        if(action != null){
            if (action.contentEquals("Help")){
                Veriably.helpView(crabMap);
            } else if (action.contentEquals("numCrabs")){
               int numCrabs =  Crabs.getNumOfCrabs();
                Veriably.numCrabView(crabMap, numCrabs);
            } else if (action.contentEquals("addCrab")){
                Crabs.adder();
                Veriably.addCrabView(crabMap);
            } else if (action.contentEquals("removeCrab")){
                Crabs.remover();
                Veriably.removeCrabView(crabMap);
            } else if (action.contentEquals("tasteCrab")){
                String taste = Crabs.getTodaysTaste();
                Veriably.tasteCrabView(crabMap, taste);
            } else if (action.contentEquals("exit")){
                Veriably.leaveView();
            } else {
                Veriably.backupView(crabMap);
            }
        } else {
            Veriably.firstView(crabMap);
        }
    }

}
