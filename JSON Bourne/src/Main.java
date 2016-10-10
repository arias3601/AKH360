import org.quickconnectfamily.json.*;
import java.io.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        try {
            File secretProfile = new File("secretProfile.txt");

            FileOutputStream fileOut = new FileOutputStream(secretProfile);
            FileInputStream fileIn = new FileInputStream(secretProfile);

            JSONOutputStream jsonOut = new JSONOutputStream(fileOut);
            JSONInputStream jsonIn = new JSONInputStream(fileIn);

            profile jsonBourne = new profile("Json Bourne", 29, "A threat to all", 10751);

            jsonOut.writeObject(jsonBourne);

            //HashMap parsedProfile = (HashMap)jsonIn.readObject();
            //profile parseBourne = new profile(parsedProfile);
            //System.out.println(parseBourne);



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
