import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
    static List<Integer> listOfNumbers = new ArrayList<Integer>();
    static List<Integer> listOfNumbers2 = new ArrayList<Integer>();
    static List<Integer> listOfNumbers3 = new ArrayList<Integer>();
    static List<Integer> listOfNumbers4 = new ArrayList<Integer>();
    static String token = "I'm a token";
    static String token1 = "I'm a token2";
    static String token2 = "I'm a token3";
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++){
            int x = createNumber();
            listOfNumbers.add(x);
            listOfNumbers3.add(x);
        }
        System.out.print("HAPPY PATH \n");
        System.out.print("EXECUTOR \n");
        theExecutor();
        System.out.print("\nTHREADER \n");
        theThreader();

        System.out.print("\n\nNASTY PATH \n");

        System.out.println("\nRACE CONDTIONS\n");
        theRaceThreader();
        System.out.println("LIST 1\n" + listOfNumbers + "\n");
        System.out.println("LIST 2\n" + listOfNumbers2);

        System.out.println("\nProper Sync\n");
        theLockThreader();

        System.out.println("LIST 3\n" + listOfNumbers3 + "\n");
        System.out.println("LIST 4\n" + listOfNumbers4);


        System.out.println("\nLOCK CONDTIONS\n");
        lockit();
    }
    //MATH
    public static int createNumber(){
        int min = 1;
        int max = 100;
        int aNumber = min + (int)(Math.random() * max);
        return aNumber;
    }
    public static void myMathProblem(){
        int x = createNumber();
        int y = createNumber();
        int z = createNumber();
        int reply = x * y + z;
        System.out.print(reply + ", ");
    }



    //CODE
    public static void theThreader() {
        for (int i = 0; i < 3; i++) {
            myRunnable aRunnable = new myRunnable();
            Thread myThread = new Thread(aRunnable);
            myThread.start();
        }
        //Levae it empty - doesnt run
        try {
            Thread myNullThread = new Thread();
            myNullThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void theExecutor(){
        Executor exeuteIt = Executors.newCachedThreadPool();
        myRunnable bRunnable = new myRunnable();
        for (int i = 0; i < 3; i++) {
            exeuteIt.execute(bRunnable);
        }
        //Null - null pointer exception
        try {
            exeuteIt.execute(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    //RACE CONDITION - Really intresting things happen. I have gotten the numbers to transfer succefully, all 0 on both lists, some zeros on the second list, the second list to be empty and more.
    public static void theRaceThreader(){
        startRace startRunnable = new startRace();
        Thread startThread = new Thread(startRunnable);

        updateRace updateRunnable = new updateRace();
        Thread updateThread = new Thread(updateRunnable);
        startThread.start();
        updateThread.start();


    }

    public static void getRunning(int x){
        listOfNumbers2.add(listOfNumbers.get(x));
    }

    public static void getRacing(int x){
        listOfNumbers.set(x, 0);
    }






    //SYNC
    public static void theLockThreader(){
        startRace2 startRunnable2 = new startRace2();
        Thread startThread2 = new Thread(startRunnable2);

        updateRace2 updateRunnable2 = new updateRace2();
        Thread updateThread2 = new Thread(updateRunnable2);
        startThread2.start();
        updateThread2.start();

    }

    public static void getRunning2(int x){
        listOfNumbers4.add(listOfNumbers3.get(x));
    }

    public static void getRacing2(int x){ listOfNumbers3.set(x, 0);
    }


    //CROSS LOCK
     public static void lockit(){
        Executor oneTwoEx = Executors.newCachedThreadPool();
        Executor twoOneEx = Executors.newCachedThreadPool();

        oneTwo oneTwoGo = new oneTwo();
        twoOne twoOneGo = new twoOne();

        oneTwoEx.execute(oneTwoGo);
        twoOneEx.execute(twoOneGo);
    }




}





//REGULAR
class myRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 3; i++) {
            Main.myMathProblem();
        }
    }
}





//RACE
class startRace implements Runnable {
    public void run(){
        //to produce a more abvious example take this out.... Don't ask why it just works sometimes...
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int x = 0; x < 100; x++) {
            Main.getRunning(x);
        }
    }
}

class updateRace implements Runnable {
    public void run(){
        for (int x = 0; x < 100; x++) {
            Main.getRacing(x);
        }
    }
}





//FOR SYNC

class startRace2 implements Runnable {
    public void run(){
      synchronized (Main.token) {
            System.out.println("GO GO GO");
            for (int x = 0; x < 100; x++) {
                Main.getRunning2(x);
            }
        }
    }
}

class updateRace2 implements Runnable {
    public void run(){
        synchronized (Main.token) {
            System.out.println("UPDATE");
            for (int x = 0; x < 100; x++) {
                Main.getRacing2(x);
            }
        }
    }
}

class oneTwo implements Runnable {
    public void run(){

        synchronized (Main.token1) {
            System.out.println("OneTwo: Ive got token 1!");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Main.token2){
                System.out.println("OneTwo: Ive got token 2!");
            }
        }
    }
}

class twoOne implements Runnable {
    public void run(){
        synchronized (Main.token2) {
            System.out.println("TwoOne: Ive got token 2!");
            synchronized (Main.token1){
                System.out.println("TwoOne: Ive got token 1!");
            }
        }
    }
}