package getServed;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by Keoni Aledo Jr on 10/20/16.
 */

//Each of these is a servlet that handles that specific URL
@WebServlet(name = "ExampleServlet", urlPatterns = {"/hello"})
public class ExampleServelt extends HttpServlet {
    // When server responds to user
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //Message that appears when the server receives a message from the client
        System.out.println("The server has received a new message!");


        //Receive message from client
        JSONInputStream inFromClient = new JSONInputStream(request.getInputStream());
        //Respond to client
        JSONOutputStream outToClient = new JSONOutputStream(response.getOutputStream());

        //Stores the received information from the client in the hashMap
        HashMap<String, Object> dataMap = null;
        try {
            dataMap = (HashMap) inFromClient.readObject();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //Displays Received Message - The data sent from the client - and where from.
        System.out.println("Received Message:" + dataMap + " from Keoni's client");
        dataMap.put("status", "To Client");
        try {
            outToClient.writeObject(dataMap);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Prints that it sent the echo message that was received back to the client
        System.out.println("just sent " + dataMap);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

