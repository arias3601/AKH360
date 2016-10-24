package MVC;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by arias on 10/21/16.
 */
public class Mostly {
    public HashMap setUp(){
        HashMap<Integer, theCrabs> crabMap = new HashMap<Integer, theCrabs>();
        theCrabs crab1 = new theCrabs(20, "delicious!");
        crabMap.put(1, crab1);

        return crabMap;
    }
}

class theCrabs implements Serializable {
    private int numOfCrabs;
    private String todaysTaste;

    public theCrabs(int numOfCrabs, String todaysTaste) {
        this.numOfCrabs = numOfCrabs;
        this.todaysTaste = todaysTaste;
    }
    public void adder(){
        numOfCrabs++;
    }
    public void remover(){
        numOfCrabs--;
    }

    public int getNumOfCrabs() {
        return numOfCrabs;
    }

    public String getTodaysTaste() {
        return todaysTaste;
    }
}