package MVC;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Mostly setUp = new Mostly();
        HashMap<Integer, theCrabs> crabMap = setUp.setUp();
        Cribbly.run(null, crabMap);
    }
}
