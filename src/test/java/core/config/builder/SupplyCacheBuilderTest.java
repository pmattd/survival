package core.config.builder;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import core.area.supplies.SupplyCache;
import core.area.supplies.Supplies;
import core.area.supplies.SupplyCacheFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import core.config.xml.areas.SuppliesConfig;

public class SupplyCacheBuilderTest {

	private SupplyCacheBuilder supplyCacheBuilder;

	@Mock
	TextFactory textFactory;

	@Mock
	SuppliesConfig suppliesConfig;

	@Mock
	SupplyCacheFactory supplyCacheFactory;

	@Mock
	SupplyCache supplyCache;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		supplyCacheBuilder = new SupplyCacheBuilder(textFactory, supplyCacheFactory);
	}

	@Test
	public void should_Build_noSupplies() throws Exception {
		when(supplyCacheFactory.emptyCache()).thenReturn(supplyCache);
		SupplyCache supplies = supplyCacheBuilder.build(null);
		assertThat(supplies).isEqualTo(supplyCache);
	}

	@Test
	public void should_build_supplies(){
		when(supplyCacheFactory.build(any(Supplies.class))).thenReturn(supplyCache);
		SupplyCache supplyCache2 = supplyCacheBuilder.build(suppliesConfig);
		assertThat(supplyCache2).isEqualTo(supplyCache);
	}

}