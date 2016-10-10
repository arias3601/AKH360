import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.Set;
import javax.annotation.Generated;
import javax.persistence.*;


import java.util.*;

public class Hibernate {
    private List<Character> characters;
    private ConfigH happyUtility;

    public Hibernate() { happyUtility = new ConfigH(); }

    public static void main(String[] args){

        Hibernate hereWeGo = new Hibernate();
        hereWeGo.newCharacters();
        hereWeGo.showCharacters();
        hereWeGo.modifyCharacter();
        hereWeGo.deleteCharacter();
    }

    private void newCharacters() {
        Session session = happyUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Character char1 = new Character();
        char1.setName("Mario");
        char1.setAbility("Fire Balls");
        char1.setEnemy("Bowser");

        session.save(char1);
        transaction.commit();
    }

    private void showCharacters(){
        Session session = happyUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        //NASTY
        //Order by something not in the DataBase - Couldn't find it so It threw an exception and didn't do the rest of the code

        try {
            Query allCharactersQuery = session.createQuery("select c from Character as c order by c.notReal");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //what if the query is an empty string? - States "unexpected end of subtree" and ends the program
        try {
            Query allCharactersQuery = session.createQuery("");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Hello world - unexpected token Hello so it doesn't work, breaks code despite being in a try catch
      /*  try {
            Query allCharactersQuery = session.createQuery("Hello World");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        //null - states that it is ambiguous and prevents the code from working at all. (despite the try catch)
       /* try {
            Query allCharactersQuery = session.createQuery(null);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        //begining is HQL end is not - I causes the error not but, but it still doesn't work, illeagel token
        try {
            Query allCharactersQuery = session.createQuery("select c from Character but I dont understand this");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //This is the SQL code (HAPPY)
        Query allCharactersQuery = session.createQuery("select c from Character as c order by c.name");

        characters = allCharactersQuery.list();
        for (int i = 0; i < characters.size(); i++) {
            System.out.println(characters.get(i).getName());
        }
        System.out.println();
        transaction.commit();
    }

    private void modifyCharacter(){
        Session session = happyUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        //NASTY
        //What if the where statement isn't correct? (that person doesn't exisit in the DB) - It sets the singleCharacterQuery to null so it fails

        try {
            Query singleCharacterQuery = session.createQuery("select c from Character as c where c.name='Joe'");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //What if there is no where clause? - the query does not return a uniqe result and therefore cannot work
        try {
            Query singleCharacterQuery = session.createQuery("select c from Character as c");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //This is the HQL code (HAPPY)
        Query singleCharacterQuery = session.createQuery("select c from Character as c where c.name='Mario'");
        Character beforeName = (Character)singleCharacterQuery.uniqueResult();
        beforeName.setName("Wario");
        session.merge(beforeName);
        transaction.commit();
        showCharacters();
    }

    private void deleteCharacter(){
        Session session = happyUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(i).getName().equals("Wario")){
                session.delete(characters.get(i));
                System.out.println("Wario succesfully removed from system.");
            }
        }
        transaction.commit();

    }
}



// Creates the Characters object
@Entity
@Table(name = "Characters")
class Character {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String ability;
    private String enemy;

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ability='" + ability + '\'' +
                ", enemy='" + enemy + '\'' +
                '}';
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAbility() {
        return ability;
    }
    public void setAbility(String ability) {
        this.ability = ability;
    }
    public String getEnemy() {
        return enemy;
    }
    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }

}


//Configurations
class ConfigH {

    private SessionFactory sessionFactory;

    public ConfigH() {
        Configuration config = new Configuration();
        //NASTY DIALECT org.hibernate.dialect
        //using Oracle Dialect - It worked... It seems that sense the rest of the hibernate code was for MySQL it was still able to work
        try {
            config.setProperty("hibernat.dialect", "org.hibernate.dialect.Oracle10gDialect");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Empty String for Dialect - Again it worked, seems to figure it out itself.
        try {
            config.setProperty("hibernat.dialect", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //No hibernat.dialect property - Yep it still worked, go figure!

        //HAPPY DIALECT
        config.setProperty("hibernat.dialect", "org.hibernate.dialect.MYSQLDialect");

        //NASTY jdbc driver
        //the driver portion is not set (empty string) - no driver specified so it didn't work
        try {
            config.setProperty("hibernate.connection.driver_class", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //using the oracle driver - couldn't find the driver, but it did try despite being told to use the MySQL dialect earlier
        try {
            config.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //HAPPY jdbc driver
        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");


        //NASTY url
        //wrong database, but the database exisists - the table characters doesn't exisist in test so it fails
        try {
            config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //the database doesn't exisist - Unknown database so it fails
        try {
            config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/noDataBase");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //the port isn't used for the database - connecting to the MySQL database in general fails, so it fails
        try {
            config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:7777/Java");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //empty string for the url - unable to make a jdbc connection do to no url
        try {
            config.setProperty("hibernate.connection.url", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Null - null pointer eception
        try {
            config.setProperty("hibernate.connection.url", null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            config.setProperty("hibernate.connection.url", "Hello World");
        } catch (Exception e) {
            e.printStackTrace();
        }


        //HAPPY url
        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/Java");


        //NASTY username
        //use a fake username - access denied
        try {
            config.setProperty("hibernate.connection.username", "notReal");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //use null for the username - It before even attempting as there is a NullPointerException
        try {
            config.setProperty("hibernate.connection.username", null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //HAPPY username
        config.setProperty("hibernate.connection.username", "purplesp_iUser");

        //Nasty password
        //using a fake password - access denied
        try {
            config.setProperty("hibernate.connection.password", "fakePassword");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //use null for the password - It before even attempting as there is a NullPointerException
        try {
            config.setProperty("hibernate.connection.password", null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //HAPPY password
        config.setProperty("hibernate.connection.password", "RXZfwSvAQCSf");

        config.setProperty("hibernate.connection.pool_size", "10");
        config.setProperty("hibernate.connection.autocommit", "true");
        config.setProperty("hibernate.id.new_generator_mappings", "false");
        config.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
        config.setProperty("hibernate.show_sql", "true");
        config.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
        config.setProperty("hibernate.current_session_context_class", "thread");

        //Happy anotation
        config.addAnnotatedClass(Character.class);

        //Nasty anotation
        //no annotation - it can't find the Character class so the code fails

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}