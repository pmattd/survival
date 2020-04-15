package core.boundary.options;

import core.translations.Translations;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Pete on 27/08/2016.
 */
public class InterfaceOptionsStoreTest {

    private InterfaceOptionsStore interfaceOptionsStore;

    @Mock
    private Translations translations;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(translations.getTranslation(anyString())).thenReturn("translation");
        interfaceOptionsStore = new InterfaceOptionsStore(translations);
    }

    @Test
    public void getOption() throws Exception {
        OptionCategory optionCategory = interfaceOptionsStore.getOption(OptionCatagoryEnum.CREATEHERO);
        assertThat(optionCategory.getDescription()).isEqualTo("translation");
        assertThat(optionCategory.getOptionType()).isEqualTo(OptionCatagoryEnum.CREATEHERO);
    }


    @Test(expected = OptionDoesNotExistException.class)
    public void getNothingOption() throws Exception {
        OptionCategory optionCategory = interfaceOptionsStore.getOption(OptionCatagoryEnum.NOTHING);
    }

}