package combat;

public class Character {
    private final int initiative;
    public int getInitiative(){
        return initiative;
    };

    public Character(int initiative) {
        this.initiative = initiative;
    }
}
