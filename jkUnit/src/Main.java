import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
    }
}

class player{
    private String name;
    private int hp;
    private boolean alive;

    public player(String name, int hp, boolean alive) {
        this.name = name;
        this.hp = hp;
        this.alive = alive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}