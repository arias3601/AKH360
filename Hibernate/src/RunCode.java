import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.*;

public class RunCode {
    private List<Character> characters;
    private ConfigH happyUtility;

    public RunCode() { happyUtility = new ConfigH(); }

    public static void main(String[] args){

        RunCode hereWeGo = new RunCode();
        hereWeGo.newCharacters();
    }

    private void newCharacters() {
        Session session = happyUtility.getCurrentSession();

        //All hibernate actions are done in a transaction
        Transaction transaction = session.beginTransaction();


        //creates 2 characters to be put in the database
        Character spiderMan = new Character();
        spiderMan.setName("Spider Man");
        spiderMan.setAbility("Spider Powers");
        spiderMan.setEnemy("Green Goblin");

        Character mario = new Character();
        mario.setName("Mario");
        mario.setAbility("Fire Balls");
        mario.setEnemy("Bowser");

        //saves each instance to a record in the database
        session.save(spiderMan);
        session.save(mario);
        transaction.commit();
    }


}