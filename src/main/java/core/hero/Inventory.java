package core.hero;

/**
 * Created by Pete on 18/07/2016.
 */
public class Inventory {
    private int food;


    public Inventory(){
        food = 0;
    }
    public int getFood() {
        return food;
    }

    public void addFood(int food) {
        this.food += food;
    }
}
