package RPGGame.characters;

public interface Fightable {

    void attack(NPC opponent, PlayableCharacter activePlayer);

    int takeDamage(GameCharacter c);

    void block(GameCharacter c);


}
