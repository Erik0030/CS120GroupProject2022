package RPGGame.characters;


public class Archer extends PlayableCharacter {
    public Archer() {
        setHealth((getLevel() + 20) * 2);
        setDamage((getLevel()+5)*2);
        setLevel(1);
        setPotions(3);
        setSpecialCounter(0);

    }


    @Override
    public void attack(NPC opponent, PlayableCharacter activePlayer) {
        int criticalHitVector = (int) ((Math.random() * 5) + 5);
        if (criticalHitVector % 5 == 0) {
            int temp = activePlayer.getDamage();
            activePlayer.setDamage(activePlayer.getDamage() * 2);
            opponent.setHealth(opponent.getHealth() - opponent.takeDamage(activePlayer));
            System.out.println("Crippling shot! " + activePlayer.getDamage());
            activePlayer.setDamage(temp);
            setSpecialCounter(getSpecialCounter() + 1);
        } else {
            opponent.setHealth(opponent.getHealth() - opponent.takeDamage(activePlayer));
            System.out.println("Melee Hit! " + activePlayer.getDamage());
        }
        setSpecialCounter(getSpecialCounter() + 1);
    }

    @Override
    public int takeDamage(GameCharacter c) {
        return c.getDamage();
    }


    @Override
    public void useSpecialAbility(NPC opponent, PlayableCharacter activePlayer) {
        if (getSpecialCounter() > 0) {
            opponent.setHealth(0);
            System.out.println("Headshot!");
            setSpecialCounter(getSpecialCounter() - 1);

        } else {
            System.out.println("Headshot failed");
            setSpecialCounter(getSpecialCounter() + 1);
        }
    }

    @Override
    public String specialMoveToString() {
        return "Headshot";
    }

    @Override
    public String characterToString() {
        return "Archer";
    }

    @Override
    public String weaponToString() {
        return "Bow and Arrows";
    }

    @Override
    public void printImage() {
        System.out.println("""
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠤⣠⠄⠠⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⣾⠴⣍⠀⢀⡀⠒⢕⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣞⣞⠃⢀⣈⣳⣤⡀⠉⢒⢿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠼⢧⣅⡀⢤⡬⡝⢻⣭⡃⢻⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⡤⣹⡧⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣼⠹⡁⠈⠁⠀⣼⢿⡻⡎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⣇⣚⢽⢂⠱⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠑⢅⣉⢅⢾⡞⡿⣴⠅⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⢸⠷⣻⡈⢢⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣶⣶⣾⣿⣯⣿⡻⢊⣞⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⢠⠏⠀⠘⠉⠻⣿⣿⣷⣄⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⢣⢕⣿⣿⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⢠⠏⠀⠀⠀⡄⠀⠘⢿⣾⣯⣷⣄⠀⡴⣿⣿⣿⣿⣿⡟⠋⢹⣿⣇⣾⣿⣿⢿⢿⣿⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⢠⡏⠀⠀⠀⠀⡇⠀⠀⠈⢿⣿⣿⣿⢿⠁⠋⢉⣥⣾⣿⠠⣀⢸⣿⣶⡻⣿⣏⣾⣦⡀⠈⠉⠢⡀⠀⠀⠀⠀⠀⠀
                ⠀⣼⠀⠀⠀⠀⠀⢀⠀⠀⠀⠈⢟⣛⣁⠘⡣⠂⠉⣿⠻⠿⢧⠀⢹⣿⣿⣾⣿⣿⠋⠁⠈⠲⠄⣌⣬⢒⣄⠀⠀⠀⠀
                ⢀⡇⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠈⠁⠊⠁⠀⣸⡟⠀⢠⠊⢃⢰⣿⡿⢱⣿⢿⣇⣀⣠⡤⠚⢁⠀⠀⣹⠀⠀⠀⠀
                ⠸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⠁⢠⣿⢾⣆⣸⣿⣗⣟⠿⣞⠁⠀⢀⣷⡤⠴⠾⠿⠙⠀⠀⠀⠀
                ⠀⣷⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⢸⠏⢠⡏⠻⢷⣾⣼⣿⣿⣟⠓⢼⣳⣶⣿⣿⣷⣠⣲⠶⣧⣤⣆⡀⠀
                ⠀⠘⣆⠀⠀⠀⠀⠀⠃⠀⠀⠀⠀⣀⣀⣤⣴⣿⣿⣵⡁⠀⠀⠈⠉⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣟⣟⣦⣤⡬⠄⠀
                ⠀⠀⢻⡆⠀⠀⠀⠀⢰⠀⠀⠀⣾⣿⣿⣿⣿⣿⡇⡎⠁⠀⠀⠀⠀⣿⣿⡇⠀⠀⣿⣿⣿⡛⠋⠀⠁⠀⠐⠃⠉⠀⠀
                ⠀⠀⢸⣧⠀⠀⠀⠀⠘⠀⠀⠀⠹⠿⠿⠟⠛⢻⢠⣥⠀⠀⠀⠀⠀⣿⣿⡇⠀⣀⠝⢿⠻⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⢸⣿⠀⠀⠀⠀⠀⡆⠀⠀⠀⠀⠀⠀⠀⢸⣞⣿⣀⣀⠀⠀⠀⣿⣿⡇⠀⣀⠤⢞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠸⣿⡄⠀⠀⠀⠀⠇⠀⠀⠀⠀⠀⠀⠀⠀⣿⣀⣀⠈⠉⢉⣹⠹⣽⡉⠉⠀⠀⠀⢢⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⣿⡇⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⢿⠿⢿⣿⣿⡿⡇⠀⠘⢾⣆⠀⠀⢀⣰⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⣿⡇⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀⠀⢰⠁⠀⠀⠈⠻⣷⣴⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⢈⣷⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⢸⣇⣀⣀⣀⣮⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⢸⡏⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠙⢿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⢸⠃⠀⠀⠀⠀⠀⢁⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⢀⣼⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⣴⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⠋⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⢸⡄⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⣾⣿⣿⣿⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠈⣧⠀⠀⠀⠀⠀⠀⡆⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⠇⠀⠀⠀⠀⠀⣸⣿⣿⣿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠘⢧⠀⠀⠀⠀⠀⠃⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⠀⠀⠀⠀⠀⢠⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠈⢳⡀⠀⠀⠀⢰⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⠀⠀⠀⢀⢠⣾⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠙⣦⠀⠀⠸⠀⠀⠀⠀⠀⠀⠀⢿⣿⡿⠀⠀⢰⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠈⠳⣄⠀⡄⠀⠀⠀⠀⠀⠀⢸⣿⡇⠀⠀⠘⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠳⣇⠀⠀⠀⠀⠀⠀⣾⣿⣷⠀⠀⠀⢸⣿⣷⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⠀⠀⠀⠀⠀⠰⣿⣿⣿⣆⠀⠀⠘⠻⠿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠃⠀⠀⠀⠀⠀⠀⠛⣿⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢘⣽⣶⣆
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠛⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀""");
    }
}
