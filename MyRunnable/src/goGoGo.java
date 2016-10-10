import java.util.concurrent.*;

public class goGoGo {

    public static void main(String[] args) {
        for (int runCount = 1; runCount < 5; runCount++){
            letsGo();
        }
    }

    public static void letsGo(){
        Executor executeIt = Executors.newCachedThreadPool();
        for (int threadCnt = 0; threadCnt < 3; threadCnt++){
            myRunnable aRunnable = new myRunnable();
            executeIt.execute(aRunnable);
        }
        try {
           Thread.sleep(1);
            System.out.println("Done Sleeping");
            myRunnable2 aRunnable2 = new myRunnable2();
            executeIt.execute(aRunnable2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class myRunnable implements Runnable {
    public void run(){
        for (int i = 0; i < 3; i++){
            System.out.println("First Run's Thread id: " +Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class myRunnable2 implements Runnable {
    public void run(){
        for (int i = 0; i < 3; i++){
            System.out.println("Second Run's Thread id: " +Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}