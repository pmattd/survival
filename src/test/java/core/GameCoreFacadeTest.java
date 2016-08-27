package core;

import core.area.CurrentLocation;
import core.area.GameMap;
import core.boundary.GameCoreFacade;
import core.boundary.options.InterfaceOptionsStore;
import core.gamestate.GameStateMachine;
import core.gamestate.states.StartState;
import core.hero.Party;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by Pete on 30/05/2016.
 */
public class GameCoreFacadeTest {

	GameCoreFacade gameCoreFacade;

	@Mock
	Party party;

	@Mock
	GameStateMachine gameStateMachine;

	@Mock
	CurrentLocation currentLocation;

	@Mock
	GameMap gameMap;

	@Mock
	InterfaceOptionsStore interfaceOptionsStore;

	@Mock
	StartState startState;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.gameCoreFacade = new GameCoreFacade(party, gameStateMachine,  currentLocation, gameMap, startState);
	}


}