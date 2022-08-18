package RPGGame.characters;

public class Mage extends PlayableCharacter {


    public Mage() {
        this.setHealth((this.getLevel() + 15) * 2);
        this.setDamage((this.getLevel() + 4) * 2);
        this.setLevel(1);
        this.setPotions(4);
        this.setSpecialCounter(0);
    }

    public int getSpecialCounter() {
        return specialCounter;
    }

    public void setSpecialCounter(int specialCounter) {
        this.specialCounter = specialCounter;
    }


    @Override
    public void attack(NPC opponent, PlayableCharacter activePlayer) {
        int criticalHitVector = (int) ((Math.random() * 8) + 4);
        if (criticalHitVector % 4 == 0) {
            int temp = activePlayer.getDamage();
            activePlayer.setDamage((activePlayer.getDamage() * 5) / 3);
            opponent.setHealth(opponent.getHealth() - activePlayer.getDamage());
            System.out.println("Lightning attack! " + activePlayer.getDamage());
            activePlayer.setDamage(temp);
            setSpecialCounter(getSpecialCounter() + 1);
        } else {
            opponent.setHealth(opponent.getHealth() - activePlayer.getDamage());
            System.out.println("Firey burst" + activePlayer.getDamage());
        }
    }

    @Override
    public int takeDamage(GameCharacter c) {
        return c.getDamage();
    }

    @Override
    public void useSpecialAbility(NPC opponent, PlayableCharacter activePlayer) {
        if (activePlayer.getSpecialCounter() > 0) {
            opponent.setHealth(opponent.getHealth() / 3);
            System.out.println("FIREBALL!");
        } else {
            int originalDamage = activePlayer.getDamage();
            activePlayer.setDamage(activePlayer.getDamage() * activePlayer.getLevel());
            attack(opponent, activePlayer);
            activePlayer.setDamage(originalDamage);
        }
    }


    @Override
    public String characterToString() {
        return "Mage";
    }

    @Override
    public String specialMoveToString() {
        return "Fireball";
    }

    @Override
    public String weaponToString() {
        return "Staff and Spellbook";
    }

    @Override
    public void printImage() {
        System.out.println("""
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⣞⠉⠀⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⠝⡄⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢘⠀⡇⠀⣶⣙⠀⠀⠀⠀⠀⠀⠀⠀⠀⡼⣇⠜⡇⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⢀⡶⢿⠃⠐⣼⣍⡀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣸⣴⠀⠀
                ⠀⠀⠀⠀⣀⣤⣴⣾⢷⣴⣿⢿⣶⣶⣖⣾⣿⣷⠶⠆⠀⠀⠀⠀⢿⣿⠃⠀⠀
                ⠀⠀⠀⠈⠛⠛⠛⢻⣿⣿⣿⣿⣹⣿⣿⡅⠀⠀⠀⠀⠀⠀⠀⠀⣾⡇⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⣿⣷⢿⡿⣿⣷⠀⠀⠀⠀⠀⠀⠀⢀⣯⠁⠀⠀⠀
                ⠀⠀⠀⠀⠀⢀⡠⣻⣿⡎⠙⠀⡀⢼⣿⡉⠑⠒⢤⠀⠀⠀⠀⢸⡾⠀⠀⠀⠀
                ⠀⠀⠀⠀⡰⠁⢀⠕⣿⣾⣧⣼⣷⣿⡇⠀⠀⠀⠈⢇⠀⠀⣤⣟⡣⡄⠀⠀⠀
                ⠀⠀⠀⢠⠃⡀⢁⣊⣨⢿⣾⣿⣿⣿⢮⣅⠀⠀⠰⢜⡄⠀⢿⣭⢩⣳⠀⠀⠀
                ⠀⠀⠀⣼⡾⣖⣵⣾⠹⠀⠺⣿⡏⠈⡇⢻⠿⣶⣶⡶⣽⡶⢾⣶⣧⠃⠀⠀⠀
                ⠀⠀⣾⡿⠚⢛⣿⠏⠀⠀⠀⢸⡀⠀⠘⠀⠁⢹⣿⠛⡇⣷⣼⣼⣁⠀⠀⠀⠀
                ⠀⢰⡏⢒⣩⣧⣿⡀⢸⠀⡀⡡⠀⡀⢰⠀⣠⣼⡏⢰⠃⣿⡿⣿⣿⠀⠀⠀⠀
                ⠀⢮⡗⢁⣶⢮⣿⡿⠿⣷⣷⢿⣵⣷⣿⡷⢿⣿⣿⣿⡀⣿⢣⢣⢿⠀⠀⠀⠀
                ⠀⢸⠃⣼⣆⣾⢯⣦⢿⣤⣾⡟⢰⣿⣿⡽⡌⠟⣿⣿⣿⢿⢻⡿⠃⠀⠀⠀⠀
                ⠀⢸⣄⣿⣿⣧⣿⣽⠿⠋⡌⢹⠁⣿⣿⠑⡄⠀⣏⣯⡏⡏⡿⡅⠀⠀⠀⠀⠀
                ⠀⢸⣿⣯⣕⣿⡟⢇⠀⠀⠇⢸⣀⣏⣿⠀⢡⠀⢸⠈⣌⣇⡇⣇⠀⠀⠀⠀⠀
                ⠀⢸⣿⣾⣾⣿⠁⠈⠀⠘⠀⠸⡁⣿⢹⡄⠀⠀⠀⡇⢹⢸⢣⢸⠀⠀⠀⠀⠀
                ⠀⠀⢻⣿⣟⣿⠀⠀⠀⠀⠀⠀⡇⣿⢸⡇⠀⠀⠀⢱⢸⡆⢸⠀⡆⠀⠀⠀⠀
                ⠀⡇⢸⢹⢿⣻⠀⠀⠀⠀⠀⠀⡟⠉⢸⢷⠀⠀⠀⠈⡇⣷⠸⠀⢰⠀⠀⠀⠀
                ⠀⡇⢸⠈⢸⢽⠀⠀⠀⠀⠀⢰⣡⠀⢸⣇⡇⠀⠀⢀⢧⠋⡆⡆⠀⡇⠀⠀⠀
                ⠀⡇⢸⠀⡘⢸⠀⠀⠀⠀⠀⠀⢻⠀⠘⣿⢱⠀⠀⢸⣿⡄⠀⢇⠀⢹⠀⠀⠀
                ⠀⡇⢸⠀⡇⢸⠀⠀⠀⠀⠀⠀⢸⡆⢠⠉⠈⡆⠀⢸⡟⢱⠀⠸⠀⠈⡇⠀⠀
                ⠀⡇⠈⡄⠀⢸⠀⡆⠀⠀⠀⠀⢸⡇⠘⡀⠀⠈⠀⣾⡇⢎⡆⠀⡇⠀⢱⠀⠀
                ⢸⠀⠀⡇⠀⣸⠀⡇⠀⠀⡀⠀⢸⣿⠀⡇⠀⠀⠀⣇⠁⡾⣱⠀⢸⠀⠈⡄⠀
                ⢸⠀⠀⡇⢀⣟⢸⡁⠀⠀⡇⠀⢸⢿⡄⠀⠀⠀⢸⣿⠀⢸⣧⡆⢸⠀⠀⢱⠀
                ⢸⠀⠀⡟⠁⣿⣿⢤⡀⠀⠁⠀⢸⣆⡇⠀⠀⠀⠸⡿⢂⣨⣙⠿⡐⡇⠀⠈⡇
                ⠺⠤⠔⢋⣴⠿⠋⠀⣈⡦⣀⣀⣘⣦⠝⠢⠤⢄⣷⣷⡫⠉⠻⡲⣧⡑⠒⠊⠁
                ⠀⠀⠀⠈⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣻⠁⠉⠑⠒⠚⠚⠀⠀⠀⠀⠀⠀""");
    }
}
