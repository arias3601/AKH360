package getServed;

/**
 * Created by arias on 10/20/16.
 */
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;


public class JSONEchoClient {
    public static void main(String[] args){
        JSONEchoClient theClient = new JSONEchoClient();
        theClient.go();
    }

    private void go() {
        while(true){
            try {
                //Creates a new scanner where the user inputs a message to send to the servlet
                Scanner input = new Scanner(System.in);
                System.out.printf("Please enter a message to send to the servlet: \n");
                String messageForServlet = input.nextLine();

                //The URL location of the servlet it will be communicating with.
                URL url = new URL("http://localhost:8080/hello");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);//allows POST

                //Talk to servlet

                //Converts the message to json
                JSONOutputStream outToServer = new JSONOutputStream(connection.getOutputStream());

                HashMap<String, Object> request = new HashMap<>();
                request.put("status", "To Servlet");
                request.put("message", messageForServlet);

                //Writes the JSON object to the hashMap called request
                outToServer.writeObject(request);

                //Listen from servlet
                JSONInputStream inFromServer = new JSONInputStream(connection.getInputStream());
                HashMap<String, Object> response = (HashMap<String, Object>) inFromServer.readObject();
                if (response.get("status").equals("To Client")) {
                    System.out.println("\nSent Message to Servlet: " + request + " Servlet echo response  " + response + "\n");
                } else {
                    System.out.println("The sent message is not getting a response to the correct location by the server  " + response);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
