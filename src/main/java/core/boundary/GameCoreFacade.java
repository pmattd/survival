package core.boundary;

import com.google.inject.Inject;
import core.area.CurrentLocation;
import core.area.GameMap;
import core.area.LocationDescription;
import core.boundary.options.CategorisedOptions;
import core.gamestate.GameStateMachine;
import core.gamestate.states.StartState;
import core.hero.Hero;
import core.hero.HeroCreationTemplate;
import core.hero.InventoryTransferInterface;
import core.hero.Party;

public class GameCoreFacade {

    private final Party party;
    private final GameStateMachine gameStateMachine;
    private final CurrentLocation currentLocation;
    private final GameMap gameMap;
    private final InventoryTransferInterface inventoryTransferInterface;


    @Inject
    public GameCoreFacade(Party party,
                          GameStateMachine gameStateMachine,
                          CurrentLocation currentLocation,
                          GameMap gameMap, StartState startState, InventoryTransferInterface inventoryTransferInterface) {

        this.party = party;
        this.gameStateMachine = gameStateMachine;
        this.currentLocation = currentLocation;
        this.gameMap = gameMap;
        this.inventoryTransferInterface = inventoryTransferInterface;
        gameStateMachine.setState(startState);
    }

    private void startScenario(){
        currentLocation.setLocation(gameMap.getStartLocation().getArrivalLocation());
    }

    //travel
    public LocationDescription getLocationDescription() {
        return currentLocation.getLocationDescription();
    }

    public CategorisedOptions getAllOptions(){
        return gameStateMachine.getAllOptions();
    }

    //hero
    public HeroCreationTemplate getHeroCreationTemplate() {
        return party.getHeroCreationTemplate();
    }

    public void createHeroAndStart(Hero hero) {
        party.createHero(hero);
        startScenario();
    }


    public InventoryTransferInterface getInventoryTransferInterface() {
        return inventoryTransferInterface;
    }
}
