package core.hero;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import core.area.scavenge.RetrieveSuppliesAction;
import core.area.scavenge.RetrieveSuppliesActionFactory;
import core.area.supplies.SupplyCache;
import core.area.supplies.SupplyCacheFactory;

/**
 * Created by Pete on 08/06/2016.
 */
@Singleton
public class Party {

    private final HeroCreationTemplate heroCreationTemplate;
    private final RetrieveSuppliesActionFactory retrieveSuppliesActionFactory;
    private Hero hero;
    private Inventory inventory;
    private SupplyCache foundSupplyCache;

    @Inject
    public Party(HeroCreationTemplate heroCreationTemplate,
                 Inventory inventory,
                 RetrieveSuppliesActionFactory retrieveSuppliesActionFactory,
                 SupplyCacheFactory supplyCacheFactory) {
        this.inventory = inventory;
        this.heroCreationTemplate = heroCreationTemplate;
        this.retrieveSuppliesActionFactory = retrieveSuppliesActionFactory;
        this.foundSupplyCache = supplyCacheFactory.emptyCache();
    }

    public Hero getHero(){
        return hero;
    }

    public void createHero(Hero hero){
        this.hero = hero;
    }

    public HeroCreationTemplate getHeroCreationTemplate() {
        return heroCreationTemplate;
    }

    public int getFood() {
        return inventory.getFood();
    }

    public String transferFoundSuppliesToInventory(){
        RetrieveSuppliesAction action = retrieveSuppliesActionFactory.build(inventory,foundSupplyCache);
        String text = foundSupplyCache.getScavengeText();
        action.run();
        return text;
    }

    public SupplyCache getFoundSupplyCache(){
        return  foundSupplyCache;
    }

    public void setFoundSupplyCache(SupplyCache foundSupplyCache) {
        this.foundSupplyCache = foundSupplyCache;
    }

}
