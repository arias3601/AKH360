import java.awt.*;
import java.util.*;
import java.util.Scanner;
import javax.swing.*;

  class theInterface {
    private JFrame basicFrame;
    private JPanel basicPanel;
    private JButton b1;
    private JLabel testLabel;
  }



public class pokemon_Asher_Edition {
public static void main(String[] args) {
Scanner input = new Scanner(System.in);

  JFrame basicFrame = new JFrame("Pokemon Ash & James Edition");
  basicFrame.setVisible(true);
  basicFrame.setSize(600,400);
  basicFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  JPanel basicPanel = new JPanel();
  basicPanel.setBackground(Color.GRAY);

  JButton b1 = new JButton("Test");



    //Preset variables
    String question;
    String questionCheck;
    String check;
    int checkInt;
    int charID = 0;

    //Sets party
    String poke1 = "";
    int pokeID = 0;


    //Welcome Sequence
    //System.out.println();
    JLabel testLabel = new JLabel("Welcome to the world of pokemon! A world where your wildest dreams can come true!\nBut only if you choose to let them! Let us begin. \nWhat is your name?");
    basicPanel.add(testLabel);
    basicPanel.add(b1);
    basicFrame.add(basicPanel);

    String name = input.nextLine();
    name = name.trim();

    questionCheck = ", is that right? (1 for yes 2 for no)";
    System.out.println(name + questionCheck);
    checkInt = input.nextInt();
    if (checkInt != 1) {
      question = "What is your name then?";
      name = check(question, questionCheck, name);
    }


    if("Admin".equals(name)){
      charID = 9;
      poke1 = "AdminMewtwo";
    } else if("James".equals(name)){
      charID = 1;
      poke1 = "JPikachu";
    } else if("Asher".equals(name)){
      charID = 2;
      poke1 = "ASandshrew";
    } else if("Jake".equals(name)) {
      charID = 3;
      poke1 = "JBellsprout";
    } else if("Riley".equals(name)){
      charID = 4;
      poke1 = "RNidoran";
    } else if("King".equals(name)){
      charID = 5;
      poke1 = "KMeowth";
    } else if("Brennan".equals(name)){
      charID = 6;
      poke1 = "BCubone";
    } else if("Colin".equals(name)){
      charID = 7;
      poke1 = "CRhyhorn";
    } else if("Jenna".equals(name)){
      charID = 8;
      poke1 = "JVulpix";
    } else if("The bushes of love".equals(name)){
      charID = 9;
      name = "Ash";
      poke1 = "BushesCharizard";
    } else{
      charID = 0;
      poke1 = "Bulbasaur";
    }


    System.out.println(name + ", that is a nice name. Oh yes, I almost forgot!\nWhat is your rivals name?");
    String rivalName = input.next();
    questionCheck = ", is that right? (1 for yes 2 for no)";
    System.out.println(rivalName + questionCheck);
    checkInt = input.nextInt();
    if (checkInt != 1) {
      question = "What is your rivals name then?";
      rivalName = check(question, questionCheck, rivalName);
    }


    System.out.println(rivalName + ", oh yea that is right! Wait a seconed that is my name! I guess that makes us rivals then!\nWell then shall we battle? (1 for yes 2 for no)");
    checkInt = input.nextInt();
    if (checkInt == 1 && charID == 0) {
      System.out.println("Alright it is on " + name + "! Oh wait, you don't have a pokemon yet! \nWell I will tell you what you can use one of mine and if you win you can keep it!");
    }
    else if (checkInt == 1 && charID != 0) {
      System.out.println("Alright it is on " + name + "!");
    }
    else if (checkInt != 1 && charID != 0) {
      System.out.println("To bad " + name + "! Lets do this!");
    }
    else{
      System.out.println("Oh come on " + name + "! Wait you don't have any Pokemon? \nOkay I will tell you what you can use one of mine and if you win you can keep it!");
    }


      checkInt = 0;

      while (charID == 0) {
        System.out.println("Okay which one would you like to choose?\nBulbasaur (type 1)\nSquirtle (type 2)\nCharmander (type 3)");
        checkInt = input.nextInt();
        if (checkInt == 1) {
            System.out.println("Are you sure you want Bulbasaur? (1 for yes 2 for no)");
            checkInt = input.nextInt();
            if (checkInt == 1) {
              pokeID = 1;
              break;
            }
        } else if (checkInt == 2) {
          System.out.println("Are you sure you want Squirtle? (1 for yes 2 for no)");
          checkInt = input.nextInt();
          if (checkInt == 1) {
            pokeID = 4;
            break;
          }
        } else if (checkInt == 3) {
          System.out.println("Are you sure you want Charmander? (1 for yes 2 for no)");
          checkInt = input.nextInt();
          if (checkInt == 1) {
            pokeID = 7;
            break;
            }}
      }
    for (int i = 0; i < 25 ; i++) {
      System.out.println("BATTLE!!!BATTLE!!!BATTLE!!!BATTLE!!!BATTLE!!!BATTLE!!!BATTLE!!!BATTLE!!!BATTLE!!!BATTLE!!!BATTLE!!!BATTLE!!!");
    }






}
  public static String check(String question, String questionCheck, String name){
    Scanner input = new Scanner(System.in);
    String reply;
    int check = 0;
    while(check != 1) {
      System.out.println(question);
      name = input.next();

      System.out.println(name + questionCheck);
      check = input.nextInt();
    }
    return name;
  }
  public static int check(String question, String questionCheck){
    Scanner input = new Scanner(System.in);
    int reply = 0;
    int check = 0;
    while(check != 1) {
      System.out.println(question);
      reply = input.nextInt();

      System.out.println(questionCheck);
      check = input.nextInt();
    }
    return reply;
  }
  public static void gui(){


  }

}
