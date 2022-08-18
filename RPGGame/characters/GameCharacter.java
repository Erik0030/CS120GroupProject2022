package RPGGame.characters;

public abstract class GameCharacter implements Fightable {

    private int health;
    private int damage;
    private String name;
    private int level;


    public GameCharacter() {
    }

    public GameCharacter(int health, int attackPoints, int level) {
        this.health = health;
        this.damage = attackPoints;
        this.level = level;
    }

    public GameCharacter(GameCharacter g) {
        this.setLevel(g.getLevel());
        this.setHealth(g.getHealth());
        this.setDamage(getDamage());
        this.setName(g.getName());
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public abstract void printPlayerStats();

    public abstract void printImage();


}
