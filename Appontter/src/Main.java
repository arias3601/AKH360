import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppControl theAppcontroler = new AppControl();
        theAppcontroler.mapCommand("add", new AddHandler());
        theAppcontroler.mapCommand("subtract", new SubHandler());
        theAppcontroler.mapCommand("multiply", new MulHandler());
        theAppcontroler.mapCommand("divide", new DivHandler());

        System.out.print("Please enter a command (add, subtract, multiply, or divide): ");
        String theirCommand = scanner.next();

        System.out.print("Please enter a intiger: ");
        int x = scanner.nextInt();
        System.out.print("Please enter another intiger: ");
        int y = scanner.nextInt();
        mathStuff aMathObject = new mathStuff(x, y);
        HashMap<String, Object> mathMap = new HashMap<String, Object>();
        mathMap.put("theMath", aMathObject);

        theAppcontroler.handleIt(theirCommand, mathMap);


    }
}

class mathStuff{
    private int x;
    private int y;

    public mathStuff() {
        this.x = 0;
        this.y = 0;
    }

    public mathStuff(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}





