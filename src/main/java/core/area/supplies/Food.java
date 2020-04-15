package core.area.supplies;

/**
 * Created by Pete on 29/08/2016.
 */
public class Food implements InventoryItem {

    private final String title;

    public Food(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
