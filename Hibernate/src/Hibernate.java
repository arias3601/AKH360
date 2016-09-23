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
        //hereWeGo.newCharacters();
        hereWeGo.showCharacters();
        //hereWeGo.modifyCharacter();
        //hereWeGo.deleteCharacter();
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

        //This is the SQL code (HAPPY)
        Query allCharactersQuery = session.createQuery("select c from Character as c order by c.name");

        //NASTY
        //Order by something not in the DataBase - Couldn't find it so It threw an exception and didn't do the rest of the code
        //Query allCharactersQuery = session.createQuery("select c from Character as c order by c.notReal");

        //what if the query is an empty string? - States "unexpected end of subtree" and ends the program
        //Query allCharactersQuery = session.createQuery("");

        //hello world, null, put a bunch of random text after the HQL begining

        //put everything in main

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

        //This is the HQL code (HAPPY)
        Query singleCharacterQuery = session.createQuery("select c from Character as c where c.name='Mario'");

        //NASTY
        //What if the where statement isn't correct? (that person doesn't exisit in the DB) - It sets the singleCharacterQuery to null so it fails
        //Query singleCharacterQuery = session.createQuery("select c from Character as c where c.name='Joe'");

        //What if there is no where clause? - the query does not return a uniqe result and therefore cannot work
        //Query singleCharacterQuery = session.createQuery("select c from Character as c");

        Character mario = (Character)singleCharacterQuery.uniqueResult();

        mario.setName("Wario");

        session.merge(mario);

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
        //HAPPY DIALECT
        config.setProperty("hibernat.dialect", "org.hibernate.dialect.MYSQLDialect");

        //NASTY DIALECT org.hibernate.dialect
        //using Oracle Dialect - It worked... It seems that sense the rest of the hibernate code was for MySQL it was still able to work
        //config.setProperty("hibernat.dialect", "org.hibernate.dialect.Oracle10gDialect");

        //Empty String for Dialect - Again it worked, seems to figure it out itself.
        //config.setProperty("hibernat.dialect", "");

        //No hibernat.dialect property - Yep it still worked, go figure!


        //HAPPY jdbc driver
        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

        //NASTY jdbc driver
        //the driver portion is not set (empty string) - no driver specified so it didn't work
        //config.setProperty("hibernate.connection.driver_class", "");

        //using the oracle driver - couldn't find the driver, but it did try despite being told to use the MySQL dialect earlier
        //config.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");


        //HAPPY url
        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/Java");

        //NASTY url
        //wrong database, but the database exisists - the table characters doesn't exisist in test so it fails
        //config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");

        //the database doesn't exisist - Unknown database so it fails
        //config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/noDataBase");

        //the port isn't used for the database - connecting to the MySQL database in general fails, so it fails
        //config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:7777/Java");

        //empty string for the url - unable to make a jdbc connection do to no url
        //config.setProperty("hibernate.connection.url", "");


        //null or HTTP protocol, Hello World

        //HAPPY username
        config.setProperty("hibernate.connection.username", "purplesp_iUser");

        //NASTY username
        //use a fake username - access denied
        //config.setProperty("hibernate.connection.username", "notReal");

        //use null for the username - It before even attempting as there is a NullPointerException
        //config.setProperty("hibernate.connection.username", null);


        //HAPPY password
        config.setProperty("hibernate.connection.password", "RXZfwSvAQCSf");

        //Nasty password
        //using a fake password - access denied
        //config.setProperty("hibernate.connection.password", "fakePassword");

        //use null for the password - It before even attempting as there is a NullPointerException
        //config.setProperty("hibernate.connection.password", null);

        config.setProperty("hibernate.connection.pool_size", "10");
        config.setProperty("hibernate.connection.autocommit", "true");
        config.setProperty("hibernate.id.new_generator_mappings", "false");
        config.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
        config.setProperty("hibernate.show_sql", "ture");
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