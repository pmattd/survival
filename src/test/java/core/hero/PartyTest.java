package core.hero;

import core.area.scavenge.RetrieveSuppliesAction;
import core.area.scavenge.RetrieveSuppliesActionFactory;
import core.area.supplies.SupplyCache;
import core.area.supplies.SupplyCacheFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Pete on 02/08/2016.
 */
public class PartyTest {

    private Party party;

    @Mock
    HeroCreationTemplate heroCreationTemplate;

    @Mock
    Inventory inventory;

    @Mock
    RetrieveSuppliesActionFactory retrieveSuppliesActionFactory;

    @Mock
    SupplyCache foundSupplyCache;

    @Mock
    SupplyCacheFactory supplyCacheFactory;

    @Mock
    RetrieveSuppliesAction retrieveSuppliesAction;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.party = new Party(inventory,retrieveSuppliesActionFactory, supplyCacheFactory);
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