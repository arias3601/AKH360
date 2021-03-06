package getServed;

import org.quickconnectfamily.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "mathServelt", urlPatterns = {"/mathServelt"})
public class Server extends HttpServlet{
    protected void doPost(HttpServletRequest numMath, HttpServletResponse response) throws ServletException,
            IOException {

        System.out.println("Arrival");

        JSONInputStream clientInput = new JSONInputStream(numMath.getInputStream());
        JSONOutputStream sendToClient = new JSONOutputStream(response.getOutputStream());

        HashMap<String, Long> mathMap = null;
        try {
            mathMap = (HashMap) clientInput.readObject();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Long x = (Long)mathMap.get("x");
        Long y = (Long)mathMap.get("y");
        Long sum = (Long)x + (Long)y;
        mathMap.put("sum", sum);
        mathMap.put("check", (long)100);


        //Server never sends anything back - client gets a SocketException and throws errors and gives up (after a
        // couple seconds)
        if (x == 0 && y == 0){
            System.exit(0);
        }

        try {
            sendToClient.writeObject(mathMap);
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("FAIL");
        }
        System.out.println("Depart");

    }
    protected void doGet(HttpServletRequest numMath, HttpServletResponse response) throws ServletException, IOException {
        doPost(numMath,response);
    }
}
