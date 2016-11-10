package getServed;

import org.quickconnectfamily.json.*;

import java.io.IOException;
import java.net.*;
import java.util.*;
import java.util.concurrent.TimeUnit;


/**
 * Created by arias on 11/3/16.
 */

public class client {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        client userSide = new client();
        userSide.clinetRun();

    }

    private void clinetRun(){
        try {
            System.out.println("Please insert a number: ");
            Long x = scanner.nextLong();
            System.out.println("Please insert another number: ");
            Long y = scanner.nextLong();

            HashMap<String, Long> numMap = new HashMap<>();
            numMap.put("x", x);
            numMap.put("y", y);

            //wrong server name - server not found
            try {
                URL url = new URL("http://localhost:8080/notAServer");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);

                JSONOutputStream sendToServer = new JSONOutputStream(connection.getOutputStream());
                sendToServer.writeObject(numMap);

                JSONInputStream serverResponse = new JSONInputStream(connection.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            //null - MalformedURLException
            try {
                URL url = new URL(null);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);

                JSONOutputStream sendToServer = new JSONOutputStream(connection.getOutputStream());
                sendToServer.writeObject(numMap);

                JSONInputStream serverResponse = new JSONInputStream(connection.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            //empty String - MalformedURL Exception no protocol
            try {
                URL url = new URL("");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);

                JSONOutputStream sendToServer = new JSONOutputStream(connection.getOutputStream());
                sendToServer.writeObject(numMap);

                JSONInputStream serverResponse = new JSONInputStream(connection.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            //ftp - MalformedURL Exception no protocol
            try {
                URL url = new URL("ftp.metanaito.net");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);

                JSONOutputStream sendToServer = new JSONOutputStream(connection.getOutputStream());
                sendToServer.writeObject(numMap);

                JSONInputStream serverResponse = new JSONInputStream(connection.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            //random site - unknown Host excpetion
            try {
                URL url = new URL("http://www.superRandomWebsiteNeverfound000123");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);

                JSONOutputStream sendToServer = new JSONOutputStream(connection.getOutputStream());
                sendToServer.writeObject(numMap);

                JSONInputStream serverResponse = new JSONInputStream(connection.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            URL url = new URL("http://localhost:8080/mathServelt");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);

            JSONOutputStream sendToServer = new JSONOutputStream(connection.getOutputStream());
            sendToServer.writeObject(numMap);


            //Client closes conection - servlet doesn't do anything with it.
            if (x == 1 && y == 1){
                TimeUnit.SECONDS.sleep(30);
                System.exit(0);
            }

            JSONInputStream serverResponse = new JSONInputStream(connection.getInputStream());
            HashMap<String, Long> responseMap = (HashMap<String, Long>) serverResponse.readObject();

            if (responseMap.get("check") == (long)100) {
                Long sum = (Long)responseMap.get("sum");
                System.out.println("The sum of " + x + " + " + y + " is " + sum);
            } else {
                System.out.println("The sent message is not getting a response to the correct location by the server " +
                        " " + responseMap);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
// close the client after sending, don't return anything from the servlet
