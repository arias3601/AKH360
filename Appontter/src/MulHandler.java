import java.util.HashMap;

public class MulHandler implements Handler{
    public void handleIt(HashMap<String, Object> mathMap){
        mathStuff newMath = (mathStuff)mathMap.get("theMath");
        int x = newMath.getX();
        int y = newMath.getY();
        int results = x * y;
        System.out.println(results);
    }
}
