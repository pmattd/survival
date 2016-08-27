package core.config.builder;

import static java.util.Arrays.asList;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Collections;

import core.area.scavenge.ScavengeLocationOptionsFactory;
import core.config.builder.travel.DirectionBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import core.area.Area;
import core.area.travel.Direction;
import core.area.Location;
import core.config.xml.areas.AreaConfig;
import core.config.xml.areas.DirectionConfig;
import core.config.xml.areas.LocationConfig;
import core.config.xml.narrative.interaction.TextConfig;

/**
 * Created by Pete on 06/06/2016.
 */
public class AreaFactoryTest {

	AreaFactory areaFactory;

	@Mock
	DirectionBuilder directionBuilder;

	@Mock
	TextFactory textFactory;

	@Mock
	AreaConfig areaConfig;

	@Mock
	TextConfig textConfig;

	@Mock
	DirectionConfig directionConfig;

	@Mock
	Direction direction;

	@Mock
	LocationFactory locationFactory;

	@Mock
	Location location;

	@Mock
	private LocationConfig locationConfig;


	@Mock
	private ScavengeLocationOptionsFactory scavengeLocationOptionsFactory;


	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		areaFactory = new AreaFactory(directionBuilder, textFactory, locationFactory, scavengeLocationOptionsFactory);
	}

	@Test
	public void testBuildCache() throws Exception {

		when(areaConfig.getId()).thenReturn("id1");
		when(areaConfig.getLocations()).thenReturn(asList(locationConfig));
		Area area1 = areaFactory.build(areaConfig);
		Area area2 = areaFactory.build(areaConfig);

		assertThat(area1).isEqualTo(area2);
	}

	@Test
	public void testBuild() throws Exception {

		when(areaConfig.getId()).thenReturn("id1");
		when(areaConfig.getDesc()).thenReturn(textConfig);
		when(textFactory.build(textConfig)).thenReturn("defaultText");
		when(areaConfig.getDirections()).thenReturn(asList(directionConfig));
		when(directionBuilder.build(directionConfig, areaFactory)).thenReturn(direction);

		when(areaConfig.getLocations()).thenReturn(asList(locationConfig));
		when(locationFactory.build(any(LocationConfig.class), any(Area.class))).thenReturn(location);

		Area area = areaFactory.build(areaConfig);

		assertThat(area.getText()).isEqualTo("defaultText");
		assertThat(area.getDirections()).hasSize(1);
		assertThat(area.getDirections().get(0)).isEqualTo(direction);

	}

	@Test(expected = ConfigBuildException.class)
	public void testBuildNoDirectionsNoLocations() throws Exception {
		when(areaConfig.getLocations()).thenReturn(Collections.emptyList());
		areaFactory.build(areaConfig);

	}

}