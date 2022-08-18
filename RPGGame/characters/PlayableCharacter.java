package RPGGame.characters;


import RPGGame.main.Narrator;

public abstract class PlayableCharacter extends GameCharacter {

    int potions;
    int specialCounter;

    public PlayableCharacter() {

    }


    public PlayableCharacter(PlayableCharacter p) {
        super(p.getHealth(), p.getDamage(), p.getLevel());
        this.potions = p.getPotions();
        this.specialCounter = p.getSpecialCounter();
    }


    public int getPotions() {
        return potions;
    }

    public void setPotions(int potions) {
        this.potions = potions;
    }

    public int getSpecialCounter() {
        return specialCounter;
    }

    public void setSpecialCounter(int specialCounter) {
        this.specialCounter = specialCounter;
    }

    public final void heal() {
        if (this.getPotions() > 0) {
            System.out.println("Healed successfully");
            System.out.println(this.getHealth() + " +10");
            this.setHealth(this.getHealth() + 10);
            this.setPotions(this.getPotions() - 1);
        } else
            System.out.println("No potions left");
    }

    @Override
    public void attack(NPC opponent, PlayableCharacter activePlayer) {

    }

    @Override
    public int takeDamage(GameCharacter c) {
        return 0;
    }

    @Override
    public void block(GameCharacter c) {
        c.setDamage(c.getDamage() / 3);
        System.out.println("Blocked the hit");
    }

    public void useSpecialAbility(NPC opponent, PlayableCharacter activePlayer) {
    }


    public void printPlayerStats() {
        System.out.println("Character Stats: ");
        if (this.getName() != null) {
            System.out.println(Narrator.RED + this.getName() + " the " + this.characterToString() + Narrator.ANSI_RESET);
        } else {
            System.out.println(Narrator.RED + this.characterToString() + Narrator.ANSI_RESET);
        }
        System.out.println("Level: " + this.getLevel());
        System.out.println("Health: " + this.getHealth());
        System.out.println("Damage: " + this.getDamage());
        System.out.println("Potions: " + this.getPotions());
        System.out.println("Specials available: " + this.getSpecialCounter());
        System.out.println("Weapon: " + this.weaponToString());
        System.out.println("Special Move: " + Narrator.RED + this.specialMoveToString() + Narrator.ANSI_RESET);
    }

    @Override
    public void printImage() {

    }

    public String specialMoveToString() {
        return "special";
    }

    public String characterToString() {
        return "Player Character";
    }

    public String weaponToString() {
        return "";
    }


}
