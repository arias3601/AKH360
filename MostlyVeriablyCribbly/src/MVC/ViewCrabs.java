package MVC;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by arias on 10/21/16.
 */
public class ViewCrabs {
    Scanner scanner = new Scanner(System.in);
    ControlCrabs getControled = new ControlCrabs();
    public void firstView(HashMap crabMap){
        System.out.println("Please enter a command, type 'Help' to see a list of commands.");
        String input = scanner.nextLine();
        getControled.run(input, crabMap);
    }
    public void helpView(HashMap crabMap){
        System.out.println("Avalabile commands: numCrabs, addCrab, removeCrab, tasteCrab, exit");
        String input = scanner.nextLine();
        getControled.run(input, crabMap);
    }

    public void numCrabView(HashMap crabMap, int numCrabs){
        System.out.println("There are " + numCrabs + " Crabs in the cage.\n Please enter a command to continue.");
        String input = scanner.nextLine();
        getControled.run(input, crabMap);
    }
    public void addCrabView(HashMap crabMap) {
        System.out.println("You have succesfully added a crab to the cage.");
        String input = scanner.nextLine();
        getControled.run(input, crabMap);
    }

    public void removeCrabView(HashMap crabMap) {
        System.out.println("You have succesfully removed a crab to the cage.");
        String input = scanner.nextLine();
        getControled.run(input, crabMap);
    }

    public void tasteCrabView(HashMap crabMap, String taste) {
        System.out.println("You eat the Crab it tastes " + taste);
        String input = scanner.nextLine();
        getControled.run(input, crabMap);
    }

    public void leaveView() {
        System.out.println("Good-bye");
    }

    public void backupView(HashMap crabMap){
        System.out.println("Please enter a valid command. (Enter 'Help' to see a list of commands.");
        String input = scanner.nextLine();
        getControled.run(input, crabMap);
    }





}
