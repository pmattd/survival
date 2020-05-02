package core.area;

import core.area.relocation.RelocationOptionsFactory;
import core.area.supplies.SupplyCache;
import core.area.travel.ArrivalAction;
import core.area.travel.Direction;
import core.boundary.options.ExecutableOption;
import core.boundary.options.OptionList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Pete on 15/06/2016.
 */
public class BasicLocationTest {

    @Mock
    Location otherLocation;
    @Mock
    Area area;
    @Mock
    SupplyCache supplyCache;
    @Mock
    OptionList<ExecutableOption> travelOptions;
    @Mock
    ArrivalAction arrivalAction;
    @Mock
    RelocationOptionsFactory relocationOptionsFactory;
    private BasicLocation location;
    @Mock
    private Direction direction;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        location = new BasicLocation("prison","prisondesc", area, supplyCache, arrivalAction, travelOptions, relocationOptionsFactory);
    }

    //todo test hte get options return empty lists especially reloaction options

    @Test
    public void testScavenge(){
        assertThat(location.scavenge()).isEqualTo(supplyCache);
    }




}