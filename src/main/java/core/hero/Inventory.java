package core.hero;

import com.google.inject.Singleton;
import core.area.supplies.SupplyCache;

/**
 * Created by Pete on 18/07/2016.
 */
@Singleton
public class Inventory {
    private int food;
    private boolean active;
    private SupplyCache foundSupplyCache;

    public Inventory(){
        food = 0;
    }
    public int getFood() {
        return food;
    }

    public void addFood(int food) {
        this.food += food;
    }

    public void setActive() {
        this.active = true;
    }

    public void setFoundSupplyCache(SupplyCache foundSupplyCache) {
        this.foundSupplyCache = foundSupplyCache;
    }
}
