package RPGGame.cli;


import RPGGame.characters.*;
import RPGGame.main.Game;
import RPGGame.main.Narrator;
import java.util.Scanner;

public class GameConsole {

    public GameConsole() {

    }

    public void run() {
        Scanner mainScanner = new Scanner(System.in);

        while (true) {
            printMainMenu();
            String selection = mainScanner.next();
            switch (selection) {
                case "p" -> start();
                case "c" -> printCredits();
                case "e" -> System.exit(0);
                default -> invalidChoice();
            }
        }
    }


    private void start() {
        Scanner gameScanner = new Scanner(System.in);
        Game game = new Game();
        game.selectDifficultyLevel();
        System.out.println();
        game.selectMainCharacter();
        System.out.println();


        while (!game.isGameOver()) {
            PlayableCharacter player = game.getMainCharacter();

            Narrator.printIntro();
            String name = gameScanner.next();

            Narrator.setPlayerName(name);
            Narrator.setPlayerWeapon(game.getMainCharacter().weaponToString());
            player.setName(name);


            Narrator.printLevelZeroText();
            moveForward();
            player.printImage();
            moveForward();
            player.printPlayerStats();
            moveForward();
            game.battle();
            game.levelUp();
            System.out.println();

            Narrator.printLevelOneText();
            System.out.println();
            game.battle();
            game.levelUp();
            System.out.println();

            Narrator.printLevelTwoText();
            if (!game.solvePuzzle()) {
                Boss sphinx = new Boss(100, 20, 50, 0, "Sphinx");
                Narrator.puzzleFailed();
                game.bossBattle(sphinx, player);
            } else {
                Narrator.puzzleSolved();
                player.setSpecialCounter(player.getSpecialCounter() + 1);
                System.out.println("You gained a special attack!");
            }
            System.out.println();
            game.levelUp();
            System.out.println();
            Narrator.printLevelThreeText();
            System.out.println();
            while (game.getEnemies().size() > 1) {
                game.battle();
                game.levelUp();
                if (game.getEnemies().size() > 2) {
                    System.out.println("Todd: Only " + (game.getEnemies().size() - 1) + " guards left.");
                }
            }
            game.getEnemies().get(0).printImage();
            Narrator.printLevelFourText();
            game.bossBattle((Boss) game.getEnemies().get(0), game.getMainCharacter());
            Narrator.printVictoryMessage();
        }


    }

    public static void moveForward() {
        Scanner ok = new Scanner(System.in);
        System.out.println("\nPress (Enter) to continue");
        String selection = ok.nextLine();
        while (!selection.equals("")) {
            System.out.println("Press (Enter) to continue");
            selection = ok.nextLine();
        }
        System.out.println();
    }

    public static void invalidChoice() {
        System.out.println("Invalid choice");
    }

    public static void printMainMenu() {
        System.out.println(Narrator.PURPLE+"   ▄████████  ▄█       ████████▄     ▄████████ ███▄▄▄▄           ▄████████ ████████▄   ███    █▄     ▄████████    ▄████████    ▄████████ \n" +
                "  ███    ███ ███       ███   ▀███   ███    ███ ███▀▀▀██▄        ███    ███ ███    ███  ███    ███   ███    ███   ███    ███   ███    ███ \n" +
                "  ███    █▀  ███       ███    ███   ███    █▀  ███   ███        ███    █▀  ███    ███  ███    ███   ███    ███   ███    ███   ███    █▀  \n" +
                " ▄███▄▄▄     ███       ███    ███  ▄███▄▄▄     ███   ███        ███        ███    ███  ███    ███   ███    ███  ▄███▄▄▄▄██▀  ▄███▄▄▄     \n" +
                "▀▀███▀▀▀     ███       ███    ███ ▀▀███▀▀▀     ███   ███      ▀███████████ ███    ███  ███    ███ ▀███████████ ▀▀███▀▀▀▀▀   ▀▀███▀▀▀     \n" +
                "  ███    █▄  ███       ███    ███   ███    █▄  ███   ███               ███ ███    ███  ███    ███   ███    ███ ▀███████████   ███    █▄  \n" +
                "  ███    ███ ███▌    ▄ ███   ▄███   ███    ███ ███   ███         ▄█    ███ ███  ▀ ███  ███    ███   ███    ███   ███    ███   ███    ███ \n" +
                "  ██████████ █████▄▄██ ████████▀    ██████████  ▀█   █▀        ▄████████▀   ▀██████▀▄█ ████████▀    ███    █▀    ███    ███   ██████████ \n" +
                "             ▀                                                                                                   ███    ███              "+Narrator.ANSI_RESET);
        System.out.println("(p) Play");
        System.out.println("(c) Credits");
        System.out.println("(e) Exit");
    }

    public static void printDifficultyMenu() {
        System.out.println("Select difficulty level");
        System.out.println(Narrator.CYAN + "(e) Easy" + Narrator.ANSI_RESET);
        System.out.println(Narrator.PURPLE + "(m) Medium" + Narrator.ANSI_RESET);
        System.out.println(Narrator.RED + "(h) Hard" + Narrator.ANSI_RESET);
    }

    public static void printCharacterMenu() {
        System.out.println("Select character type:\n");
        System.out.println();
        System.out.println(Narrator.RED + "Warrior" + Narrator.ANSI_RESET + "\t\t\t\t\t\t\t\t" + Narrator.GREEN + "Archer" + Narrator.ANSI_RESET + "\t\t\t\t\t\t\t\t" + Narrator.CYAN + "Mage" + Narrator.ANSI_RESET + "\t\t\t\t\t\t");
        System.out.println("Level: 1\t\t\t\t\t\t\t" + "Level: 1\t\t\t\t\t\t\t" + "Level: 1");
        System.out.println("Health: 50\t\t\t\t\t\t\t" + "Health: 40\t\t\t\t\t\t\t" + "Health: 30");
        System.out.println("Damage: 15\t\t\t\t\t\t\t" + "Damage: 10\t\t\t\t\t\t\t" + "Damage: 6");
        System.out.println("Potions: 2\t\t\t\t\t\t\t " + "\bPotions: 3\t\t\t\t\t\t\t" + "Potions: 5");
        System.out.println("Specials available: 0\t\t\t\t" + "Specials available: 0\t\t\t\t" + "Specials available: 0");
        System.out.println("Weapon: Sword and Shield\t\t\t" + "Weapon: Bow and Arrows\t\t\t\t" + "Weapon: Staff and Spellbook");
        System.out.println("Special Move: Berserker Rage\t\t" + "Special Move: Headshot\t\t\t\t" + "Special Move: Headshot\n");
        System.out.println("Press" + Narrator.RED + " (w) " + Narrator.ANSI_RESET + "to choose the warrior\t\t" + "Press" + Narrator.GREEN + " (a) " + Narrator.ANSI_RESET + "to choose the archer\t\t" + "Press " + Narrator.CYAN + " (m) " + Narrator.ANSI_RESET + "to choose the archer");
    }

    public static void printActionMenu() {
        System.out.println("---Action Menu---");
        System.out.println("Press (1) to attack");
        System.out.println("Press (2) to attempt special ability");
        System.out.println("Press (3) to heal");
        System.out.println("Press (4) to block");
        System.out.println("Press (5) to view stats");
    }

    public void printCredits() {
        System.out.println("Scenario: Surik Simonyan");
        System.out.println("Main Developer: Georgi Panosyan");
        System.out.println("Developer: Erik Khalatyan");
    }


}
