package core.hero;

import core.area.scavenge.RetrieveSuppliesAction;
import core.area.scavenge.RetrieveSuppliesActionFactory;
import core.area.supplies.SupplyCache;
import core.area.supplies.SupplyCacheFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by Pete on 02/08/2016.
 */
public class PartyTest {

    @Mock
    HeroCreationTemplate heroCreationTemplate;
    @Mock
    Inventory inventory;
    @Mock
    RetrieveSuppliesActionFactory retrieveSuppliesActionFactory;
    @Mock
    Hero hero;
    @Mock
    SupplyCache foundSupplyCache;
    @Mock
    SupplyCacheFactory supplyCacheFactory;
    @Mock
    RetrieveSuppliesAction retrieveSuppliesAction;
    private Party party;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.party = new Party(heroCreationTemplate, inventory, retrieveSuppliesActionFactory, supplyCacheFactory);
    }

    @Test
    public void testCreateHero() throws Exception {
        party.createHero(hero);
    }

    @Test
    public void testTransferFoundSuppliesToInventory() throws Exception {
        when(retrieveSuppliesActionFactory.build(inventory,foundSupplyCache)).thenReturn(retrieveSuppliesAction);
        when(foundSupplyCache.getScavengeText()).thenReturn("scavengeText");

        party.setFoundSupplyCache(foundSupplyCache);
        String text = party.transferFoundSuppliesToInventory();

        assertThat(text).isEqualTo("scavengeText");
        verify(retrieveSuppliesAction,times(1)).run();

    }


}