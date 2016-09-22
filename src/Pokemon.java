import java.util.*;

public class Pokemon {

   public static void main(String[] args) {

      pokemonObj Bulbasaur = new pokemonObj(); //Creates a object from pokmeon of Bulbasaur
      Bulbasaur = create(Bulbasaur, "Bulbasaur", 45, 49, 49, 45, 100, "Grass", "Takle", "Growl", "Vine Whip", "Cut");

      pokemonObj Charmander = new pokemonObj();
      Charmander = create(Charmander, "Charmander", 39, 52, 43, 65, 100, "Fire", "Scratch", "Growl", "Ember", "Swift");

      pokemonObj Squirtle = new pokemonObj();
      Squirtle = create(Squirtle, "Squirtle", 44, 48, 65, 43, 100, "Water", "Takle", "Tail Whip", "Water Gun", "Bite");

      pokemonObj Player = new pokemonObj();
      Player = Squirtle;
      
      System.out.println("Pokemon");
      System.out.print("\t" + Player.name);

   }
   public static pokemonObj create(pokemonObj pokemon, String name, int hp, int attack, int defense, int speed, int acc, String type, String move1, String move2, String move3, String move4){
      pokemon.name = name;
      pokemon.hp = hp;
      pokemon.attack = attack;
      pokemon.defense = defense;
      pokemon.speed = speed;
      pokemon.acc = acc;
      pokemon.type = type;
      pokemon.move1 = move1;
      pokemon.move2 = move2;
      pokemon.move3 = move3;
      pokemon.move4 = move4;
      return pokemon;
   }

}
class pokemonObj {
   String name;
   int hp;
   int attack;
   int defense;
   int speed;
   int acc;
   String type;
   String move1;
   String move2;
   String move3;
   String move4;
}
