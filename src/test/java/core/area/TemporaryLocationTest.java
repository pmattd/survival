package core.area;

import static org.fest.assertions.Assertions.assertThat;

import core.area.supplies.SupplyCache;
import core.area.travel.Direction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TemporaryLocationTest {

	TemporaryLocation temporaryLocation;

	@Mock
	Direction onwards;

	@Mock
	Direction back;

	@Mock
	SupplyCache supplies;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		this.temporaryLocation = new TemporaryLocation("blah",back,onwards,supplies);
	}
/*
	@Test
	public void should_GetDirections() throws Exception {
		assertThat(temporaryLocation.getDirections()).containsExactly(back,onwards);
	}*/

/*	@Test
	public void shouldFindSupplies(){
		assertThat(temporaryLocation.scavenge()).isEqualTo(supplies);
	}*/

}