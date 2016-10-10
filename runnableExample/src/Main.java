import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        long startA = System.currentTimeMillis();
        System.out.print("Printing 10,000 sets of 2 random numbers without threads. \nStart time: " + startA + "\n");

        theFirstOne();

        long endA = System.currentTimeMillis();
        long totalA = endA - startA;
        System.out.print("\nEnd time: " + endA + "\nTotal time: " + totalA + "\n");

        //THREADS BELOW!!!!

        System.out.println();
        System.out.println("Now lets do that with threads!");

        long startB = System.currentTimeMillis();
        System.out.println("Start time:" + startB);

        theBeggining();

        long endB = System.currentTimeMillis();
        long totalB = endB - startB;
        System.out.print("\nEnd time: " + endB + "\nTotal time: " + totalB + "\n");
    }

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
        int reply1 = x * y + z;
        int reply2 = ((z + x) / y) * z;
        System.out.print(reply1 + ", " + reply2 + ", ");
    }


    public static void theFirstOne(){
        myFirstGo.letsDothis();
    }

    public static void theBeggining(){
        Executor exeuteIt = Executors.newCachedThreadPool();
        myRunnable aRunnable = new myRunnable();
        for (int i = 0; i < 1; i++) {
            exeuteIt.execute(aRunnable);
        }
    }
}


class myRunnable implements Runnable {
    public void run(){
        for (int i = 0; i < 10000; i++) {
            Main.myMathProblem();
        }
    }
}

class myFirstGo {
    public static void letsDothis(){
        for (int j = 0; j < 10000; j++) {
            Main.myMathProblem();
        }
    }
}