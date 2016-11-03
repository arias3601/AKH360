package MVC;

import java.io.Serializable;

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