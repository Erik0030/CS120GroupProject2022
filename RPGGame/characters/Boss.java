package RPGGame.characters;

import RPGGame.cli.GameConsole;
import RPGGame.main.Narrator;

public class Boss extends NPC {

    private int specialCounter;

    public Boss() {
        this.setHealth(100);
        this.setDamage(20);
        this.setLevel(20);
        this.setSpecialCounter(2);
        this.setName("Phil Oxlong");
    }

    public Boss(int health, int attackPoints, int level, int specialCounter, String name) {
        super(health, attackPoints, level);
        this.setSpecialCounter(specialCounter);
        this.setName(name);
    }

    public Boss(Boss boss) {
        super(boss.getHealth(), boss.getDamage(), boss.getLevel());
        setSpecialCounter(getSpecialCounter());
        setName(boss.getName());
    }

    public int getSpecialCounter() {
        return specialCounter;
    }

    public void setSpecialCounter(int specialCounter) {
        this.specialCounter = specialCounter;
    }

    @Override
    public void attack(NPC opponent, PlayableCharacter activePlayer) {
        super.attack(opponent, activePlayer);
        this.setSpecialCounter(this.getSpecialCounter() + 1);
    }

    @Override
    public int takeDamage(GameCharacter c) {
        return c.getDamage();
    }

    public void useSpecialAbility(NPC opponent, PlayableCharacter activePlayer) {
        if ((getSpecialCounter() + 1) * (Math.random() * 9) % 3 == 0) {
            activePlayer.setHealth(activePlayer.getHealth() - activePlayer.getHealth() / 4);
            setSpecialCounter(0);
            System.out.println("Dragon's Breath!");
        } else
            super.attack(opponent, activePlayer);
        System.out.println("You will never defeat me!");
    }

    public final void heal() {
        if ((int) ((Math.random() * 10) + 1) % 6 == 0) {
            System.out.println(this.getName() + "healed successfully");
            System.out.println(this.getHealth() + " +10");
            this.setHealth(this.getHealth() + 10);
        }
    }

    @Override
    public String toString() {
        return this.getName() + "the Dragon King";
    }

    public void printImage() {
        System.out.println("""
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⡶⠒⠂⠀⠀⠀⠀⠀⠙⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⢶⣦⠀⠀⠀⠀⢀⣤⣖⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⡮⠟⠀⠀⠀⠀⢿⣯⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣏⡀⣠⡤⡴⠦⣄⠀⠙⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣽⢏⡏⡊⠀⠀⣽⡗⣋⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡏⣼⣿⠁⠀⢀⡛⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡿⣟⢛⣢⣿⠋⢀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣸⣈⡉⠐⣺⣵⢟⣳⡶⣶⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣜⣿⣽⣿⣟⣧⣖⣩⣾⡻⣵⠟⣫⢿⣿⡦⣤⣤⣀⠀⠀⠀⠀⠀⠀⣀⣀⡄
                ⠀⠀⠀⠀⠀⠀⠀⠤⣤⢄⣀⣠⠞⠉⢀⠘⢻⡿⣿⣴⢹⣿⣿⣾⣻⠟⠁⣾⡛⠉⠁⠀⠈⠙⢪⣳⠤⣔⡶⠽⠛⠉⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⢻⣩⡳⣀⣴⣿⣵⢹⢿⡾⣿⢟⡽⢋⣠⣴⠟⣧⣀⠀⢠⢤⡐⢿⣾⡏⠁⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠳⢿⣺⣏⠘⢮⣿⣸⣿⣿⣷⣾⣿⡿⠷⠶⢾⣟⣿⣗⡾⣿⢺⡿⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡎⢻⡄⠀⠉⣹⣯⣉⡁⠀⠀⠀⠀⢀⣶⣷⣸⠀⠻⢿⢟⡇⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠘⣿⡖⠋⢁⣏⣉⠛⠷⠶⠶⠿⢿⣿⣿⢻⡆⠀⠀⣏⡇⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣇⠀⣿⣠⢴⡟⡗⠛⣿⣦⠾⠶⠾⢮⣿⣿⣏⣿⠀⢀⠷⣇⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣟⠐⣹⣇⡼⡇⣧⣤⣼⣿⡶⠶⠶⣿⣿⣿⣿⡏⢳⡌⣴⢻⡇⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡾⣟⢯⣻⣿⣿⠒⣇⣇⣀⣴⣿⡷⠶⣿⣟⡙⡧⣏⣰⣷⣻⣿⡿⡇⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⢠⣄⡦⠾⠓⠀⢀⡠⣺⣿⣇⣏⡛⢻⣿⣿⢉⡇⡇⠀⢰⢿⡟⢚⣿⡯⡷⢡⣿⣿⡵⡞⢳⣧⢸⠀⠀⠀⠀⠀⠀⠀
                ⠠⣤⡛⠋⣁⠀⡠⠊⢡⣾⣿⣻⡻⡯⠽⣿⣿⡿⡙⠓⠓⠒⠿⢛⢛⣻⡟⣻⢾⢽⣻⡼⣊⣽⣿⣾⢸⡇⠀⠀⠀⠀⠀⠀
                ⠀⠈⠀⠚⢁⠞⠀⠀⢸⣗⡟⠻⠵⠳⠒⠚⣲⢷⣌⠳⠤⢤⡜⠚⣩⣾⠞⠁⠸⠯⠑⡞⠁⣾⠃⣻⠸⢷⠀⠀⠀⠀⠀⠀"""
        );
        System.out.println(Narrator.RED+"""
                 ██▓███   ██░ ██  ██▓ ██▓        ▒█████  ▒██   ██▒ ██▓     ▒█████   ███▄    █   ▄████\s
                ▓██░  ██▒▓██░ ██▒▓██▒▓██▒       ▒██▒  ██▒▒▒ █ █ ▒░▓██▒    ▒██▒  ██▒ ██ ▀█   █  ██▒ ▀█▒
                ▓██░ ██▓▒▒██▀▀██░▒██▒▒██░       ▒██░  ██▒░░  █   ░▒██░    ▒██░  ██▒▓██  ▀█ ██▒▒██░▄▄▄░
                ▒██▄█▓▒ ▒░▓█ ░██ ░██░▒██░       ▒██   ██░ ░ █ █ ▒ ▒██░    ▒██   ██░▓██▒  ▐▌██▒░▓█  ██▓
                ▒██▒ ░  ░░▓█▒░██▓░██░░██████▒   ░ ████▓▒░▒██▒ ▒██▒░██████▒░ ████▓▒░▒██░   ▓██░░▒▓███▀▒
                ▒▓▒░ ░  ░ ▒ ░░▒░▒░▓  ░ ▒░▓  ░   ░ ▒░▒░▒░ ▒▒ ░ ░▓ ░░ ▒░▓  ░░ ▒░▒░▒░ ░ ▒░   ▒ ▒  ░▒   ▒\s
                ░▒ ░      ▒ ░▒░ ░ ▒ ░░ ░ ▒  ░     ░ ▒ ▒░ ░░   ░▒ ░░ ░ ▒  ░  ░ ▒ ▒░ ░ ░░   ░ ▒░  ░   ░\s
                ░░        ░  ░░ ░ ▒ ░  ░ ░      ░ ░ ░ ▒   ░    ░    ░ ░   ░ ░ ░ ▒     ░   ░ ░ ░ ░   ░\s
                          ░  ░  ░ ░      ░  ░       ░ ░   ░    ░      ░  ░    ░ ░           ░       ░\s"""+Narrator.ANSI_RESET);
        GameConsole.moveForward();
        printPlayerStats();
    }
}

