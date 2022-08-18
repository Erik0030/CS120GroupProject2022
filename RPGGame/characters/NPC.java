package RPGGame.characters;


public abstract class NPC extends GameCharacter {

    public NPC() {
    }

    public NPC(int health, int attackPoints, int level) {
        super(health, attackPoints, level);
    }

    @Override
    public void attack(NPC opponent, PlayableCharacter activePlayer) {
        int criticalHitVector = (int) ((Math.random() * opponent.getLevel()) + 1);
        if (criticalHitVector % 6 == 0) {
            int temp = opponent.getDamage();
            int difference = activePlayer.getHealth() - activePlayer.takeDamage(opponent);
            opponent.setDamage(opponent.getDamage() * 2);
            activePlayer.setHealth(difference);
            opponent.setDamage(temp);
            System.out.println("Critical Hit! " + activePlayer.takeDamage(opponent));
        } else {
            criticalHitVector =(int) ((Math.random() * activePlayer.getLevel()));
            int difference = activePlayer.getHealth() - activePlayer.takeDamage(opponent);
            if (criticalHitVector % 2 == 0) {
                activePlayer.setHealth(difference);
                System.out.println("Hit! "+ activePlayer.takeDamage(opponent));
            }else
                System.out.println("Miss");

        }
    }

    public void printPlayerStats() {
        System.out.println("Enemy stats:");
        System.out.println(getName());
        System.out.println("Level: " + getLevel());
        System.out.println("Health: " + getHealth());
        System.out.println("Damage: " + getDamage());

    }

    @Override
    public void printImage() {

    }

    @Override
    public int takeDamage(GameCharacter c) {
        return c.getDamage();
    }

    @Override
    public void block(GameCharacter c) {
        c.setDamage(c.getDamage()/2);
        System.out.println("Blocked the hit");

    }
}
