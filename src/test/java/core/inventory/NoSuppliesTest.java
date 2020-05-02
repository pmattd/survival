package core.inventory;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

import core.area.supplies.NoSupplies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import core.translations.TranslationConstants;
import core.translations.Translations;

public class NoSuppliesTest {

	NoSupplies noSupplies;

	@Mock
	Translations translations;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		when(translations.getTranslation(TranslationConstants.SCAVENGE_NO_SUPPLIES)).thenReturn("no supplies");
		noSupplies = new NoSupplies(translations);
	}

	@Test
	public void should_GetFood() throws Exception {
		assertThat(noSupplies.getFood()).isEqualTo(0);
	}

	@Test
	public void should_GetScavengeText() throws Exception {
		assertThat(noSupplies.getScavengeText()).isEqualTo("no supplies");
	}

}