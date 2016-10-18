import org.quickconnectfamily.json.*;
import java.io.*;
import java.util.HashMap;

public class Main {

    //write or read to files you don't have permisions, what if it isn't a JSON file,

    public static void main(String[] args) {
        try {
            //trying used locked.txt - Doesn't work and runs the last thing that worked.
            File secretProfile = new File("secretProfile.txt");

            FileOutputStream fileOut = new FileOutputStream(secretProfile);
            FileInputStream fileIn = new FileInputStream(secretProfile);

            JSONOutputStream jsonOut = new JSONOutputStream(fileOut);
            JSONInputStream jsonIn = new JSONInputStream(fileIn);

            //JSON out null won't work period
            //JSONOutputStream jsonOut2 = new JSONOutputStream(null);

            //JSON IN null - null pointer exception
            try {
                JSONInputStream jsonIn2 = new JSONInputStream(null);
            } catch (Exception e) {
                e.printStackTrace();
            }

            profile jsonBourne = new profile("Json Bourne", 28, "A threat to all", 10751);

            jsonOut.writeObject(jsonBourne);

            //Changed the read in to Hello World (with no over ride) game an Unexpected Character H at postion 0 error, doesn't work sesne it isn't in JSON format



            HashMap parsedProfile = (HashMap) jsonIn.readObject();
            profile parseBourne = new profile(parsedProfile);
            System.out.println(parseBourne);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



class profile implements Serializable {
    private String name;
    private int age;
    private String description;
    private int idNumber;

    public profile() {
    }

    public profile(String name, int age, String description, int idNumber) {
        this.name = name;
        this.age = age;
        this.description = description;
        this.idNumber = idNumber;
    }

    public profile(HashMap profile){
        this.name = (String)profile.get("name");
        Long longAge = (Long) profile.get("age");
        this.age = longAge.intValue();
        this.description = (String) profile.get("description");
        Long longIdNumber =  (Long) profile.get("idNumber");
        this.idNumber = longIdNumber.intValue();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "profile{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", idNumber=" + idNumber +
                '}';
    }
}
