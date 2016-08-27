package core.area.supplies;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.fest.assertions.Assertions.assertThat;


/**
 * Created by Pete on 02/08/2016.
 */
public class SupplyCacheTest {

    SupplyCache supplyCache;

    @Mock
    NoSupplies noSupplies;

    @Mock
    Supplies supplies;

    @Before
    public void setUp() throws Exception {
        supplyCache = new SupplyCache(supplies,noSupplies);
    }

    @Test
    public void testEmptyCache() throws Exception {
        SupplyCache supplyCache = SupplyCache.emptyCache(noSupplies);
        assertThat(supplyCache.getAndRemoveSupplies()).isEqualTo(noSupplies);

    }

    @Test
    public void testGetAndRemoveSupplies() throws Exception {
        Supplies supplies2 = supplyCache.getAndRemoveSupplies();
        assertThat(supplies2).isEqualTo(supplies);
        assertThat(supplyCache.getAndRemoveSupplies()).isEqualTo(noSupplies);
    }
}