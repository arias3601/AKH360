package MVC;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by arias on 10/21/16.
 */
public class ManageCrabs {
    public HashMap setUp(){
        HashMap<Integer, theCrabs> crabMap = new HashMap<Integer, theCrabs>();
        theCrabs crab1 = new theCrabs(20, "delicious!");
        crabMap.put(1, crab1);
        return crabMap;
    }
}
