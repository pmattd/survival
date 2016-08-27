package core.config.builder;

import static com.google.common.collect.Lists.newArrayList;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

import core.area.relocation.RelocationOptionsFactory;
import core.area.travel.ArrivalActionFactory;
import core.area.travel.TravelActionFactory;
import core.config.builder.travel.TravelOptionsFactory;
import core.dialog.DialogStore;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import core.area.Area;
import core.area.Location;
import core.config.xml.areas.LocationConfig;
import core.config.xml.narrative.interaction.TextConfig;

public class LocationFactoryTest {


	LocationFactory locationFactory;


	@Mock
	TextFactory textFactory;

	@Mock
	LocationConfig locationConfig;

	@Mock
	SupplyCacheBuilder supplyCacheBuilder;

	@Mock
	Area area;

	@Mock
	TextConfig textConfig;

	@Mock
	TravelActionFactory travelActionFactory;

	@Mock
	DialogStore dialogStore;

	@Mock
	ArrivalActionFactory arrivalActionFactory;

	@Mock
	TravelOptionsFactory travelOptionsFactory;

	@Mock
	RelocationOptionsFactory relocationOptionsFactory;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		locationFactory = new LocationFactory(textFactory, supplyCacheBuilder, dialogStore, arrivalActionFactory, travelOptionsFactory, relocationOptionsFactory);
	}


	@Test
	public void testBuild() throws Exception {
		when(locationConfig.getDesc()).thenReturn(textConfig);
		when(textFactory.build(textConfig)).thenReturn("hello");

		Location location = locationFactory.build(locationConfig, area);
		assertThat(location.getDescription().getLocationDescription()).isEqualTo("hello");
	}


}