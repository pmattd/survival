package core.hero;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import core.area.supplies.Supplies;

/**
 * Created by Pete on 29/08/2016.
 */

@Singleton
public class InventoryTransferInterface {

    private final Inventory inventory;

    @Inject
    public InventoryTransferInterface(Inventory inventory) {
        this.inventory = inventory;
    }

    public Supplies getFoundSupplies() {
        return inventory.getFoundSupplies();
    }

    public void takeAll() {
        inventory.addFood(inventory.getFoundSupplies().getFood());

    }


    //get the supplies to display
    //transfer the supplies.
    //get the current inventory.

}
